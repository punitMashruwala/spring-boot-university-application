package com.example.mongo_task.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class courseRegistration {
	public int CourseId;
	public int StudentId;
	public int FacultyId;
	public String StudentName;
	public String FacultyName;
	public String CourseName;
	public int CourseCapacity;
	public int CourseCredit;
	public int WaitlistCapacity;
	
	
	public int getCourseId() {
		return CourseId;
	}
	public void setCourseId(int courseId) {
		CourseId = courseId;
	}
	

	public int getWaitlistCapacity() {
		return WaitlistCapacity;
	}
	public void setWaitlistCapacity(int waitlistCapacity) {
		WaitlistCapacity = waitlistCapacity;
	}

	public int getCourseCapacity() {
		return CourseCapacity;
	}
	public void setCourseCapacity(int courseCapacity) {
		CourseCapacity = courseCapacity;
	}

	public int getCourseCredit() {
		return CourseCredit;
	}
	public void setCurseCredit(int courseCredit) {
		CourseCredit = courseCredit;
	}
	
	public int getStudentId() {
		return StudentId;
	}
	public void setStudentId(int studentId) {
		StudentId = studentId;
	}
	public int getFacultyId() {
		return FacultyId;
	}
	public void setFacultyId(int facultyId) {
		FacultyId = facultyId;
	}
	public String getStudentName() {
		return StudentName;
	}
	public void setStudentName(String studentName) {
		StudentName = studentName;
	}
	public String getFacultyName() {
		return FacultyName;
	}
	public void setFacultyName(String facultyName) {
		FacultyName = facultyName;
	}
	public String getCourseName() {
		return CourseName;
	}
	public void setCourseName(String courseName) {
		CourseName = courseName;
	}
	
	
}
