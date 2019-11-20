# AutomationUI

This Test Automation Framework is created using Java + Selenium Web Driver + TestNG which can be used across different web based applications.

Prerequisites:
---------------
*	Java jdk-1.8 or higher
*	Apache Maven 3 or higher


Browsers supported:
---------------
*   Google Chrome (default)
```sh
$ mvn clean test -Dbrowser=chrome
```
*   Mozilla Firefox
```sh
$ mvn clean test -Dbrowser=firefox
```

Execution:
---------------
*	Go to project root
*   Run following commands:
```sh
$ mvn clean install
$ mvn clean test
```


Reporting:
---------------
*  The framework produce index.html report. It resides in the same 'target\surefire-reports' folder. This reports gives the link to all the different component of the TestNG reports like Groups & Reporter Output. On clicking these will display detailed descriptions of execution.
*  You can find emailable-report.html from target\surefire-reports to email the test reports. As this is a html report you can open it with browser.