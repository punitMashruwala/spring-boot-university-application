package com.example.mongo_task;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.http.MediaType;
@SpringBootTest
@AutoConfigureMockMvc


public class HttpWebRequestTestForCourseController {
	@Autowired
	private MockMvc mockMvc;
	
	public String mockCourse = "{\n    \"id\": 100,\n    \"name\": \"Data Structure\",\n    \"day\": \"Tuesday\",\n    \"time\": \"2.30-5.00\",\n    \"courseCredit\": 0,\n    \"capacity\": 0,\n    \"active\": 0,\n    \"remaining\": 0,\n    \"waitlistCapacity\": 0,\n    \"waitlistActive\": 0,\n    \"waitlistRemaining\": 0\n\n}";
	
	@Test
	public void shouldReceiveSuccessFromPost() throws Exception {
		this.mockMvc.perform(post("/api/course/add")
		.contentType(MediaType.APPLICATION_JSON)
        .characterEncoding("UTF-8")
        .content(mockCourse))
        .andDo(print())
        .andExpect(status().isOk());
	}
	
	@Test
	public void shouldReceiveSuccessFromGet() throws Exception {
		this.mockMvc.perform(get("/api/course/findAll")).andDo(print()).andExpect(status().isOk())
		.andExpect(content().contentType("application/json"));
	}
	
	@Test
	public void shouldReceiveSuccessFromGetById() throws Exception {
		this.mockMvc.perform(get("/api/course/findOne/1")).andDo(print()).andExpect(status().isOk())
		.andExpect(content().contentType("application/json"));
	}
	
	
	
	@Test
	public void shouldReceiveSuccessFromPut() throws Exception {
		this.mockMvc.perform(put("/api/course/update/1")
				.contentType(MediaType.APPLICATION_JSON)
		        .characterEncoding("UTF-8")
		        .content(mockCourse))
		.andExpect(status().isOk()).andReturn();
	}
}
