package com.example.mongo_task.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.mongo_task.model.student;

public interface studentRepository extends MongoRepository<student, Integer>{

}
