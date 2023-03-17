package basics;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;


import static io.restassured.RestAssured.*;

public class GetListUsers {
	
	
	
	@Test
	public void getListOfUsers()
	{
		
		RestAssured.baseURI = "https://reqres.in";
		
Response response = given()
		
					.when()
		
					.get("api/users?page=2")
		
					.then()
		
					.extract()
		
					.response();


			String stringresponse = response.asPrettyString();// converting the response into string format

		System.out.println(stringresponse);
		
		
		int statuscode = response.getStatusCode();// returning the status code of the response
		
		
		System.out.println("status code is :"+statuscode);
		
		long responsetime = response.getTime();
		
		System.out.println("The response time is "+responsetime);
		
		Assert.assertEquals(201, statuscode);
		
	}
	
	
	

}
