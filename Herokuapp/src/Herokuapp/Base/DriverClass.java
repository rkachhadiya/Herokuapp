package Herokuapp.Base;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverClass extends Baseclass {

	public static String geckoDriverPath = "./Resources/geckodriver.exe";
	public static String chromeDriverPath = "./Resources/chromedriver.exe";
	public static String InfoAndActivities = "./Resources/config/config.properties";

	public static WebDriver driver;

	public static WebDriver launchDriver(String driverName) {
		if (driverName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", geckoDriverPath);
			driver = new FirefoxDriver();

		} else if (driverName.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-extensions");
			options.addArguments("--disable-save-password");
			options.addArguments("disable-infobars");
			options.addArguments("--disable-notifications");

			System.out.println("launching chrome browser");
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			driver = new ChromeDriver(options);
		}
		return driver;
	}
	
	public void setUp() throws FileNotFoundException{
		launchDriver(getPropertyvalue("browserType", InfoAndActivities));

		driver.manage().window().maximize();
	}
	
	public void quiteDriver() {
		quiteDriver();
	}

}
