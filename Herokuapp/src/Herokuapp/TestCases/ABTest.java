package Herokuapp.TestCases;

import static org.testng.Assert.assertEquals;

import java.io.FileNotFoundException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import Herokuapp.Base.DriverClass;

public class ABTest extends DriverClass{
	
	DriverClass driverclass;
	
	@BeforeClass
	private void setUp_Browser() throws InterruptedException,
			FileNotFoundException {
		System.out.println("Current Running class is: "+ this.getClass().getSimpleName());
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
				
		String ABTesting = "//div[contains(@class, 'example')]/h3";
		WebElement ABtestelement = driver.findElement(By.xpath(ABTesting));
		
		String header = ABtestelement.getText();
		System.out.println(header);
		//assert header != "A/B Test Variation 1" : header == "A/B Test Variation 1";
		assert header.equalsIgnoreCase("A/B Test Variation 1");
		
		String paragraph = "Also known as split testing. This is a way in which businesses are able to simultaneously test and learn different versions of a page to see which text and/or functionality works best towards a desired outcome (e.g. a user action such as a click-through).";
		
		String paraXpath = "//div[contains(@class, 'example')]/p";
		WebElement paraElement = driver.findElement(By.xpath(paraXpath));
		
		String paraString = paraElement.getText();
		
		assertEquals(paraString, paragraph, "Paragraph is not matched!!!");
		
		System.out.println("Page is opened!!!");
	}
}
