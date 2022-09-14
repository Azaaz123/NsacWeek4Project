package com.qa.main.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
		
}
