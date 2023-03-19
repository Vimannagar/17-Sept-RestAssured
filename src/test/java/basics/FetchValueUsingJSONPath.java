package basics;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class FetchValueUsingJSONPath {
	
	@Test
	public void getEmailValue()
	{
RestAssured.baseURI = "https://reqres.in/";
		
		Response response = given()
		
							.log().all()
		
							.when()
		
							.get("/api/users/2")
		
							.then()
		
							.log().all()
		
							.extract()
		
							.response();
		
		
		String stringresponse = response.asPrettyString();
		
		JsonPath jp = new JsonPath(stringresponse);
		
		String emailvalue = jp.getString("data.email");
		
		System.out.println("Email value is "+emailvalue);
		

	}
}
