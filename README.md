
Content Page

1.     Overview	3
2.     Progress	3-5
2.1     Public Release	3
2.1.1      Release 1	3
2.1.2     Release 2	4
2.1.3     Release 3	4
2.2     Release Date	5
3.     Installation	5-11
3.1     Administrator	6
3.1.1      Create Hall Function	7
3.1.2     Process Applications Function and View All Results	8
3.1     Student	9
3.1.1      Create Application Function	10
3.1.2     View Result Function	11



1.     Overview
Hall Admission System is our solution for allocating residence rooms for local and non-local students of the City University of Hong Kong. The current hall allocation is not transparent in the admission process and is more qualitative rather than quantitative. Our solution brings forth an effective way to process the quantitative value of student applications.

2.     Progress

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


2.2 	   Release Date

Version
Release Date
Release 1.0
10th October 2021
Release 1.1
28th October 2021
Release 1.2
23rd November 2021
Release 2.0
26th November 2021
Release 3.0
4th December 2021


**Latest version includes:
Java Source folder
Java Test case folder
Database.csv file
Java .jar file
runProgramme.bat
Readme.md**

3.     Installation
Prerequisites:
Our project requires Java version 14 to compile and run
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

3.1 	   Administrator

To login as an Administrator, first enter “Admin” or “admin” in the prompt. This will prompt the user to input the Administrator’s credentials. The credentials for the admin account can be seen in the picture. After that, it will list all the functions that the Administrator can use in our Program. 


3.1.1     Create Hall Function


By entering “4” in the prompt, the Administrator can use the function of creating a hall. In our program, 3 halls have been set up in advance. Using this function, the user can work with several halls at the same time to facilitate hall allocations. The user can also directly change the input of the weighting distribution of the newly-built halls or change the allocation of existing halls.



3.1.2     Process Applications Function and View All Results



Entering “5” allows the Administrator to process applications. This takes all applications in the system to be processed according to the weighting for each hall. Right after running this function, we can immediately use the “4” View all Results function, which will display all the final results. As we can see, function “5” can be used to display all applications (in this case we created manually in the system) and process them afterwards.




Running function “4”, it basically shows the allocation of all applications. Some applications will be forwarded to the waiting list or rejected list.



3.1 	   Student



By entering “Student” in the panel, the user will be asked to enter the login credentials for the account. The credentials for the Student account can be seen in the picture. After that, it will list all the functions that the Student can use in our Program. 






3.1.1     Create Application Function


Entering “1” basically prompts the system to let the Student create an application. After inputting, the user needs to fill in the credentials to create the application. This application is for the hall and will be sent directly to the “Residence Administrator”



	

3.1.2     View Result Function


After completing the application, the applicant must wait for the Administrator to log in and process the applications in the system. After the processing is completed, the applicant can check the application status through the “5” command.


