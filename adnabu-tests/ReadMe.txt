To Setup and Run Automated Tests
Prerequisites:
		Ensure you have Firefox/Chrome/Edge installed on your machine.
		Can run on any browser as per requisites.
		Download the GeckoDriver executable for Firefox and set the system property accordingly.
		Set up your project with the necessary dependencies (Selenium, TestNG, Apache Commons IO).
		
Project Structure:
		The project structure includes the necessary libraries, drivers, and the AdNabuTest class.
		
Running the Tests:
		Open the AdNabuTest class.
		Run the testScenario method. This method contains the automated test scenarios.
		
Test Execution:
		The test will open the specified URL, perform various actions on the web page, and make assertions to verify expected behavior.
		
Test Reports:
Emailable Report:
		TestNG's Emailable Report will be generated automatically after each test run.
		The Emailable Report provides details about the test suite, including passed and failed test cases.
		
Screenshot on Test Failure:
		If a test method fails, a screenshot will be captured and saved in the screenshots folder.
		The failure message and the path to the screenshot will be printed in the console.
		
Viewing Reports:
		After running the tests, navigate to the test-output folder in your project directory.
		Open the emailable-report.html file to view the summary report.
		
		
Additional Notes:
	If needed, modify the test scenarios and assertions in the testScenario method according to your requirements.
	Make sure the necessary dependencies (Selenium, TestNG) are added to your project.
	This documentation provides a basic guide for setting up, running, and viewing test reports for the automated tests. You can customize it based on your project structure and requirements.