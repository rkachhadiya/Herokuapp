package Herokuapp.TestCases;

import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Herokuapp.Base.DriverClass;

public class A009_Dropdown extends DriverClass{
	
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
	private void Dropdown() throws InterruptedException{
		driver.get("http://the-internet.herokuapp.com/dropdown");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement ele_Dropdown = driver.findElement(By.id("dropdown"));
		
		Select select_DropdownOption = new Select(ele_Dropdown);
		//select_DropdownOption.selectByIndex(1);
		select_DropdownOption.selectByVisibleText("Option 1");
		
		String selected_OptionValue = select_DropdownOption.getFirstSelectedOption().getText();		
		System.out.println("Selected option from dropdown is: "+ selected_OptionValue);		
		
	}

}
