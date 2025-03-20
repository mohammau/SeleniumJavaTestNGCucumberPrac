#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
#@tag
#Feature: Title of your feature
  #I want to use this template for my feature file
#
  #@tag1
  #Scenario: Title of your scenario
    #Given I want to write a step with precondition
    #And some other precondition
    #When I complete action
    #And some other action
    #And yet another action
    #Then I validate the outcomes
    #And check more outcomes
#
  #@tag2
  #Scenario Outline: Title of your scenario outline
    #Given I want to write a step with <name>
    #When I check for the <value> in step
    #Then I verify the <status> in step
#
    #Examples: 
      #| name  | value | status  |
      #| name1 |     5 | success |
      #| name2 |     7 | Fail    |
      
Feature: Register and sign in functionality
      
Scenario: Registes a new user	
Given Launch browser
And Navigate to url 'http://automationexercise.com'
#Then Verify that home page is visible successfully
And Click on 'Signup / Login' button
Then Verify 'New User Signup!' is visible
And Enter name and email address
And Click 'Signup' button
Then Verify that 'ENTER ACCOUNT INFORMATION' is visible
And Fill details: Title, Name, Email, Password, Date of birth
And Select checkbox 'Sign up for our newsletter!'
And Select checkbox 'Receive special offers from our partners!'
And Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
And Click 'Create Account button'
Then Verify that 'ACCOUNT CREATED!' is visible
And Click 'Continue' button
Then Verify that 'Logged in as username' is visible
And Click 'Delete Account' button
Then Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button 
     
