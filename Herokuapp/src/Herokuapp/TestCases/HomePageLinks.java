package Herokuapp.TestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomePageLinks {

	@BeforeClass
	private void launchDriver() throws InterruptedException {
		System.out.println("This is an issue");
		Thread.sleep(1000);
	}
	
	@Test
	private void testMethod() throws InterruptedException {
		System.out.println("This a test method!");
		System.out.println(10/0);
		Thread.sleep(1000);
	}
}