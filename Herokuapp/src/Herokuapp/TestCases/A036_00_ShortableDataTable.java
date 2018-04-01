package Herokuapp.TestCases;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Herokuapp.Base.DriverClass;
import Herokuapp.Base.TableContent;

public class A036_00_ShortableDataTable extends DriverClass {
	
	static List<WebElement> firstColumn_Element;
	List<WebElement> ascending_order_list;
	List<WebElement> descending_order_list;
	static List<WebElement> expected_List;
	//Xpath using span and text
	static String lastName_Header = "//span[contains (., 'Last Name')]";
	//Xpath using id and tag
	static String table_Body = "//*[@id='table1']/tbody";
	static String table_td_lastName = "//*[@id='table1']/tbody/tr/td[1]";
	static String table_td_firstName = "//*[@id='table1']/tbody/tr/td[2]";
	static WebElement htmltable;
	static List<WebElement> rows;

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
	private void SortableDataTable() throws InterruptedException {
		driver.get("http://the-internet.herokuapp.com/tables");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(5000);
		
		getValueOfWholeWebTable();
		
		listElement();
		
		 for(Map.Entry<Integer, TableContent> entry:listElement().entrySet()){    
		        int key=entry.getKey();  
		        TableContent b=entry.getValue();  
		        System.out.println(key+" Details:");  
		        System.out.println(b.lName+" "+b.fName);   
		    } 
		
		Thread.sleep(5000);
	}
	
public static Map<Integer, TableContent> listElement(){
		
		Map<Integer, TableContent> map=new Hashtable<Integer,TableContent>();    
	    //Creating Books    
		getLastNameList(table_td_lastName);
		getLastNameList(table_td_firstName);
		
		for(int i=0; i<getLastNameList(table_td_lastName).size(); i++){
			TableContent t = new TableContent(getLastNameList(table_td_lastName).get(i).getText(), getLastNameList(table_td_firstName).get(i).getText());
			map.put(i, t);
		}
		
	     
		return map;
	}
	
	private static List<WebElement> getLastNameList(String table_td){		
		htmltable = driver.findElement(By.xpath(table_Body));
		rows = htmltable.findElements(By.tagName("tr"));
		firstColumn_Element = rows.get(0).findElements(By.xpath(table_td));		
		return firstColumn_Element;		
	}
	
	// Get List of elements 
	private List<WebElement> getValueOfWholeWebTable(){
		htmltable = driver.findElement(By.xpath(table_Body));
		rows = htmltable.findElements(By.tagName("tr"));
		firstColumn_Element = rows.get(0).findElements(By.xpath("//*[@id='table1']/tbody/tr/td"));
			for (int cnum = 0; cnum < firstColumn_Element.size(); cnum++) {
				System.out.println(firstColumn_Element.get(cnum).getText());
			}
		return firstColumn_Element;		
	}
	
	private static String[] expectedLastName(){		
		String[] expected_Listing = {"Smith", "Bach", "Doe", "Conway"};			
		return expected_Listing;		
	}
	
	private static String[] expectedFirstName(int i){	
		String[] expected_Listing = null;
		switch(i){		
		case 0:
			// Without sort list is
			expected_Listing = new String[] {"John", "Frank", "Jason", "Tim"};			
			break;
		case 1:
			// sorted list when Last name is in ascending order
			expected_Listing = new String[] {"Frank", "Tim", "Jason", "John"};			
			break;
		case 2:
			// sorted list when Last name is in Descending order
			expected_Listing = new String[] {"John", "Jason", "Tim", "Frank"};			
			break;
		default:
			System.out.println("No list found!!!");		
		}
		return expected_Listing;				
	}
	
	
}
