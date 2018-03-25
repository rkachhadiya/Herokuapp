package Herokuapp.TestCases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Herokuapp.Base.DriverClass;

public class A007_DisapperingElements extends DriverClass{
	
	private WebElement bfr_Home, bfr_About, bfr_contactUs, bfr_portfolio, bfr_gallery;
	private WebElement aftr_Home, aftr_About, aftr_contactUs, aftr_portfolio, aftr_gallery;
	Robot robot; 
	Actions action;
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
	private void DisapperingElements() throws InterruptedException, AWTException{
		driver.get("http://the-internet.herokuapp.com/disappearing_elements");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		robot = new Robot();
		action = new Actions(driver);	
		WebElement ul_Element = driver.findElement(By.tagName("ul"));
		List<WebElement> links = ul_Element.findElements(By.tagName("li"));
		for (int i = 0; i < links.size(); i++)
		{
		    System.out.println(links.get(i).getText());
		    bfr_Home = driver.findElement(By.linkText(links.get(i).getText()));
		    
		    getCssValueofEveryElement(bfr_Home);
		    
		    openLinkinNewTab();			
			
			goToNewOpenedTabandReturnBack();
			
		}
		
	}
	
	
	private void getCssValueofEveryElement(WebElement el) throws InterruptedException{
		System.out.println("Before hover css values are: Color:" 
			    + el.getCssValue("color")
			    + " Background color: "+ el.getCssValue("background")
			    + " Font Size: "+ el.getCssValue("font-size"));		    
			    	    
			    action.moveToElement(el).build().perform();
			    
			    Thread.sleep(1000);
			    System.out.println("After hover css values are: Color:" 
					    + el.getCssValue("color")
					    + " Background color: "+ el.getCssValue("background")
					    + " Font Size: "+ el.getCssValue("font-size"));
	}
	
	private void openLinkinNewTab() throws InterruptedException{
		action.contextClick(bfr_Home).build().perform();
	    
	    robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);		
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
	}
	
	
	private void goToNewOpenedTabandReturnBack() throws InterruptedException{
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(1));
	    Thread.sleep(2000);
	    driver.close();
	    driver.switchTo().window(tabs.get(0)); 
	}

}
