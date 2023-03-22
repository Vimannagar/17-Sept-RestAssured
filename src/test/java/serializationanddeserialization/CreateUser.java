package serializationanddeserialization;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import pojo.RequestBody;
import pojo.ResponseBody;

import static io.restassured.RestAssured.*;

public class CreateUser {
	
	
	@Test
	public void createUserInApp()
	{
		
		RequestBody reqbody = new RequestBody();
		
		reqbody.setId(0);
		reqbody.setUsername("Weduser");
		reqbody.setFirstName("Axel");
		reqbody.setLastName("Sanchez");
		reqbody.setEmail("axel.sanchez@a.com");
		reqbody.setPassword("Test@12345");
		reqbody.setPhone("9988776657");
		reqbody.setUserStatus(0);
		
		
		RestAssured.baseURI = "https://petstore.swagger.io/v2";
		
ResponseBody responsebody = given()
							.header("Content-Type", "application/json")
							.header("accept", "application/json")
		
							.body(reqbody)
							.log().all()
		
							.when()
		
							.post("/user")
		
							.then()
							
							.log().all()
		
							.extract()
							
							.response()
		
							.as(ResponseBody.class);
	
	
		int statuscode = responsebody.getCode();
		
		System.out.println(statuscode);
		
		String message = responsebody.getMessage();
		
		System.out.println(message);
		
		
		
		
	}

}
