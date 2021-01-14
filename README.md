
# Spring Boot University Application


## Introduction

 - A small university application built on Spring Boot with MongoDB and API Documentation on Swagger.
 - In this application, there are three types of User:
 
 1. **Student**: Student as a user can create, update, read or delete Student Record and also Register in Course or can Drop from a Course.
 
 2. **Faculty**: Faculty as user can create, update, read or delete Student Record and also Update a Course like updating Capacity or waitlist.
 
 3. **Course**: A normal user can create, update, read and delete Course Record.

## How to run

 1.  Clone this repository
 2.   Make sure you are using current java version and Maven 3.x and check if you have [MongoDB install](https://www.mongodb.com/try/download/community)
 3.  First you need to start mongo service on your machine. Command for that is: 
`mongod`
 4. Then on another command prompt you need to run this command: 
`mongo`
 5. Once mongo is up, Open MongoDBCompass application, connect to URL: **mongodb://127.0.0.1:27017**
 6. Create a new Database with Name: **"UniversityDatabase"** and Create 3 Collection with Name: **"Student"**, **"Faculty"**, and **"Course"**
 7.  Select that Database and Collection, then from "Collection" Menu, select Import Data by selecting Json file from [**MongoDB_Dump**](https://github.com/punitMashruwala/spring-boot-university-application/tree/master/Mongo_Dump) folder from git clone.
 8.  After this step, open [Application](https://github.com/punitMashruwala/spring-boot-university-application/tree/master/Application) folder and Open **Command Prompt or Terminal**
 9.   You can build the project and run the tests by running  `mvn clean package`
 10.  Once successfully built, you can run the service by :
```` mvn spring-boot:run ````
 11.  Once Application starts and is up, it will look something like this in command prompt:
  `2021-01-13 19:47:57.507  INFO 20788 --- [  restartedMain] c.e.mongo_task.MongoTaskApplication      : Started MongoTaskApplication in 2.21 seconds (JVM running for 2.481)`

 12. Once Application is up, you can visit url: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html) in browser where you can see Swagger Api Documentation.


## Application Structure:

 - **Service Model**: In [Service model,](https://github.com/punitMashruwala/spring-boot-university-application/tree/master/Application/src/main/java/com/example/mongo_task/resource) there are Four Controller files which are used to handle business logic. This files contains functions which are used for CRUD operation and other logic.
 Also, Exception Handling and custom message object is also defined [here](https://github.com/punitMashruwala/spring-boot-university-application/tree/master/Application/src/main/java/com/example/mongo_task/exception_handling).
 - **Repository Model**:  [In Repository Model](https://github.com/punitMashruwala/spring-boot-university-application/tree/master/Application/src/main/java/com/example/mongo_task/repository), Mongo Repository for different Collection is defined.
 - **DTO Model**: [Here](https://github.com/punitMashruwala/spring-boot-university-application/tree/master/Application/src/main/java/com/example/mongo_task/model) schema and other input validation for different types of users (Student, Faculty and Course) is defined.
 - **JUNIT Test cases**: Mockito is used and Have created three seperate file for three different users CRUD operation. Find it [here](https://github.com/punitMashruwala/spring-boot-university-application/tree/master/Application/src/test/java/com/example/mongo_task).
 

 ## Business Logic:
 - Once all records are created, **Below API** are used for Operation like Course Registration , Course Drop or Increasing/Decreasing Course Capacity.
 - **< basepath >/< port >/api/registration/updateFacultyName**:
 In this api, A faculty needs to provide **Course Id, Faculty Id, Faculty Name.** On this three field two records are fetched, if records found then in course record, fields like conductedBy, capacity and Waitlist capacity will be updated and course name will be added in faculty record.
 - **< basepath >/< port >/api/registration/courseRegistration**:
 In this api, A student need to provide **Course Id, Student Id, Student Name**. With the help of three field, course and student record is fetched. If records are present, then capacity and remaining seats are checked. If Remaining Seats is not 0, then course registered successfully and course name is added in the student record.  If Remaining Seats is 0 then error is thrown: Course is already full.
 - **< basepath >/< port >/api/registration/courseDrop**:
 In this api, A student need to provide **Course Id, Student Id, Student Name**. With the help of three field, course and student record is fetched. If records are present, then in stduent record course is checked, If present, then course is dropped successfully and course name is removed from the student record.  If Course is not presenthen error is thrown: Course is already dropped.
