package com.example.mongo_task.resource;

import java.util.List;
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
import com.example.mongo_task.model.student;
import com.example.mongo_task.repository.studentRepository;

import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping(value= "/api")
public class studentController {

	@Autowired
	private studentRepository repository;
	
	@ApiOperation(value = "Add Single Students info to the database", response = student.class, tags = "addStudentInfo")
	@PostMapping("/student/add")
	public String saveStudentInfo(@Valid @RequestBody student stud) {
		repository.save(stud);
		return "Student Info save successfully with id: " + stud.getId();
	}
	
	@ApiOperation(value = "Get All Students info from the database", response = student.class, tags = "getAllStudentInfo")
	@GetMapping("/student/findAll")
	public List<student> getAllStudentInfo(){
		return  repository.findAll();
	}
	
	@ApiOperation(value = "Get Single Students info from the database", response = student.class, tags = "getStudentInfoById")
	@GetMapping("/student/findOne/{id}")
	public student getStudentInfo(@PathVariable int id) throws ResourceNotFoundException{
		return this.repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student Record not found with id: " + id));
		
	}
	
	@ApiOperation(value = "Delete Single Students info from the database", response = student.class, tags = "deleteStudentInfoById")
	@DeleteMapping("/student/delete/{id}")
	public String deleteStudentId(@PathVariable int id) {
		this.repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student Record not found with id: " + id));
		repository.deleteById(id);
		return "Successfully deleted Student with id: " + id;
	}
	
	@ApiOperation(value = "Update Single Students info from the database", response = student.class, tags = "updateStudentInfoById")
	@PutMapping("/student/update/{id}")
	public String updateStudentId(@Valid @RequestBody student stud, @PathVariable int id) {
		this.repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student Record not found with id: " + id));
		stud.setId(id);
		this.repository.save(stud);
		return "Student Info updated successfully with id: " + stud.getId();
		
	}
	
}
