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


public class HttpWebRequestTestForFacultyController {
	@Autowired
	private MockMvc mockMvc;

	public String mockFaculty = "{\n    \"id\": 1,\n    \"name\": \"EFGH \",\n    \"email\": \"essfsdfe@uncc.edu\",\n    \"post\": \"Associate Professor\",\n    \"qualification\": \"PHD\",\n    \"reasearchArea\": [\"Algorithms\"],\n    \"experience\": 10,\n    \"dateOfBirth\": \"19/11/1995\",\n    \"currentCourse\" : []\n\n}";
	
	@Test
	public void shouldReceiveSuccessFromPost() throws Exception {
		this.mockMvc.perform(post("/api/faculty/add")
		.contentType(MediaType.APPLICATION_JSON)
        .characterEncoding("UTF-8")
        .content(mockFaculty))
        .andDo(print())
        .andExpect(status().isOk());
	}
	
	@Test
	public void shouldReceiveSuccessFromGet() throws Exception {
		this.mockMvc.perform(get("/api/faculty/findAll")).andDo(print()).andExpect(status().isOk())
		.andExpect(content().contentType("application/json"));
	}
	
	@Test
	public void shouldReceiveSuccessFromGetById() throws Exception {
		this.mockMvc.perform(get("/api/faculty/findOne/1")).andDo(print()).andExpect(status().isOk())
		.andExpect(content().contentType("application/json"));
	}
	
	
	@Test
	public void shouldReceiveSuccessFromPut() throws Exception {
		this.mockMvc.perform(put("/api/faculty/update/1")
				.contentType(MediaType.APPLICATION_JSON)
		        .characterEncoding("UTF-8")
		        .content(mockFaculty))
		.andExpect(status().isOk()).andReturn();
	}
}
