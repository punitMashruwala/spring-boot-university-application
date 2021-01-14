package com.example.mongo_task.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Document(collection="Faculty")
public class faculty {
	@Id
	private int id;
	@NotNull(message="Name should not be Empty")
	private String name;
	@Email(message="Email format is wrong.")
	private String email;
	private String post;
	private String qualification;
	private String[] reasearchArea;
	private int experience;
	public String[] currentCourse;
	private String dateOfBirth;
	

	public int getId() {
		return id;
	}	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	
	public String[] getReasearchArea() {
		return reasearchArea;
	}
	public void setReasearchArea(String[] reasearchArea) {
		this.reasearchArea = reasearchArea;
	}
	
	public String[] getCurrentCourse() {
		return currentCourse;
	}
	public void setCurrentCourse(String[] currentCourse) {
		this.currentCourse = currentCourse;
	}
	
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
}
