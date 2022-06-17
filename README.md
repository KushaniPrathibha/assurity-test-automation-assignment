# api-test-automation-assignment
Test automations to test https://api.tmsandbox.co.nz/v1/Categories/6327/Details.json?catalogue=false. 

## Description
This test automation project has done using *Java 8* using *REST Assured* which allows to integrate with testing frameworks like *Junit* or *TestNG*.

This contains main automation test scenarios to test the given API.
Mainly covers following acceptance criterias:
* Name = "Carbon credits"
* CanRelist = true
* The Promotions element with Name = "Gallery" has a Description that contains the text "Good position in category"

##### Note: Can be improved based on the requirement and business scanarios

## Getting Started
### Prerequisite
* Git Installed
* Java 8 installed
* Maven installed

### Installation Steps
Clone the repository
```
git clone https://github.com/KushaniPrathibha/api-test-automation-assignment.git
```
### Executing program
1. Change the working directory
```
cd api-test-automation-assignment
```
2. Download maven dependancies
```
mvn clean install
```
3. Run tests
```
mvn test
```
## Authors

Kushani Premachandra - kkushani.pp@gmail.com

You are Ready to Go!
