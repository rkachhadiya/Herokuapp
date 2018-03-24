package Herokuapp.TestCases;

import java.io.FileNotFoundException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Herokuapp.Base.DriverClass;

public class A002_BasicAuth extends DriverClass{
	
	DriverClass driverclass;
	
	@BeforeClass
	public void setUp_Driver() throws FileNotFoundException{
		setUp();
	}
	
	@Test
	public void testMethod(){
		String user = "admin", password = "admin";
		String URL = "http://" + user + ":" + password + "@" + "the-internet.herokuapp.com/basic_auth";
		
		driver.get(URL + "/");		
	}
	
	@AfterClass
	private void tearDown(){
		driver.quit();
	}

}
