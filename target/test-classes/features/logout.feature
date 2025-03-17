Feature: Register and login functionality 	  

Scenario: Login user able to successfully logout of the application
Given Launch browser
And Navigate to url 'http://automationexercise.com'
Then Verify that home page is visible successfully
And Click on 'Signup / Login' button
Then Verify 'Login to your account' is visible
And Enter correct email address and password
And Click 'login' button
Then Verify that 'Logged in as username' is visible
And Click 'Logout' button
Then Verify that user is navigated to login page
