package Herokuapp.TestCases;

import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import org.apache.http.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Herokuapp.Base.DriverClass;

public class A038_Typos extends DriverClass {

	WebElement paragraph;
	String actual_text;
	String expected_text = "Sometimes you'll see a typo, other times you won't.";
	String xPath_Para = "//div[@class='example']/p[2]";

	@BeforeClass
	private void setUp_Browser() throws InterruptedException,
			FileNotFoundException {
		setUp();
	}

	@AfterClass
	private void tearDown() {
		driver.quit();
	}

	@Test
	private void Typos() {
		driver.get("http://the-internet.herokuapp.com/typos");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		paragraph = driver.findElement(By.xpath(xPath_Para));
		actual_text = paragraph.getText();
		System.out.println(paragraph.getText());

		if (actual_text.equalsIgnoreCase(expected_text)) {
			System.out.println("Text are matching");
		} else {
			System.out.println("Text are not matching!!!");
			Assert.assertTrue(actual_text.equalsIgnoreCase(expected_text),
					"Text are not matching with each other!!!");
		}
	}

}
