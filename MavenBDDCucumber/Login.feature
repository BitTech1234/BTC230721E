Feature: Login Validation

Background:

Given open browser
			| Chrome |
    	| FireFox |
    	| Safari |
And go to facebook

@Smoke
Scenario: As a user should be logged in using valid credential

When user type user ID in email box
| UserID |
| User1	|
| User2	|
| User3	|
And user type password in password box
And user click in login button

Then user should see his profile page

@Regression
Scenario Outline: As a user should not logged in using invalid credential

When user type "<user ID>" in email box
And user type "<password>" in password box
And user click in login button

Then user should not see his profile page

Examples:
| user ID | password |
| User1	|	pass1	|
| User2	|	pass2	|
| User3	|	pass3	|


