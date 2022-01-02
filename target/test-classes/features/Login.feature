Feature: Application login.

Scenario Outline: Negative test for user login.  
Given Initialize chrome browser
And Navigate to browser and bypass the step
When user inputs <username> and <password> and clicks on login
Then login page throws error
And close the browser

Examples:
|username           |password       |
|cogn.arun@gmail.com|sdsadas		|
|coga.arun@gmail.com|sdsasas		|