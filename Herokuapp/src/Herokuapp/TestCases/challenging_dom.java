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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Herokuapp.Base.DriverClass;

public class challenging_dom extends DriverClass{
	
	DriverClass driverclass;
	private int invalidImageCount;
	
	@BeforeMethod
	private void setUp_Browser() throws FileNotFoundException{		
			setUp();		
	}
	
	@AfterMethod
	private void tearDown(){
		driver.quit();
	}
	
	@Test
	private void testMethod(){
		driver.navigate().to("http://the-internet.herokuapp.com/challenging_dom");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		List<WebElement> element = driver.findElements(By.tagName("img"));
		
		System.out.println("Number of Images are: " + element.size());
		
		for(WebElement imageElement : element){
			if(imageElement != null){
				verifyimageActive(imageElement);
			}
		}
		
		//System.out.println("Number of Broken Images are: " + invalidImageCount);		
	}
	
	
	public void verifyimageActive(WebElement imgElement) {
		try {
			HttpClient client = HttpClientBuilder.create().build();
			HttpGet request = new HttpGet(imgElement.getAttribute("src"));
			HttpResponse response = client.execute(request);
			// verifying response code he HttpStatus should be 200 if not,
			// increment as invalid images count
			if (response.getStatusLine().getStatusCode() != 200)	
				System.out.println("Broken Image is: "+ response.toString());
				invalidImageCount++;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
