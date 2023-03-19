package basics;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class POST_Request {
	
	@Test
	public void createUser()
	{
		RestAssured.baseURI = "https://petstore.swagger.io/v2";
		
	Response resp = given()
		
		.header("Content-Type", "application/json")
		.header("accept", "application/json")
		
		.body("{\r\n"
				+ "  \"id\": 0,\r\n"
				+ "  \"username\": \"userone\",\r\n"
				+ "  \"firstName\": \"Test\",\r\n"
				+ "  \"lastName\": \"user\",\r\n"
				+ "  \"email\": \"sept@ss.com\",\r\n"
				+ "  \"password\": \"Test@12345\",\r\n"
				+ "  \"phone\": \"9876543211\",\r\n"
				+ "  \"userStatus\": 0\r\n"
				+ "}")
		
		.when()
		
		.post("/user")
		
		.then()
		
		.extract()
		
		.response();
	
	String stringresp = resp.asPrettyString();
	
	System.out.println(stringresp);
		
	}

}
