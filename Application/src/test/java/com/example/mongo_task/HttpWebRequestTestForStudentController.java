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


public class HttpWebRequestTestForStudentController {
	@Autowired
	private MockMvc mockMvc;
	
	public String mockStudent = "{\n    \"id\": 42,\n    \"name\": \"ABCD\",\n    \"type\": \"Masters\",\n    \"major\": \"Computer Science\",\n    \"concentration\": \"Software Engineer\",\n    \"address\": \"95000 Apt A\",\n    \"city\": \"Charlotte\",\n    \"state\": \"North Carolina\",\n    \"country\": \"US\",\n    \"pincode\": 28200,\n    \"dateOfBirth\": \"05/11/1990\",\n    \"courseCompleted\" : [\"Data Structure and Algorithms\", \"Big Data for computer advantage\", \"Knowledge Discovery in Database\"],\n    \"courseTaken\": [\"Intelligent System\", \"Mobile Application Development\", \"Cloud Computing\"],\n    \"currentGPA\": \"4\"\n\n}";
	
	@Test
	public void shouldReceiveSuccessFromPost() throws Exception {
		this.mockMvc.perform(post("/api/student/add")
		.contentType(MediaType.APPLICATION_JSON)
        .characterEncoding("UTF-8")
        .content(mockStudent))
        .andDo(print())
        .andExpect(status().isOk());
	}
	
	@Test
	public void shouldReceiveSuccessFromGet() throws Exception {
		this.mockMvc.perform(get("/api/student/findAll")).andDo(print()).andExpect(status().isOk())
		.andExpect(content().contentType("application/json"));
	}
	
	@Test
	public void shouldReceiveSuccessFromGetById() throws Exception {
		this.mockMvc.perform(get("/api/student/findOne/3")).andDo(print()).andExpect(status().isOk())
		.andExpect(content().contentType("application/json"));
	}
	
	
	
	@Test
	public void shouldReceiveSuccessFromPut() throws Exception {
		this.mockMvc.perform(put("/api/student/update/3")
				.contentType(MediaType.APPLICATION_JSON)
		        .characterEncoding("UTF-8")
		        .content(mockStudent))
		.andExpect(status().isOk()).andReturn();
	}
}
