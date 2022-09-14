package com.qa.main.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.main.entities.ElectricVehicle;
import com.qa.main.service.ElectricVehicleService;

@WebMvcTest
public class ElectricVehicleControllerUnitTest {

	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper; 
	
	@MockBean
	private ElectricVehicleService service;
	
	@Test
	public void createTest() throws Exception {
		
			ElectricVehicle input = new ElectricVehicle("Testla", "S", 2020, 350);
			String inputAsJSON = mapper.writeValueAsString(input); 

			 ElectricVehicle response = new ElectricVehicle(2L, "Testla", "S", 2020, 350);
				String responseAsJSON = mapper.writeValueAsString(response); 
			
			 Mockito.when(service.create(input)).thenReturn(response);
				
			 mvc.perform(post("/create")
					.contentType(MediaType.APPLICATION_JSON)
					.content(inputAsJSON))
					.andExpect(status().isCreated())
					.andExpect(content().json(responseAsJSON));
			 	}
		
	@Test
	public void getAllTest() throws Exception  {
		//Created a List
			List<ElectricVehicle> result = new ArrayList<>();
	// Added my expected ElectricVehicle to the list
			result.add(new ElectricVehicle(1L,"Kia", "EV6", 2022, 313));
			
			String resultAsJSON = mapper.writeValueAsString(result); 
			
			Mockito.when(service.getAll()).thenReturn(result);
			
			mvc.perform(get("/getAll")
					.contentType(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk())
					.andExpect(content().json(resultAsJSON));
					
	}

	@Test
	public void getByIdTest() throws Exception {
		ElectricVehicle result = new ElectricVehicle(1L,"Kia", "EV6", 2022, 313);
		
		String resultAsJSON = mapper.writeValueAsString(result); 
		
		Mockito.when(service.getById(1L)).thenReturn(result);
		
		mvc.perform(get("/getById/1")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().json(resultAsJSON));
	}

	@Test
	public void getByCarMakeTest() throws Exception {
		List<ElectricVehicle> result = new ArrayList<>();
		result.add(new ElectricVehicle(1L,"Kia", "EV6", 2022, 313));
		
		String resultAsJSON = mapper.writeValueAsString(result); 
		
		Mockito.when(service.getByCarMake("Kia")).thenReturn(result);
		
		mvc.perform(get("/getByCarMake/Kia")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().json(resultAsJSON));
	}	
	
	@Test
	public void getByCarModeltest() throws Exception {
		List<ElectricVehicle> result = new ArrayList<>();
		result.add(new ElectricVehicle(1L,"Kia", "EV6", 2022, 313));
		
		String resultAsJSON = mapper.writeValueAsString(result); 
		
		Mockito.when(service.getByCarModel("EV6")).thenReturn(result);
		
		mvc.perform(get("/getByCarModel/EV6")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().json(resultAsJSON));
	}
	
	
	@Test
	public void getByReleaseYear() throws Exception  {
		List<ElectricVehicle> result = new ArrayList<>();
		result.add(new ElectricVehicle(1L,"Kia", "EV6", 2022, 313));
		
		String resultAsJSON = mapper.writeValueAsString(result); 
		
		Mockito.when(service.getByReleaseYear(2022)).thenReturn(result);
		
		mvc.perform(get("/getByReleaseYear/2022")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().json(resultAsJSON));	
		
	}
	
	@Test
	public void getByMileRangeGreaterThan() throws Exception {
		List<ElectricVehicle> result = new ArrayList<>();
		result.add(new ElectricVehicle(1L,"Kia", "EV6", 2022, 313));
		
		String resultAsJSON = mapper.writeValueAsString(result); 
		
		Mockito.when(service.getByMileRangeGreaterThan(300)).thenReturn(result);

		
		mvc.perform(get("/getByMileRangeGreaterThan/300")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().json(resultAsJSON));	
	
	}
	
	@Test
	public void deleteTet() throws Exception {
		
		Mockito.when(service.delete(1L)).thenReturn(true);
		
		 mvc.perform(delete("/delete/1")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string("true"));	
		
	}
	
	
	
	
}
