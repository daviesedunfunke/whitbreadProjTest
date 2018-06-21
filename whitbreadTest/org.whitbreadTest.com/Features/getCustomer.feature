Feature: Retrieve customer details functionality with API testing 
		#Try to retrieve the email address which is created in 
		#URI: https://ipw5pjxxsh.execute-api.eu-west-1.amazonaws.com/api/hotel/customer/test@gmail.com

@getCustomer
Scenario: Verify retrieving Customer detail with valid HTTP request values. 

	Given the endpoints are runnning for https://ipw5pjxxsh.execute-api.eu-west-1.amazonaws.com/api/hotel 
	When customer finds the resource of request as /customer/
	And customer performs the GET request using test@gmail.com
	Then the response code should be 200
	And the HTTP response should be verified with test@gmail.com