package com.ywd.controller;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

public class AuthControllerTest {
	
	@Test
	public void testGetAuthTree() throws Exception {
		AuthController authController = new AuthController();
		MockMvc mockMvc = standaloneSetup(authController).build();
		mockMvc.perform(get("/getAuthTree"));
	}

}
