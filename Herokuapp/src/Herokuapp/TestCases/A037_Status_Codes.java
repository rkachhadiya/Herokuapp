package Herokuapp.TestCases;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Herokuapp.Base.DriverClass;

public class A037_Status_Codes extends DriverClass {

	private String _url;

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
	private void StatusCodes() throws MalformedURLException, IOException {
		driver.get("http://the-internet.herokuapp.com/status_codes");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement ul_Element = driver.findElement(By.tagName("ul"));
		List<WebElement> links = ul_Element.findElements(By.xpath("//li/a"));
		for (int i = 0; i < links.size(); i++) {
			System.out.println("Print link text from page: "
					+ links.get(i).getText());
			_url = links.get(i).getAttribute("href");
			System.out.println(links.get(i).getAttribute("href"));

			if (links.get(i).getText()
					.equalsIgnoreCase(responseStatusCode(_url))) {
				System.out.println("Case is pass for: "
						+ links.get(i).getText());
				Assert.assertTrue(
						links.get(i).getText()
								.equalsIgnoreCase(responseStatusCode(_url)),
						"Case is pass for: " + links.get(i).getText());
			}
		}
	}

	private String responseStatusCode(String _url)
			throws MalformedURLException, IOException {
		HttpURLConnection.setFollowRedirects(false);
		HttpURLConnection con = (HttpURLConnection) new URL(_url)
				.openConnection();
		con.setRequestMethod("HEAD");

		int responseCode = con.getResponseCode();

		System.out.println("Print response code: " + responseCode);
		return Integer.toString(responseCode);
	}

}
