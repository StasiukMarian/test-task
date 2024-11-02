HOW TO RUN TEST GROUPS:
Critical tests: mvn test -Pcritical-tests
Extended tests: mvn test -Pextended-tests
API tests: mvn test -Papi-tests

HOW TO RUN ALL TESTS:
mvn clean test

GENERATING ALLURE REPORT:

Run the tests using any of the above commands.

After test execution, generate the Allure report:
mvn allure:report

Open the generated report:
mvn allure:serve