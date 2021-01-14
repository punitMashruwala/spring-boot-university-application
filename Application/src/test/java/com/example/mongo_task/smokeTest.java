package com.example.mongo_task;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.mongo_task.resource.courseRegistration;
import com.example.mongo_task.resource.courseController;
import com.example.mongo_task.resource.facultyController;
import com.example.mongo_task.resource.studentController;

@SpringBootTest
class smokeTest {

	@Autowired
	private courseController CourseCont;
	@Autowired
	private studentController StudCont;
	@Autowired
	private courseRegistration CourseRegCont;
	@Autowired
	private facultyController FactCont;
	
	
	@Test
	void contextLoads() {
		assertThat(CourseCont).isNotNull();
		assertThat(StudCont).isNotNull();
		assertThat(CourseRegCont).isNotNull();
		assertThat(FactCont).isNotNull();
	}

}
