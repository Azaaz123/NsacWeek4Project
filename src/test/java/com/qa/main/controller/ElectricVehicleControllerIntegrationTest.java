package com.qa.main.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.main.entities.ElectricVehicle;

@SpringBootTest
@AutoConfigureMockMvc // Allows us to send mock request using MockMvc
@Sql(scripts = {"classpath:testschema.sql","classpath:testdata.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test") // switch to test profile (H2 database)
public class ElectricVehicleControllerIntegrationTest {

	@Autowired
	private MockMvc mvc;	// This is for send Mock requests
	
	@Autowired
	private ObjectMapper mapper; // Is for converting to and from JSon data
	
	@Test
	public void createTest() throws Exception {
//	     An Object for sending in the body in the request 		
			ElectricVehicle input = new ElectricVehicle("Testla", "S", 2020, 350);
			String inputAsJSON = mapper.writeValueAsString(input); 

			// An object for checking response
			 ElectricVehicle response = new ElectricVehicle(2L, "Testla", "S", 2020, 350);
				String responseAsJSON = mapper.writeValueAsString(response); 
			
			 
			 mvc.perform(post("/create")
					.contentType(MediaType.APPLICATION_JSON)
					.content(inputAsJSON))
					.andExpect(status().isCreated())
					.andExpect(content().json(responseAsJSON));
				
		}
		
	@Test
	public void updateTest() throws Exception {
//		     An Object for sending in the body in the request 		
				ElectricVehicle input = new ElectricVehicle("Testla", "S", 2020, 350);
				String inputAsJSON = mapper.writeValueAsString(input); 

				// An object for checking response
				 ElectricVehicle response = new ElectricVehicle(1L,"Testla", "S", 2020, 350);
					String responseAsJSON = mapper.writeValueAsString(response); 
				
				 
				 mvc.perform(put("/update/1")
						.contentType(MediaType.APPLICATION_JSON)
						.content(inputAsJSON))
						.andExpect(status().isOk())
						.andExpect(content().json(responseAsJSON));
					
			}
	
	
	
	@Test
	public void getAllTest() throws Exception  {
		//Created a List
			List<ElectricVehicle> result = new ArrayList<>();
	// Added my expected ElectricVehicle to the list
			result.add(new ElectricVehicle(1L,"Kia", "EV6", 2022, 313));
			
			String resultAsJSON = mapper.writeValueAsString(result); 
			
			mvc.perform(get("/getAll")
					.contentType(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk())
					.andExpect(content().json(resultAsJSON));
					
	}
	
	@Test
	public void getByIdTest() {
		
	}
	
	@Test
	public void getByCarMakeTest() {
	}
	
	@Test
	public void getByCarModeltest() {
	}
	
	
	
	@Test
	public void getByReleaseYear() {
	}
	
	
	@Test
	public void getByMileRangeGreaterThan(){
	}
	
	
	@Test
	public void deleteTet(){
	}
	
	

}
	

