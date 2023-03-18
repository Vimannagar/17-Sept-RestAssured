package basics;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class GET_User {
	
	
	@Test
	public void getSingleUser()
	{
		RestAssured.baseURI = "https://reqres.in/";
		
		given()
		
		.log().all()
		
		.when()
		
		.get("/api/users/2")
		
		.then()
		
		.log().all()
		
		.extract()
		
		.response();
		
		
	}

}
