package com.example.mongo_task.resource;

import java.util.*; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mongo_task.exception_handling.ResourceNotFoundException;
import com.example.mongo_task.model.course;
import com.example.mongo_task.model.faculty;
import com.example.mongo_task.model.student;
import com.example.mongo_task.repository.courseRepository;
import com.example.mongo_task.repository.facultyRepository;
import com.example.mongo_task.repository.studentRepository;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value= "/api")

public class courseRegistration {
	@Autowired
	private studentRepository repositoryStudent;
	@Autowired
	private courseRepository repositoryCourse;
	@Autowired
	private facultyRepository repositoryFaculty;
	
	@ApiOperation(value = "Update a Faculty Name in the Course record", response = course.class, tags = "updateFacultyInfoInCourse")
	@PutMapping("/registration/updateFacultyName")
	public String updateFacutlyName(@RequestBody com.example.mongo_task.model.courseRegistration c) {
		// Fetch if course data is present or not
		Optional<course> courseData = this.repositoryCourse.findById(c.getCourseId());
		// Fetch Faculty Data
		Optional<faculty> facultyData = this.repositoryFaculty.findById(c.getFacultyId());
		
		if(courseData.isPresent() || facultyData.isPresent()) {
			// Set faculty name in conductedBy field
			courseData.get().setConductedBy(c.getFacultyName());
			courseData.get().setCapacity(c.getCourseCapacity());
			courseData.get().setWaitlistCapacity(c.getWaitlistCapacity());
			courseData.get().setCourseCredit(c.getCourseCredit());
			// Save Course
			this.repositoryCourse.save(courseData.get());
			
			
			
			//Add course name in the current course array
			List<String> courseData1 = new ArrayList<String>();
			for (int i = 0; i < facultyData.get().currentCourse.length; i++) {
				courseData1.add(facultyData.get().currentCourse[i]);
			}
			courseData1.add(c.getCourseName());
			String[] stringArray = courseData1.toArray(new String[0]);
			facultyData.get().setCurrentCourse(stringArray);
			
			// Save Faculty data
			this.repositoryFaculty.save(facultyData.get());
			
			// Return Response
			return "Course Info updated successfully!";
			
		} else {
			if(courseData.isPresent()) {
				throw new ResourceNotFoundException("Faculty Record not found with id: " + c.getFacultyId());				
			} else {
				throw new ResourceNotFoundException("Course Record not found with id: " + c.getCourseId());				
			}
		}
	}
	
	@ApiOperation(value = "Student will try to Register a Course", response = course.class, tags = "courseRegistration")
	@PutMapping("/registration/courseRegistration")
	public String updateCapacityCount(@RequestBody com.example.mongo_task.model.courseRegistration c) {
		// Fetch if course data is present or not
		Optional<course> courseData = this.repositoryCourse.findById(c.getCourseId());
		// Fetch Student Data
		Optional<student> studentData = this.repositoryStudent.findById(c.getStudentId());
		
		if(courseData.isPresent() && studentData.isPresent()) {
			// Check if student has register less than 4 course
			
			if(studentData.get().courseTaken.length < 4) {
				int capacity = courseData.get().getCapacity();
				int active = courseData.get().getActive();
				if(capacity > active) {
					active = active + 1;
					int remain = capacity - active;
					courseData.get().setActive(active);
					courseData.get().setRemaining(remain);
					//Add Student name in the Student array
					List<String> arrayData = new ArrayList<String>();
					if(courseData.get().getStudent().length != 0 || courseData.get().student != null || courseData.get().student.length > 0 ) {
						for (int i = 0; i < courseData.get().student.length; i++) {
							arrayData.add(courseData.get().student[i]);
						}
					}
					
					arrayData.add(c.getStudentName());
					System.out.print(arrayData);
					String[] stringArray = arrayData.toArray(new String[0]);
					courseData.get().setStudent(stringArray);
					
					
					// Save Course
					this.repositoryCourse.save(courseData.get());
					
					
					//Add course name in the current course array
					List<String> studentDataArray = new ArrayList<String>();
					if(studentData.get().courseTaken != null || studentData.get().courseTaken.length > 0) {
						for (int i = 0; i < studentData.get().courseTaken.length; i++) {
							studentDataArray.add(studentData.get().courseTaken[i]);
						}					
					}
					studentDataArray.add(c.getCourseName());
					String[] sArray = studentDataArray.toArray(new String[0]);
					studentData.get().setCourseTaken(sArray);
					
					// Save Faculty data
					this.repositoryStudent.save(studentData.get());
					
					// Return Response
					return "Course Registered successfully ";
				} else {
					throw new ResourceNotFoundException("Course is Already full!");
				}
			} else {
				throw new ResourceNotFoundException("You cannot registered Course more than 4! ");
			}
			
		} else {
			if(courseData.isPresent()) {
				throw new ResourceNotFoundException("Student Record not found with id: " + c.getStudentId());
			} else {
				throw new ResourceNotFoundException("Course Record not found with id: " + c.getCourseId());
			}
			
		}
	}
	
	

	@ApiOperation(value = "Student will try to Drop a Course",  response = course.class, tags = "courseDrop")
	@PutMapping("/registration/courseDrop")
	public String updateCapacityCountDrop(@RequestBody com.example.mongo_task.model.courseRegistration c) {
		// Fetch if course data is present or not
		Optional<course> courseData = this.repositoryCourse.findById(c.getCourseId());
		// Fetch Student Data
		Optional<student> studentData = this.repositoryStudent.findById(c.getStudentId());
		
		if(courseData.isPresent() && studentData.isPresent()) {
			// Find if student is in the array
			List<String> arrayData = new ArrayList<String>();
			if(courseData.get().getStudent().length != 0 || courseData.get().student != null || courseData.get().student.length > 0 ) {
				for (int i = 0; i < courseData.get().student.length; i++) {
					arrayData.add(courseData.get().student[i]);
				}
			}
			int index = arrayData.indexOf(c.getStudentName());
			if(index != -1) {
				arrayData.remove(index);
				int capacity = courseData.get().getCapacity();
				int active = courseData.get().getActive();
				active = active - 1;
				int remain = capacity - active;
				courseData.get().setActive(active);
				courseData.get().setRemaining(remain);
				String[] stringArray = arrayData.toArray(new String[0]);
				courseData.get().setStudent(stringArray);
				// Save Course
				this.repositoryCourse.save(courseData.get());
				
				//Remove course name from the current course array
				List<String> studentDataArray = new ArrayList<String>();
				if(studentData.get().courseTaken != null || studentData.get().courseTaken.length > 0) {
					for (int i = 0; i < studentData.get().courseTaken.length; i++) {
						studentDataArray.add(studentData.get().courseTaken[i]);
					}					
				}
				int CourseIndex = studentDataArray.indexOf(c.getCourseName());
				if(CourseIndex != -1) {
					studentDataArray.remove(CourseIndex);
				}
				String[] sArray = studentDataArray.toArray(new String[0]);
				studentData.get().setCourseTaken(sArray);
				
				// Save Faculty data
				this.repositoryStudent.save(studentData.get());
				
				// Return Response
				return "Course Dropped successfully ";
				
			} else {
				throw new ResourceNotFoundException("You have already dropped the course: " + c.getCourseName());
			}
		} else {
			if(courseData.isPresent()) {
				throw new ResourceNotFoundException("Student Record not found with id: " + c.getStudentId());
			} else {
				throw new ResourceNotFoundException("Course Record not found with id: " + c.getCourseId());
			}
			
		}
	}

}
