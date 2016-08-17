###Consumer App Automation Suite for Android:

- To just compile the code use the following command:
	```sh
	mvn compile
	```

- To run the tests using an externally provided testng file, use the following command:
	```sh
	$ mvn test -DsuiteXmlFile=<filename.xml> 
	```	
	OR
	```sh
	$ mvn clean test -DsuiteXmlFile=<filename.xml> (if you want to delete the target folder)
	```

- To send results mail after test execution, use the following command:
	```sh
	$ mvn test -DsuiteXmlFile=<filename.xml> -DsendMail=true
	```	
	sendMail parameter is set to "false" by default. So if the parameter is not set, no mails would be sent.

If no external testng file is provided in command line, following error may occur:
> Execution default-test of goal org.apache.maven.plugins:maven-surefire-plugin:2.19.1:test failed: testSuiteXmlFiles0 has null value  
