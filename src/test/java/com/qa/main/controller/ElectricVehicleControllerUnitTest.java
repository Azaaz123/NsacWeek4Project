package com.qa.main.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
		

	
	
}
