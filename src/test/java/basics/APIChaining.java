package basics;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class APIChaining {
	
	
	static String  messagevalue; 
	
	@Test(priority = 1)
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
	
		JsonPath jp = new JsonPath(stringresp);
		
		 messagevalue = jp.getString("message");
		
	}
	
	
	@Test(priority = 2)
	public void getDetails()
	{
		RestAssured.baseURI = "https://petstore.swagger.io/v2";
		
		
	Response resp = given()
		
		.when()
		
		.get("/user/userthree")
		
		.then()
		
		.extract()
		
		.response();
	
	String response = resp.asPrettyString();
	
	
	JsonPath jp = new JsonPath(response);
	
	String idvalue = jp.getString("id");
	
		System.out.println("message value is :"+messagevalue);
		
		System.out.println("id value is :"+idvalue);
		
		
		Assert.assertEquals(messagevalue, idvalue);
	
	
		
		
		
	}



}
