package Herokuapp.TestCases;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import Herokuapp.Base.DriverClass;

public class context_menu extends DriverClass{
	
	DriverClass driverclass;
		
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
	private void testMethod() throws InterruptedException{
		driver.navigate().to("http://the-internet.herokuapp.com/checkboxes");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		boolean chk_checking = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]")).isSelected();
				if(chk_checking == true){
					System.out.println("Checkbox is selected");
					driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]")).click();
				} else {
					System.out.println("Checkbox2 is not selected");
				}
				Thread.sleep(10000);
				chk_checking = driver.findElement(By.cssSelector("input[type=\"checkbox\"]")).isSelected();
				
				if(chk_checking == false){
					System.out.println("Checkbox is not selected");
					driver.findElement(By.cssSelector("input[type=\"checkbox\"]")).click();
				} else {
					System.out.println("Checkbox 1 is selected");
				}
				
				Thread.sleep(10000);
	}
	

}
