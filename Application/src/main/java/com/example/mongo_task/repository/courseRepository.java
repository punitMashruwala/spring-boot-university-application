package com.example.mongo_task.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Component;

import com.example.mongo_task.model.course;

public interface courseRepository extends MongoRepository<course, Integer>{
	
}
