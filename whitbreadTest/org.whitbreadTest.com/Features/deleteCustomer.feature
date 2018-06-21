Feature: Delete customer details functionality with API testing 
		#Delete the CustomerId which is created on URI
		#https://ipw5pjxxsh.execute-api.eu-west-1.amazonaws.com/api/hotel/customer/test@gmail.com

@delCustomer
Scenario: Verify deleting Customer with valid HTTP request values. 

	Given the endpoints are runnning for https://ipw5pjxxsh.execute-api.eu-west-1.amazonaws.com/api/hotel 
	When customer finds the resource of request as /customer/
	And customer performs the DELETE request using test@gmail.com
	Then the response code should be 200 
	And the HTTP response should be verified as true