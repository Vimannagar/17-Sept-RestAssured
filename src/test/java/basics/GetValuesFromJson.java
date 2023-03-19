package basics;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetValuesFromJson {
	
	@Test
	public void getListOfUsers()
	{
		
		RestAssured.baseURI = "https://reqres.in";
		
		Response response = given()
		
							.when()
		
							.get("api/users?page=2")
		
							.then()
					
							.log().all()
		
							.extract()
		
							.response();


					JsonPath jp = response.jsonPath();
					
					int pagevalue = jp.getInt("page");
					
					System.out.println(pagevalue);
					
					
					
				String emailforid0 = jp.getString("data[3].email");
				
				System.out.println(emailforid0);
				
				int numberofelements = jp.getInt("data.size()");
		
				System.out.println("number of elements are"+numberofelements);
				
				
				for(int i=0; i<6; i++)
				{
				String firstname = jp.getString("data["+i+"].first_name");
				
				System.out.println(firstname);
				}
				
	}

}
