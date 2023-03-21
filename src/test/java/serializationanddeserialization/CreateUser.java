package serializationanddeserialization;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import pojo.RequestBody;

import static io.restassured.RestAssured.*;

public class CreateUser {
	
	
	@Test
	public void createUserInApp()
	{
		
		RequestBody reqbody = new RequestBody();
		
		reqbody.setId(0);
		reqbody.setUsername("tuesdayuser");
		reqbody.setFirstName("Eder");
		reqbody.setLastName("Mejia");
		reqbody.setEmail("eder.mejia@a.com");
		reqbody.setPassword("Test@12345");
		reqbody.setPhone("9988776655");
		reqbody.setUserStatus(0);
		
		
		RestAssured.baseURI = "https://petstore.swagger.io/v2";
		
	Response resp = given()
		.header("Content-Type", "application/json")
		.header("accept", "application/json")
		
		.body(reqbody)
		
		.when()
		
		.post("/user")
		
		.then()
		
		.extract()
		
		.response();
	
	String stringresp = resp.asPrettyString();
	
	System.out.println(stringresp);
		
		
		
		
		
		
	}

}
