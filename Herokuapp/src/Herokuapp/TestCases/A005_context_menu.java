package Herokuapp.TestCases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import Herokuapp.Base.DriverClass;

public class A005_context_menu extends DriverClass{
	
	DriverClass driverclass;
	Robot robot; 		
	WebElement checkbox1, checkbox2;
	
	@BeforeMethod
	private void setUp_Browser() throws FileNotFoundException{		
			setUp();		
	}
	
	@AfterMethod
	private void tearDown(){
		driver.quit();
	}
	
	@Test
	private void testMethod() throws InterruptedException, AWTException{
		driver.navigate().to("http://the-internet.herokuapp.com/context_menu");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		robot = new Robot();
		WebElement el = driver.findElement(By.id("hot-spot"));
		
		Actions action = new Actions(driver);
		action.contextClick(el).build().perform();
		Thread.sleep(5000);
		
		for(int i=0; i<5; i++){
			keyPressingEvent(i);
		}
		
		robot.keyPress(KeyEvent.VK_ENTER);		
		robot.keyRelease(KeyEvent.VK_ENTER);		
		Thread.sleep(5000);
		Assert.assertTrue(driver.switchTo().alert().getText().equalsIgnoreCase("You selected a context menu"), "Expected Texts are available in pop up");
		System.out.println("Text From alert are: " + driver.switchTo().alert().getText());
		
		driver.switchTo().alert().accept();
	}
	
	
	private void keyPressingEvent(int i) throws AWTException, InterruptedException{
		System.out.println(i);		
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
	}
	

}
