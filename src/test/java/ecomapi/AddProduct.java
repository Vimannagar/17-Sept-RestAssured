package ecomapi;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.io.File;

public class AddProduct extends BaseData
{
	
	
	@Test
	public void addProductToApp()
	{
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		Response resp = given()
		
		.log().all()
		.header("Authorization", tokenid)
		.param("productName", "Casual shirt")
		.param("productAddedBy", userid)
		.param("productCategory", "fashion")
		.param("productSubCategory", "shirt")
		.param("productPrice","1000")
		.param("productDescription", "Indigo Nation")
		.param("productFor", "Men")
		.multiPart("productImage", new File("F:\\Desktop\\VimanNagar\\May 21\\17SeptAPIAutomation\\ecommerce test image.png"))
		
		.when()
		
		.post("api/ecom/product/add-product")
		
		.then()
		
		.log().all()
		
		.extract()
		
		.response();
		
		
JsonPath jp = resp.jsonPath();

 productid = jp.getString("productId");



				
			
		
		
	}
	

}
