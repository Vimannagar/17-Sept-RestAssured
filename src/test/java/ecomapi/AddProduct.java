package ecomapi;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;

public class AddProduct extends BaseData
{
	
	
	@Test
	public void addProductToApp()
	{
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		given()
		
		.header("Authorization", tokenid)
		
		
		
	}
	

}
