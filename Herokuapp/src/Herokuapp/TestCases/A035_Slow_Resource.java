package Herokuapp.TestCases;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Herokuapp.Base.DriverClass;

public class A035_Slow_Resource{
	
	//public static WebDriver driver;
	RemoteWebDriver driver;
	public static String chromeDriverPath = "./Resources/chromedriver.exe";
	ChromeOptions options;
	
	@BeforeClass
	private void setUp_Browser() throws InterruptedException,
			FileNotFoundException, MalformedURLException {
		//setUp();	
		options = new ChromeOptions();
		options.addArguments("--disable-extensions");
		options.addArguments("--disable-save-password");
		options.addArguments("disable-infobars");
		options.addArguments("--disable-notifications");
		
		
		System.out.println("launching chrome browser");
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		driver = new ChromeDriver(options);
		//driver = new RemoteWebDriver(new URL("http://the-internet.herokuapp.com/slow"), cap);
	}
	
	@AfterClass
	private void tearDown(){
		driver.quit();
	}
	
	@Test
	private void Slow_Resource(){
		//driver.get("http://the-internet.herokuapp.com/slow");
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		measureTimeOfLoadWebpage();		
	
	}
	
	/* Find time of web page load
	 * Verify condition until specific element is not loaded on page.
	 * Get Time in milliseconds
	 * Convert milliseconds to seconds
	 * Measure time of load to webpage
	 */
	private void measureTimeOfLoadWebpage(){
		long startTime = System.currentTimeMillis();

		driver.get("http://the-internet.herokuapp.com/slow");

		new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.linkText("Elemental Selenium")));

		long endTime = System.currentTimeMillis();

		long totalTime = endTime - startTime;

		System.out.println("Total Page Load Time: " + totalTime + " milliseconds");
		System.out.println("Total Page Load Time: " + TimeUnit.MILLISECONDS.toSeconds(totalTime) + " seconds");
	}

}
