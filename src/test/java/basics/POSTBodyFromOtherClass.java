package basics;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class POSTBodyFromOtherClass {
	
	

	@Test
	public void createUser()
	{
		RestAssured.baseURI = "https://petstore.swagger.io/v2";
		
	Response resp = given()
		
		.header("Content-Type", "application/json")
		.header("accept", "application/json")
		
		.body(JsonBody.getBody())
		
		.when()
		
		.post("/user")
		
		.then()
		
		.extract()
		
		.response();
	
	String stringresp = resp.asPrettyString();
	
	System.out.println(stringresp);
		
	}


}
