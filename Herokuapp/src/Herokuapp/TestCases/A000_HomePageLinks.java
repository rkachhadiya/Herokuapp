package Herokuapp.TestCases;

import java.io.FileNotFoundException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Herokuapp.Base.DriverClass;

public class A000_HomePageLinks extends DriverClass {

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
	public void testMethod() throws MalformedURLException, Exception {

		driver.get("http://the-internet.herokuapp.com/");

		Thread.sleep(10000);

		List<WebElement> listOfLinks = new ArrayList<WebElement>();
		listOfLinks = driver.findElements(By.tagName("a"));

		for (WebElement webElement : listOfLinks) {
			System.out.println(webElement.getText());
			System.out.println("URL: " + webElement.getAttribute("href")
					+ " returned "
					+ isLinkBroken(new URL(webElement.getAttribute("href"))));
		}
		
		System.out.println("All links are verified!!!");
	}

	public static String isLinkBroken(URL url) throws Exception

	{
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		try {
			connection.connect();
			String response = connection.getResponseMessage();
			connection.disconnect();
			return response;
		}

		catch (Exception exp) {
			return exp.getMessage();
		}
	}
}
