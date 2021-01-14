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
import com.example.mongo_task.model.faculty;
import com.example.mongo_task.model.student;
import com.example.mongo_task.repository.facultyRepository;

import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping(value= "/api")
public class facultyController {

	@Autowired
	private facultyRepository repository;
	
	@ApiOperation(value = "Add Faculty info to the database", response = faculty.class, tags = "addFacultyInfo")
	@PostMapping("/faculty/add")
	public String saveFacultyInfo(@Valid @RequestBody faculty f) {
		repository.save(f);
		return "Faculty Info save successfully with id: " + f.getId();
	}

	@ApiOperation(value = "Find all Faculty info from the database", response = faculty.class, tags = "getAllFacultyInfo")
	@GetMapping("/faculty/findAll")
	public List<faculty> getAllFacultyInfo(){
		return  repository.findAll();
	}
	

	@ApiOperation(value = "Find a Faculty info from the database", response = faculty.class, tags = "getOneFacultyInfo")
	@GetMapping("/faculty/findOne/{id}")
	public faculty getFacultyInfo(@PathVariable int id){
		return this.repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Faculty Record not found with id: " + id));
	}

	@ApiOperation(value = "Delete a Faculty info from the database", response = faculty.class, tags = "deleteOneFacultyInfo")
	@DeleteMapping("/faculty/delete/{id}")
	public String deleteFacultyId(@PathVariable int id) {
		repository.deleteById(id);
		return "Successfully deleted Student with id: " + id;
	}
	
	@ApiOperation(value = "Update a Faculty info from the database", response = faculty.class, tags = "updateOneFacultyInfo")
	@PutMapping("/faculty/update/{id}")
	public String updateFacultyId(@Valid @RequestBody faculty f, @PathVariable int id) {
		this.repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Faculty Record not found with id: " + id));
		f.setId(id);
		repository.save(f);
		return "Faculty Info updated successfully with id: " + f.getId();
		
	}
	
}
