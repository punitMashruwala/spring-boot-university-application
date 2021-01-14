package com.example.mongo_task.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter	
@ToString


@Document(collection="Student")
public class student {
	@Id
	private int id;
	@NotNull(message="Name should not be Empty")
	private String name;
	@Email(message="Email format is wrong.")
	private String email;
	private String type;
	private String major;
	private String concentration;
	private String address;
	private String city;
	private String state;
	private String country;
	private long pincode;
	private String dateOfBirth;
	private String[] courseCompleted;
	
	public String[] courseTaken;
	private String currentGPA;
	
	public student(int id, @NotNull(message = "Name should not be Empty") String name,
			@Email(message = "Email format is wrong.") String email, String type, String major, String concentration,
			String address, String city, String state, String country, long pincode, String dateOfBirth,
			String[] courseCompleted, String[] courseTaken, String currentGPA) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.type = type;
		this.major = major;
		this.concentration = concentration;
		this.address = address;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
		this.dateOfBirth = dateOfBirth;
		this.courseCompleted = courseCompleted;
		this.courseTaken = courseTaken;
		this.currentGPA = currentGPA;
	}


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
	
	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getConcentration() {
		return concentration;
	}

	public void setConcentration(String concentration) {
		this.concentration = concentration;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public long getPincode() {
		return pincode;
	}

	public void setPincode(long pincode) {
		this.pincode = pincode;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String[] getCourseCompleted() {
		return courseCompleted;
	}

	public void setCourseCompleted(String[] courseCompleted) {
		this.courseCompleted = courseCompleted;
	}

	public String[] getCourseTaken() {
		return courseTaken;
	}

	public void setCourseTaken(String[] courseTaken) {
		this.courseTaken = courseTaken;
	}

	public String getCurrentGPA() {
		return currentGPA;
	}

	public void setCurrentGPA(String currentGPA) {
		this.currentGPA = currentGPA;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
