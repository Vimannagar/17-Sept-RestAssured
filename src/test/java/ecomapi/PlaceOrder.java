package ecomapi;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class PlaceOrder extends BaseData
{
	
	@Test
	public void placeOrders()
	{
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		given()
		
		.log().all()
		
		.header("Content-Type", "application/json")
		
		.header("Authorization", tokenid)
		
		.body(JsonBody.getOrderBody(productid))
		
		.when()
		
		.post("api/ecom/order/create-order")
		
		.then()
		
		.log().all()
		
		.extract()
		
		.response();
		
		
		
		
		
		
		
		
		
		
	}

}
