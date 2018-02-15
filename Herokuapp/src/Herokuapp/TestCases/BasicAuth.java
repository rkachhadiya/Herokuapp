package Herokuapp.TestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BasicAuth {
	
	@BeforeClass
	public void setUp(){
		System.out.println("This is a success message");
	}
	
	@Test
	public void testMethod(){
		System.out.print("Test method run...");
	}

}
