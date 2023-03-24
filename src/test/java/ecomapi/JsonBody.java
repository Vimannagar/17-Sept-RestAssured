package ecomapi;

public class JsonBody {
	
	public static String getOrderBody(String prdid)
	{
		String body = "{\"orders\": [\r\n"
				+ "        {\r\n"
				+ "        \"country\": \"India\", \r\n"
				+ "        \"productOrderedId\" : \""+prdid+"\"\r\n"
				+ "        }\r\n"
				+ "    ]\r\n"
				+ "}";
		
		return body;
	}

}
