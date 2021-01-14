package com.example.mongo_task.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Document(collection="Course")
public class course {
	@Id
	public int id;
	@NotNull(message="Name should not be Empty")
	public String name;
	private String day;
	private String time;
	private String conductedBy;
	@NotNull(message="Course Credit should not be Empty")
	private int courseCredit;
	@PositiveOrZero(message="Capacity should not be Negative")
	private int capacity;
	@PositiveOrZero(message="Capacity Active should not be Negative")
	private int active;
	@PositiveOrZero(message="Capacity Remaining should not be Negative")
	private int remaining;
	@PositiveOrZero(message="Waitlist Capacity should not be Negative")
	private int waitlistCapacity;
	@PositiveOrZero(message="Waitlist Capacity Active should not be Negative")
	private int waitlistActive;
	@PositiveOrZero(message="Waitlist Capacity Remaining should not be Negative")
	private int waitlistRemaining;
	public String[] student;
	
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

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public int getCourseCredit() {
		return courseCredit;
	}

	public void setCourseCredit(int courseCredit) {
		this.courseCredit = courseCredit;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public int getRemaining() {
		return remaining;
	}

	public void setRemaining(int remaining) {
		this.remaining = remaining;
	}

	public int getWaitlistCapacity() {
		return waitlistCapacity;
	}

	public void setWaitlistCapacity(int waitlistCapacity) {
		this.waitlistCapacity = waitlistCapacity;
	}

	public int getWaitlistActive() {
		return waitlistActive;
	}

	public void setWaitlistActive(int waitlistActive) {
		this.waitlistActive = waitlistActive;
	}

	public int getWaitlistRemaining() {
		return waitlistRemaining;
	}

	public void setWaitlistRemaining(int waitlistRemaining) {
		this.waitlistRemaining = waitlistRemaining;
	}

	public String[] getStudent() {
		return student;
	}

	public void setStudent(String[] student) {
		this.student = student;
	}

	public String getConductedBy() {
		return conductedBy;
	}

	public void setConductedBy(String conductedBy) {
		this.conductedBy = conductedBy;
	}
}
