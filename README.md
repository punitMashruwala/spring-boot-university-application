# spring-boot-university-application


## Introduction
A small university application built on Spring Boot with MongoDB and API Documentation on Swagger. In this application, users can create, read, update, and delete Student Record, Faculty Record, and Course Record. Also, if a user is a Faculty, then he can edit or create a course with his name as a faculty and course name with other info. And if a user is a Student then he can Register for a course or can Drop a course.

## How to run
-   Clone this repository
-   Make sure you are using JDK 1.8 and Maven 3.x and check if you have MongoDB install
-  First you need to start mongo service on your machine. Command for that is: 
`mongod`
- Then on another command prompt you need to run this command: 
`mongo`
- Once mongo is up, Open MongoDBCompass application, connect to URL: **mongodb://127.0.0.1:27017**
- Create a new Database with Name: "UniversityDatabase" and Create 3 Collection with Name: "Student", "Faculty", "Course"
-  Select that Database and Collection, then from "Collection" Menu, select Import Data by selecting Json file from **MongoDB Dump** folder from git clone.
-  After this step, open application folder and go to folder **"mongo_task"**
-  Open Command Prompt or Cmd Editor
-   You can build the project and run the tests by running  `mvn clean package`
-  Once successfully built, you can run the service by :
```` mvn spring-boot:run ````
-  Once Application starts and is up, it will look something like this in command prompt:
- `2021-01-13 19:47:57.507  INFO 20788 --- [  restartedMain] c.e.mongo_task.MongoTaskApplication      : Started MongoTaskApplication in 2.21 seconds (JVM running for 2.481)`

- Once Application is up, you can visit url: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html) in browser where you can see Swagger Api Documentation.



