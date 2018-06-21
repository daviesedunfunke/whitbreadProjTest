Feature: Registering new customer functionality with API testing 
	#Please do this to the best of your ability. If you are unsure of any functionality then please comment in the code.
	#Once the test is in place please provide your findings or any possible bugs.
	#List any external libraries required in order to run the tests.
	#Execute  method as  POST and send 
	#URI : https://ipw5pjxxsh.execute-api.eu-west-1.amazonaws.com/api/hotel/customer  , 
	#Title is  optional field and rest of the fields are mandatory  in the request.
	#Please randomise the data you may need to validate for  email, firstname and lastname.
@addCustomer
Scenario Outline: Verify registering new Customer with valid HTTP request values. 

	Given the endpoints are runnning for https://ipw5pjxxsh.execute-api.eu-west-1.amazonaws.com/api/hotel 
	When customer finds the resource of request as /customer
	And customer performs the POST request using "<email>", "<password>", "<firstName>", "<lastName>" and "<title>"
	Then the response code should be 200 
	And the HTTP response should be verified
	
	Examples:
	|email         		   |password |firstName|lastName|title|
	|dyt@gmail.com		   |a2q4y4Qu |David    |Allen   |Mr   |
	|davis@yaho.com		   |B2J4y4Ju |Dav      |Jones   |-    |
	|davies@whitbread.co.uk|B8J4B4Jg |Davies   |        |mrs  |
	|hinay@whitbread.co.uk |		 |Hinay    |Patel   |dr   |
