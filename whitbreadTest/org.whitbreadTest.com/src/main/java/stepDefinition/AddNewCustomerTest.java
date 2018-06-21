/**
 * 
 */
package stepDefinition;

import org.testng.Assert;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static com.jayway.restassured.RestAssured.*;

/**
 * @author davies edunfunke
 *
 */
public class AddNewCustomerTest {
	
	String uri;
	Response resp;
	
	@Given("^the endpoints are runnning for (.*)$")
	public void the_endpoints_are_runnning_for_https(String frontURL) {
		
		this.uri = frontURL;
		//resp = given().when().get(uri);
		//Assert.assertEquals(resp.getStatusCode(), 200);
		
	}
	
	@When("^customer finds the resource of request as (.*)$")
	public void customer_finds_the_resource_of_request_as_customer(String rearURL) throws Throwable {
		
		this.uri = this.uri + rearURL;
		//resp = given().when().get(uri);
		//Assert.assertEquals(resp.getStatusCode(), 200);
		
	}
	
	@And("^customer performs the POST request using \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" and \"([^\"]*)\"$")
	public void customer_performs_the_POST_request_using_and(String email, String password, String firstName, String lastName, String title) throws Throwable {
		
		AddNewCustomerObj newCustomer = new AddNewCustomerObj();
		newCustomer.setEmail(email);
		newCustomer.setPassword(password);
		newCustomer.setFirstName(firstName);
		newCustomer.setLastName(lastName);
		newCustomer.setTitle(title);
		
		resp = given().when().contentType(ContentType.JSON).body(newCustomer).post(this.uri);
		   
	}
	
	@And("^customer performs the GET request using (.*)$")
	public void customer_performs_the_GET_request_using_email(String email) throws Throwable {
	    
		this.uri = this.uri + email;
		resp = given().when().get(this.uri);
		
	}
	
	@When("^customer performs the DELETE request using (.*)$")
	public void customer_performs_the_DELETE_request_using_email(String email) throws Throwable {
	    
		this.uri = this.uri + email;
		resp = given().when().delete(this.uri);
		
	}

	@Then("^the response code should be (.*)$")
	public void the_response_code_should_be(int statusCode) throws Throwable {
		
		System.out.println(resp.getStatusCode());
		//resp.then().statusCode(200)
		Assert.assertEquals(resp.getStatusCode(), statusCode);
	    
	}
	
	@And("^the HTTP response should be verified$")
	public void the_HTTP_response_should_be_verified() throws Throwable {
	    
		System.out.println(resp.prettyPrint());
		Assert.assertEquals(resp.path("body.success"), true);
		
	}
	
	@And("^the HTTP response should be verified with (.*)$")
	public void the_HTTP_response_should_be_verified_with_email(String email) throws Throwable {
	   
		System.out.println(resp.prettyPrint());
		Assert.assertEquals(resp.path("customerId"), email);
		
	}
	
	@And("^the HTTP response should be verified as true$")
	public void the_HTTP_response_should_be_verified_as_true() throws Throwable {
	    
		System.out.println(resp.prettyPrint());
		Assert.assertEquals(resp.path("deleted"), true);
		
	}
		
}
