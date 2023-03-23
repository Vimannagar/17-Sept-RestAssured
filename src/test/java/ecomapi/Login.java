package ecomapi;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Login extends BaseData
{
	
	
	@Test
	public void loginToApp()
	{
		
		RestAssured.baseURI = "https://www.rahulshettyacademy.com";
		
		Response resp = given()
		
		.header("Content-Type", "application/json")
		
		.body("{\r\n"
				+ "    \"userEmail\": \"gouravjawale28@gmail.com\",\r\n"
				+ "     \"userPassword\": \"Test@1234\"\r\n"
				+ "}")
		
		.log().all()
		
		.when()
		
		.post("/api/ecom/auth/login")
		
		.then()
		
		.log().all()
		
		.extract()
		
		.response();

		
	JsonPath jp = resp.jsonPath();
	
	tokenid = jp.getString("token");
	
	userid = jp.getString("userId");
		
	
	
		
	}

}
