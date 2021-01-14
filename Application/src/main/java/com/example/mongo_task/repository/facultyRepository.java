package com.example.mongo_task.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.mongo_task.model.faculty;


public interface facultyRepository extends MongoRepository<faculty, Integer>{
	
}
