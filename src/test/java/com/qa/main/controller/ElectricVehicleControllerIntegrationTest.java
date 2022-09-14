package com.qa.main.controller;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;

@SpringBootTest
@AutoConfigureMockMvc // Allows us to send mock request using MockMvc
@Sql(scripts = {"classpath:testschema.sql","classpath:testdata.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test") // switch to test profile (H2 database)
public class ElectricVehicleControllerIntegrationTest {

	
	
}
