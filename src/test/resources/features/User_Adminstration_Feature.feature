Feature: User Management feature

Scenario Outline: <TestName>
	Given User access crm application
	Then Navigates to user creation page
	
	Examples:
	|TestName|
	#|Navigate to user creation page_IE|
	|Navigate to user creation page_FF|
	|Navigate to user creation page_CH|