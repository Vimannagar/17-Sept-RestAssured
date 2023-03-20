package basics;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class FetchValuesFromJSON {
	
	@Test
	public void getValues()
	{
		JsonPath jp = new  JsonPath("{\r\n"
				+ "\"dashboard\": {\r\n"
				+ "\"purchaseAmount\": 910,\r\n"
				+ "\"website\": \"www.abc.com\"\r\n"
				+ "},\r\n"
				+ "\"courses\": [\r\n"
				+ "{\r\n"
				+ "\"title\": \"Selenium Python\",\r\n"
				+ "\"price\": 50,\r\n"
				+ "\"copies\": 6\r\n"
				+ "},\r\n"
				+ "{\r\n"
				+ "\"title\": \"Cypress\",\r\n"
				+ "\"price\": 40,\r\n"
				+ "\"copies\": 4\r\n"
				+ "},\r\n"
				+ "{\r\n"
				+ "\"title\": \"RPA\",\r\n"
				+ "\"price\": 45,\r\n"
				+ "\"copies\": 10\r\n"
				+ "}\r\n"
				+ "]\r\n"
				+ "}\r\n"
				+ "");
		
		int sum =0;
		int numberofcourse = jp.getInt("courses.size()");
		
		for(int i=0; i<numberofcourse; i++)
		{
			int price = jp.getInt("courses["+i+"].price");
			int copies = jp.getInt("courses["+i+"].copies");
			
			sum = sum + copies*price;
			
		}
		
		int puchaseamount = jp.getInt("dashboard.purchaseAmount");
		
		Assert.assertEquals(sum,puchaseamount);
		
		
		
	}
	
	@Test
	public void printAllCourseTitleAndPrice()
	{
		JsonPath jp = new  JsonPath("{\r\n"
				+ "\"dashboard\": {\r\n"
				+ "\"purchaseAmount\": 910,\r\n"
				+ "\"website\": \"www.abc.com\"\r\n"
				+ "},\r\n"
				+ "\"courses\": [\r\n"
				+ "{\r\n"
				+ "\"title\": \"Selenium Python\",\r\n"
				+ "\"price\": 50,\r\n"
				+ "\"copies\": 6\r\n"
				+ "},\r\n"
				+ "{\r\n"
				+ "\"title\": \"Cypress\",\r\n"
				+ "\"price\": 40,\r\n"
				+ "\"copies\": 4\r\n"
				+ "},\r\n"
				+ "{\r\n"
				+ "\"title\": \"RPA\",\r\n"
				+ "\"price\": 45,\r\n"
				+ "\"copies\": 10\r\n"
				+ "}\r\n"
				+ "]\r\n"
				+ "}\r\n"
				+ "");
		
		
		  int size = jp.getInt("courses.size()");
		  
		  for(int i=0; i<size; i++)
		  {
			  String title = jp.getString("courses["+i+"].title");
			  int price = jp.getInt("courses["+i+"].price");
			  
			  System.out.println(title+" "+price);
		  }
		
	}
	
	
	

}
