package Herokuapp.TestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Pagelink2 {
	@BeforeClass
	private void launchDriver() throws InterruptedException {
		System.out.println("Class 2");
		Thread.sleep(1000);
	}
	
	@Test
	private void testMethod() throws InterruptedException {
		System.out.println("This a test method!");
		Thread.sleep(2000);
	}
}
