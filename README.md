# Welcome to Asteria Academy - Student Information System!
Asteria Academy - SIS was based of from my current project [Asteria Academy](https://github.com/gfdelrosario12/Asteria-Academy) which its SIS portal now continued with my groupmates on Database Management System. This is Asteria Academy - SIS' backend repository version. 

## PUP - ITECH DCPET 2-1 DMS Group Members
- Cabuello, Keren
- Castillo, Ivhorre
- Del Rosario, Gladwin
- Ebiola, Frankie
- Robea, Kristine

## Technology Stack
- Backend: Java - Spring, Spring Boot, Spring JPA, Spring Security
- Database: MySQL


## Commit Documentation

### June 22; 4:25 PM
- Commit Message: Setup/initial commit 
- Background: Initial files of the project
- Status:
    - Updates:
        - Established Controller, Entity, Repository, Service packages
    - Issues:
        - Not yet tested with Postman
    - Notes:
        - There are three different user tables, Student and Faculty and Administrators

### June 22; 5:15 PM
- Commit Message: Added Administrator User and initially completed controllers
- Background: Created admin user(table) and completed initial controller endpoints
- Status:
    - Updates:
        - Created class for administrator user to create a table in database
        - Initially completed the three controllers (faculty, admin and student)
    - Issues:
        - Not yet tested with Postman
    - Notes:
        - None; still refer to previous note

### June 22; 11:25 PM
- Commit Message: Completed full initial setup
- Background: Connected backend with database and tested the connection
- Status:
    - Updates:
        - All entities now have their own files on each folder
        - Spring Boot successfully connected with the database
        - Tested the connection with postman
    - Issues:
        - None so far
    - Notes:
        - None so far

### June 25; 12:21 AM
- Commit Message: Completed all files
- Background: Completed all files but most have not been tested
- Status:
    - Updates:
        - Completed all layers of admin, faculty, student, classes, grades
        - Tested all operations of admin
    - Issues:
        - Faculty, student, classes, grades have not been tested
    - Notes:
        - None so far

### June 26; 2:15 AM
- Commit Message: Updated all files to a working state
- Background: Updated and tested all files to a working state
- Status:
    - Updates:
        - Completed all layers of admin, faculty, student, classes, grades
        - Tested all endpoints of admin, faculty, student, classes, grades
    - Issues:
        - None so far, stable version
    - Notes:
        - Need to add further functionalities

### June 27; 12:32 AM
- Commit Message: Implemented Password Hashing and Log In
- Background: Implemented Password Hashing and Log In
- Status:
    - Updates:
        - Implemented password hashing through Argon2
        - Implemented log in for faculty, students and admin users
    - Issues:
        - Stable tested version
    - Notes:
        - Not yet connected with session

### June 27; 10:21 PM
- Commit Message: Implemented tree structure for grades and classes
- Background: Implemented tree structure for grades and classes
- Status:
    - Updates:
        - Created tree structure retrieving method with school year, year level, semester for classes of faculty
        - ICreated tree structure retrieving method with school year and semester for grades of student
        - Converted controllers using request param to path variable.
    - Issues:
        - Not yet tested
    - Notes:
        - Not yet connected with frontend

### June 27; 10:48 PM
- Commit Message: Grade Entity Fixes
- Background: Fixed grade retrieval to base on student id
- Status:
    - Updates:
        - Updated grade levels to base on the student id
    - Issues:
        - Not yet tested
    - Notes:
        - Not yet connected with frontend

### June 29; 3:11 AM
- Commit Message: Tested endpoints
- Background: Tested endpoints to find errors
- Status:
    - Updates:
        - Tested post endpoints for user creation to know if username creation works
        - Test post endpoints for user log in to know if username credential works
    - Issues:
        - Further endpoints not yet tested
    - Notes:
        - Continue testing
      
### July 24; 3:27 AM
- Commit Message: Implemented class_subject searching based on faculty id
- Background: Implemented class_subject searching based on faculty id
- Status:
    - Updates:
        - Created method to retrieve class_subjects based on faculty id
        - Test get endpoints for class_subjects
    - Issues:
        - None
    - Notes:
        - Continue testing