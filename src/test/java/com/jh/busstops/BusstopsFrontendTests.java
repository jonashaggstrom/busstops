package com.jh.busstops;

import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import com.jh.busstops.controller.BusstopsControllerThyme;

@WebMvcTest(controllers = BusstopsControllerThyme.class)
class BusstopsFrontendTests {
	
	
	@Autowired
	private MockMvc mockMvc;

//	@Test
//	public void testHomePage() throws Exception {
//		mockMvc.perform(get("/index.html"))
//				.andExpect(content().string(containsString("Counting bus stops")));
//	}

//	@Test
//	public void testBusStops() throws Exception {
//		mockMvc.perform(get("/busstopsthyme"))
//				.andExpect(content().string(containsString("Stop Names")));
//	}

}
