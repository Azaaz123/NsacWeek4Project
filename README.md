# NsacWeek4Project
Week 4 project

Testing Coverage: 83.9%
BAEproject-1
An Electric Vehicle Database with web application using CRUD functionality 

Getting Started
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

Prerequisites
What things you need to install the software and how to install them

Java JDK 11
https://www.oracle.com/uk/java/technologies/javase/jdk11-archive-downloads.html#license-lightbox
Follow the link and find file 
jdk-11.0.16_windows-x64_bin.exe

PostMan download
https://dl.pstmn.io/download/latest/win64

Follow the link and run on desktop

VScode download
https://code.visualstudio.com/download
choose the windowns 

ecilpse download
https://www.eclipse.org/downloads/download.php?file=/oomph/epp/2022-09/R/eclipse-inst-jre-win64.exe
choose the package that says 
Get Eclipse IDE 2022‑09
Install your favorite desktop IDE packages.

Downloand and install onto desktop

sql workbench
https://dev.mysql.com/downloads/file/?id=513229
choose Windows (x86, 64-bit), MSI Installer	
Downloand and install onto desktop


Running the tests

You need to create .sql files in the folder I have below
/BAEproject-1/src/main/resources

See image for more details
![image](https://user-images.githubusercontent.com/112072120/190677111-d7780616-58de-4fb6-a852-70826b025ab8.png)

create a Testschema.sql file and testdata.sql file

Right click and go to Open With and select text editor. this will open this into ecilpse and not SQL.

test schema
![image](https://user-images.githubusercontent.com/112072120/190677716-d29829ed-8236-4373-a273-034a0e919ad5.png)
input data shown in the image above to create your table structure

testdata
![image](https://user-images.githubusercontent.com/112072120/190677828-c7d9ead1-55b1-43e1-9f82-571c403c1043.png)
input data shown in the image above to create data to go into your table structure.

Please ensure back tick and single quotes are use correctly.




Unit Tests
In project scr/test/java

recreate your package scruction for controller and service. see below for image
![image](https://user-images.githubusercontent.com/112072120/190676824-61f1f4f1-3dd9-43d4-b276-0bad5bb3c78d.png)

Create two files, 1 for integration unit test and 1 for controller unit test

for unit test 
Please see /BAEproject-1/src/test/java/com/qa/main/controller/ElectricVehicleControllerIntegrationTest.java for unit test

to run this right click on the unit test and go to Coverage as and select J Unit test. See im age below for more details.
![image](https://user-images.githubusercontent.com/112072120/190678499-b62ece53-2e1f-46c4-b219-af156129ebde.png)

This will provide covereage report as the image below
![image](https://user-images.githubusercontent.com/112072120/190678756-9ba089b9-ad46-4da2-86bf-a9f8e6e022a2.png)
all unit test image 
![image](https://user-images.githubusercontent.com/112072120/190678826-3ea84378-863f-486e-b3f5-526d105cc336.png)


Integration Tests
Integration test are test to ensure the service and controller are integrated correct and working together/ communicating to produce the required result
my integration test is located here /BAEproject-1/src/test/java/com/qa/main/controller/ElectricVehicleControllerIntegrationTest.java

to run this right click on the unit test and go to Coverage as and select J Unit test. See im age below for more details.
![image](https://user-images.githubusercontent.com/112072120/190679188-4725ba85-c59b-4045-8786-9fde1664a51b.png)

This will provide covereage report as the image below
![image](https://user-images.githubusercontent.com/112072120/190679280-db116c3c-ae9e-4fb2-9641-6d82eadeb7c1.png)
![image](https://user-images.githubusercontent.com/112072120/190679296-0b6edb68-6884-43ac-aa79-ed2b3123f70f.png)



Swagger API Endpoints
![image](https://user-images.githubusercontent.com/112072120/190679378-2989fc7d-4bd7-44c4-b742-9e1b60326d7b.png)
also located here
C:\Users\azaaz\eclipse-workspace\BAEproject-1\src\main\resources\static\IMG

Project Management Board
Link to Jira board
https://azaazashiq.atlassian.net/jira/software/projects/NW4P/


Built With
Maven - Dependency Management
Authors
Azaaz Ashiq
License
This project is licensed under the MIT license - see the LICENSE.md file for details

For help in Choosing a license

Acknowledgments/References
Hat tip to anyone whose code was used
Inspiration
etc
