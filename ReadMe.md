Hi,

For tests use:
* `mvn -Dtest=StreamProcessingTestSuite test` in the command line.

To run use: 
1. `mvn package` in the command line and then
2. `java -cp target/Audiance_test_1-1.0-SNAPSHOT.jar org.exercise.one.Main`

Best Regards,
Alex

The exercise instructions are :

_Audience Test Exercise 1

Task
Imagine that the input statements shown below represent a list of statements received from a home&#39;s
set top box for many thousands of homes (Sky/Virgin for example).
A Python or Java solution is required to transform the input statements into output session records.
A session is formed as follows:
* If a viewer is watching BBC1 at 1900 hrs and switches to ITV1 at 1930, a BBC1 viewing
session record would be created from 1900 to 1929 with duration 30 minutes.
* The output session record would contain all the input record columns plus end time and
duration columns which should be computed by your solution.
* The final session of the day for each home would occur from the last statement start time until
the end of the day, i.e. 235959 hours.
* The Activity column indicates the type of viewing such as live or playback. No processing
logic is needed for this.

Date time values are in YYYYMMDDHHMMSS format.
The solution should be efficient and able to process 5 million statements for 50,000 homes.
The inputs statements are not sorted.

Input Statements:
HomeNo|Channel|Starttime|Activity 
1234|101|20200101180000|Live 
1234|102|20200101183000|Live 
45678|103|20200101190000|PlayBack 
45678|104|20200101193000|Live 

Output Sessions:
HomeNo|Channel|Starttime|Activity|EndTime|Duration
1234|101|20200101180000|Live|20200101182959|1800
1234|102|20200101183000|Live|20200101235959|19800
45678|103|20200101190000|PlayBack|20200101192959|1800
45678|104|20200101193000|Live|20200101235959|16200

Testing
Please write test cases to ensure all scenarios in your solution are covered. This could be using
pytest for Python or JUnit for Java.

Submission
Please submit your solution in a form that can be automatically compiled and tested from the
command line. Only solutions that compile test and run automatically from the command line will be
accepted. For Java this ideally means a Maven or Gradle project using a Java 8 JDK. For a Python
solution, version 2 or 3 is acceptable.

Document version: 15 December 2020_