package pojo;

public class Example {
	
	String name;
	
	
	
	public void setName(String name)//setter method
	{
		this.name = name;
	}

	public String getName() // getter method
	{
		return name;
	}
	
	
	public static void main(String[] args) {
		
		Example e = new Example();
		
		e.setName("Daniel");
		
		String nameofperson = e.getName();
		
		System.out.println(nameofperson);
		
	}
}
