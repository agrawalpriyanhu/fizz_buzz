# Fizz Buzz
This project exposes a REST API Endpoint which accept five parameters: three integers (int1, int2, and limit) and two strings (str1 and str2) and
return a list of strings containing numbers from 1 to limit by replacing the multiples of int1 with str1, multiples of int2 with str2, and multiples of both int1 and int2 with str1str2.
One additional end point is exposed to get the maximum hit request.

### Follwing Steps to be followed to build and run the project

    1. Install java 21
    2. install maven
    3. clone repository
    4. run mvn clean install
    5. copy fizz_buzz-0.0.1-SNAPSHOT.jar jar generated in target folder to the server
    6. put log4j2.xml to the folder in which jar was copied
    7. run java jar command
    8. logs will be generated in logs folder
    9. h2 db file will be generated in the db folder. Username will be “sa” and password will be “password”

### Api Specification can be found on below url
https://agarwalpriyanshu76.atlassian.net/wiki/external/ZDFmZjU4NjljNmE0NDdjZWFmOGI3NjYyMDQzNjMxOTE

### Note: If above link doesn't open, the Api spec can be found below :
https://github.com/agrawalpriyanhu/fizz_buzz/blob/main/Fizz%20Buzz%20Api%20Specs.pdf
