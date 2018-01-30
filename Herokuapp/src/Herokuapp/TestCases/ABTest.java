package Herokuapp.TestCases;

import java.io.FileNotFoundException;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Herokuapp.Base.DriverClass;

public class ABTest extends DriverClass{
	
	DriverClass driverclass;
	
	@BeforeClass
	private void setUp_Browser() throws InterruptedException,
			FileNotFoundException {
		setUp();			
	}
	
	@AfterClass
	private void tearDown(){
		driver.quit();
	}
	
	@Test
	private void testMethod() throws InterruptedException {
		driver.get("http://the-internet.herokuapp.com/");

		Thread.sleep(1000);
		driver.findElement(By.linkText("A/B Testing")).click();
	}
}
