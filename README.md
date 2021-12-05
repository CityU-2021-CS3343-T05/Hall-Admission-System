# 1.     Overview
Hall Admission System is our solution for allocating residence rooms for local and non-local students of the City University of Hong Kong. The current hall allocation is not transparent in the admission process and is more qualitative rather than quantitative. Our solution brings forth an effective way to process the quantitative value of student applications.

# 2.     Progress

In order to track all program versions and development progress, GitHub is used to provide us with version control. 


2.1 	   Public Release

2.1.1 	   Release 1
Introduction:
The first release of our product can be used to demonstrate the sorting algorithm we use. It is the building block of our entire program and allows us to build from there.	
Feature:
Create applications of multiple students from the database
Calculate application score and perform a weighted score on each hall accordingly
Display the score of application to the console for analysis of the score
Patch:
1.1  –  When the total application scores of two students are the same, the sorting of applications is not always valid
1.2   –   The login part of the Administrator crashes without a password.

2.1.2     Release 2
Introduction:
This release encompasses all the functionalities and additional features that allow students to log in and continue their application. For instance, allow more input from users and demonstrate their score allocation more robustly. This also enables the administrator to gain a more in-depth outlook of the applicant. 
Feature:
Allow applicants to log in
Allow administrators to log in and view applications before allocation
Store applicant information in the database for CRUD operations
Two independent logins for applicant and administrator
The results are displayed in the administrator portal with detailed assignments

2.1.3     Release 3
Introduction:
This version contains refactored code. It works in the same way as Release 2 and passes the unit testing, integrated testing and system testing.  
Feature:
This version contains some of the changes mentioned in the Refactoring Report, including the parameter changes in the HallSystem.changeHall() and several other changes.

```bash
**Latest version includes:
Java Source folder
Java Test case folder
Database.csv file
Java .jar file
runProgramme.bat
Readme.md**
```

# 3.     Installation
Prerequisites:
Our project requires Java version 11 to compile and run
Junit5 is installed as a classpath to be able to test Java test files. Put the testResource file in the bin folder for some parameterized tests
Getting Started:
To check the installed Java version, use the command:

```bash
“java -–version” 
```

at the Windows Command Prompt
Run runProgramme.bat to open the program via command prompt
Login as desired, either as an Administrator or as a Student. (Student credentials can be found in the database.csv file.)
Important Function Instructions:

**To run program run the runProgramme.bat file which uses the release_v_3.jar file.**

# License
City University of Hong Kong
