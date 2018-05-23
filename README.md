TO Start The Application.

Java ,Maven and Mysql is needed.

java version "1.8.0_161" 
Mysql Ver 14.14 Distrib 5.7.21,

Step 1.
Create Database pramati

Change the Mysql Credentials in the application.properties file according to your system
default username and password is root 

Step 2.Go the the Project Root Directory and 
Run Command

mvn spring-boot:run

Application will start on localhost:8080


Sample API 

http://localhost:8080/suggest_cities?start=a&atmost=5





