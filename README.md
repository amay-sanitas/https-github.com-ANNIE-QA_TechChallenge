###### **DemoBlaze and PetStore QA TASK CAGLAR NAKKAS**


I have automated both API and UI cases with Java using Selenium WebDriver and RestAssured, following a Page Object Modelling and implemented BDD. As regards our testing browser, Google Chrome is used in order to test UI. Also from .properties file the tester can decide about browser. (Code is dynamic; it is checking the users OS and if requested browser not available for particular OS, code throwing an error, such as Safari in Windows).

Prerequisites
- Have at least Java 11 SDK installed
- IntelliJ IDE (any IDE is fine) or Maven
- Browser drivers are fetching automatically from bonigarcia dependency, so no need to identify the browser version.-

Installing

- https://github.com/cnakkas/QA_TechChallenge.git
- `git clone https://github.com/cnakkas/QA_TechChallenge.git`

Running
- Maven (`mvn clean`, `mvn verify` in the project path)
- IntelliJ or Eclipse

For running the test cases I matched UI and API part with different tags, this can be done with @SmokeSuiteAPI , @SmokeSuiteUI in CukesRunner and Tags section or through the Maven command ( `mvn verify -Dcucumber.filter.tags='@feature_file_name' `).

Reporting
Running through `mvn verify` automatically creating a report in the Target file. If any TC fail during test; the framework keeping this TC in a `rerun.txt` file in the target folder, once the test done it is running failed test case with FailedTestRunner to sure that the problem is not environmental.
