package com.example.mongo_task.resource;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mongo_task.exception_handling.ResourceNotFoundException;
import com.example.mongo_task.model.course;
import com.example.mongo_task.model.student;
import com.example.mongo_task.repository.courseRepository;

import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping(value= "/api")
public class courseController {

	@Autowired
	private courseRepository repository;

	@ApiOperation(value = "Add Course info to the database", response = course.class, tags = "addCourseInfo")
	@PostMapping("/course/add")
	public String saveCourse(@Valid @RequestBody course c) {
		repository.save(c);
		return "Course Info save successfully with id: " + c.getId();
	}
	
	@ApiOperation(value = "Find all Course info from the database", response = course.class, tags = "getAllCourseInfo")
	@GetMapping("/course/findAll")
	public List<course> getAllCourseInfo(){
		return  repository.findAll();
	}
	
	@ApiOperation(value = "Find a Course info from the database", response = course.class, tags = "findOneCourseInfo")
	@GetMapping("/course/findOne/{id}")
	public course getCourseInfo(@PathVariable int id){
		return this.repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Course Record not found with id: " + id));
	}
	
	@ApiOperation(value = "Delete a Course info from the database", response = course.class, tags = "deleteOneCourseInfo")
	@DeleteMapping("/course/delete/{id}")
	public String deleteCourseId(@PathVariable int id) {
		repository.deleteById(id);
		return "Successfully deleted Course with id: " + id;
	}
	
	@ApiOperation(value = "Update a Course info from the database", response = course.class, tags = "updateOneCourseInfo")
	@PutMapping("/course/update/{id}")
	public String updateCourseId(@Valid @RequestBody course c, @PathVariable int id) {
		this.repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Course Record not found with id: " + id));
		c.setId(id);
		repository.save(c);
		return "Course Info updated successfully with id: " + c.getId();
		
	}
	
}
