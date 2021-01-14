
# Spring Boot University Application


## Introduction

 - A small university application built on Spring Boot with MongoDB and API Documentation on Swagger.
 - In this application, there are three types of User:
  1. **Student**
  2. **Faculty**
  3. **Course**
  - This Application is capable of performing CRUD operation like:
  
  -- **Create**: 
  
			  1. User can create a Student Record
			  
			  2. User can create a Faculty Record
			  
			  3. User can create a Course Record
			  
  -- **Read**:  Read all record or by single record with the help of Id
  
			  1. User can read Student Record
			  
			  2. User can read  Faculty Record
			  
			  3. User can read  Course Record
			  
  -- **Update**:  
  
			  1. User can update a Student Record
			  
			  2. User can read  a Faculty Record
			  
			  3. User can read a Course Record
			  
  -- **Delete**:  
  
			  1. User can delete a Student Record
			  
			  2. User can delete a Faculty Record
			  
			  3. User can delete a Course Record
			  
- Along with this, User can also run API which will help a Student **Register or Drop** a Course and help Faculty to **update Course details**.


## How to run

 1.  Clone this repository
 3.   Make sure you are using current java version and Maven 3.x and check if you have [MongoDB install](https://www.mongodb.com/try/download/community)
 4.  First you need to start mongo service on your machine. Command for that is: 
`mongod`
 5. Then on another command prompt you need to run this command: 
`mongo`
 6. Once mongo is up, Open MongoDBCompass application, connect to URL: **mongodb://127.0.0.1:27017**
 7. Create a new Database with Name: **"UniversityDatabase"** and Create 3 Collection with Name: **"Student"**, **"Faculty"**, and **"Course"**
 8.  Select that Database and Collection, then from "Collection" Menu, select Import Data by selecting Json file from [**MongoDB_Dump**](https://github.com/punitMashruwala/spring-boot-university-application/tree/master/Mongo_Dump) folder from git clone.
 9.  After this step, open [Application](https://github.com/punitMashruwala/spring-boot-university-application/tree/master/Application) folder and Open **Command Prompt or Terminal**
 10.   You can build the project and run the tests by running  `mvn clean package`
 11.  Once successfully built, you can run the service by :
```` mvn spring-boot:run ````
 12.  Once Application starts and is up, it will look something like this in command prompt:
  `2021-01-13 19:47:57.507  INFO 20788 --- [  restartedMain] c.e.mongo_task.MongoTaskApplication      : Started MongoTaskApplication in 2.21 seconds (JVM running for 2.481)`

 14. Once Application is up, you can visit url: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html) in browser where you can see Swagger Api Documentation.


## Application Structure:

 - **Service Model**: In [Service model,](https://github.com/punitMashruwala/spring-boot-university-application/tree/master/Application/src/main/java/com/example/mongo_task/resource) there are Four Controller files which are used to handle business logic. This files contains functions which are used for CRUD operation and other logic.
 - **Repository Model**:  [In Repository Model](https://github.com/punitMashruwala/spring-boot-university-application/tree/master/Application/src/main/java/com/example/mongo_task/repository), Mongo Repository for different Collection is defined.
 - **DTO Model**: 
  -- Following Table displays fields which are used as a schema.
```
| Student 			| Faculty 			| Course  				|
| -----------------------------	| ------------------------------| --------------------------------	|
| id      			| id      			| id      				|
| name    			| name    			| name    				|
| email   			| email   			| day     		    		|	
| type    			| post    			| time    		    		|
| major   			| qualification     		| conductedBy       			|
| concentration    		| reasearchArea	    		| courseCredit	    			|
| address 			| experience        		| capacity	        		|
| city    			| currentCourse     		| waitlist_capacity     		|
| state 			| dateOfBirth			| active      				|
| country  			| 				| remaining    				|
| pincode 			| 				| location      			|
| dateOfBirth			| 				| student    				|
| courseCompleted		| 				| waitlist_active    			|
| courseTaken			| 				| waitlist_remaining    		|
| gpa				| 				| 					|
```

Also, model files can be check  [here](https://github.com/punitMashruwala/spring-boot-university-application/tree/master/Application/src/main/java/com/example/mongo_task/model) .
 - **Exceptional handling**: 
 
 -- In Post Api and Put Api Custom Input Parameter validation is handle. If any of the field in request body is missing or not valid then error will be thrown with Http status code **500**.
 
 -- While fetching the records, if Record is not found then error is thrown with Http Status code **404** (not found).
 
 -- If api url is not correct then error is thrown with Http Status code **400** (service_unavailable).
 
 -- Custom Error message object is created and while throwing an error, same error object is given to user. This can be checked [here](https://github.com/punitMashruwala/spring-boot-university-application/tree/master/Application/src/main/java/com/example/mongo_task/exception_handling)
 
 -- In Success scenario, Http Status code will be **200**.
 
 - **JUNIT Test cases**: Mockito is used and Have created three seperate file for three different users CRUD operation. Find it [here](https://github.com/punitMashruwala/spring-boot-university-application/tree/master/Application/src/test/java/com/example/mongo_task).

 ## Business Logic:
 - Once all records are created, **Below API** are used for Operation like Course Registration , Course Drop or Increasing/Decreasing Course Capacity.
 - **< basepath >/< port >/api/registration/updateFacultyName**:
 
 --  In this api, A faculty needs to provide **Course Id, Faculty Id, Faculty Name.**   
 
 -- With the help of three field, course and faculty records are fetched.
 
 -- If records found then in course record, fields like conductedBy, capacity and Waitlist capacity are **updated** and course name will be added in faculty record.
 
 -- Else **error** is thrown.
 
 - **< basepath >/< port >/api/registration/courseRegistration**:
 
 -- In this api, A student need to provide **Course Id, Student Id, Student Name**. -- With the help of three field, course and student record is fetched. 
 
 -- If records are present, then capacity and remaining seats are checked. 
 
 -- If Remaining Seats is not 0, then course is registered **successfully** and course name is added in the student record.  
 
 -- If Remaining Seats is 0 then error is thrown: **Course is already full.**
 
 - **< basepath >/< port >/api/registration/courseDrop**:
 
 -- In this api, A student need to provide **Course Id, Student Id, Student Name**. 
 
 -- With the help of three field, course and student record is fetched. 
 
 -- If records are present, then if course name exist in the student record then course is dropped **successfully** and course name is removed from the student record as well.
 
 -- If Course does not exist then error is thrown: **Course is already dropped**.
