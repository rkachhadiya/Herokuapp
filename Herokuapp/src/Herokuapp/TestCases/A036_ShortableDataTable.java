package Herokuapp.TestCases;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Herokuapp.Base.DriverClass;

public class A036_ShortableDataTable extends DriverClass {
	
	List<WebElement> firstColumn_Element, ascending_order_list, descending_order_list;
	static List<WebElement> expected_List;
	//Xpath using span and text
	String lastName_Header = "//span[contains (., 'Last Name')]";
	//Xpath using id and tag
	String table_Body = "//*[@id='table1']/tbody";
	String table_td_lastName = "//*[@id='table1']/tbody/tr/td[1]";
	String table_td_firstName = "//*[@id='table1']/tbody/tr/td[2]";
	WebElement htmltable;
	List<WebElement> rows;

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
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		Thread.sleep(5000);
		
		System.out.println("Get value of whole webtable elements");
		getValueOfWholeWebTable();
		
		
		System.out.println("Original List");
		getLastNameList(table_td_lastName);
		printTheList(getLastNameList(table_td_lastName));
		
		//This is original List take it.
		if(matchTheElement(getLastNameList(table_td_lastName), expectedLastName())){
			System.out.println("List are matching");
		}else{
			System.out.println("List are not matching");
		}
		
		
		driver.findElement(By.xpath(lastName_Header)).click();
		System.out.println("Ascending List");
		getLastNameList(table_td_lastName);
		printTheList(getLastNameList(table_td_lastName));
		if(matchTheElement(getLastNameList(table_td_lastName), convertToAscendingList(expectedLastName()))){
			System.out.println("List are matching");
		}else{
			System.out.println("List are not matching");
		}
		
		driver.findElement(By.xpath(lastName_Header)).click();
		System.out.println("Descending List");
		getLastNameList(table_td_lastName);
		printTheList(getLastNameList(table_td_lastName));
		if(matchTheElement(getLastNameList(table_td_lastName), convertToDescendingList(expectedLastName()))){
			System.out.println("List are matching");
		}else{
			System.out.println("List are not matching");
		}	
		
		Thread.sleep(5000);
	}
	
	private List<WebElement> getLastNameList(String table_td){		
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
	
	// Convert List<String> to Descending order or convert String[] to descending list
	private static String[] convertToDescendingList(String[] descendingList){		
		List<String> list = Arrays.asList(descendingList);
		Collections.sort(list, Collections.reverseOrder());		
		return descendingList;			
	}
	
	//Convert List<String> to Ascending order or convert String[] to Ascending list
	private static String[] convertToAscendingList(String[] ascendingList){			
		List<String> list = Arrays.asList(ascendingList);
		Collections.sort(list);		
		return ascendingList;			
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
	
	private static String[] expectedLastName2(){		
		String[] expected_Listing = {"Smith", "Bach", "Doe", "Conway"};			
		return expected_Listing;		
	}
	
	// Print the list of elements
	private void printTheList(List<WebElement> listWebElement){
		for(int i=0; i<listWebElement.size(); i++){
			System.out.println(listWebElement.get(i).getText());
		}
	}
	
	// Compare two list. Compare List<WebElement> with String[] array.
	private Boolean matchTheElement(List<WebElement> Actual_Element, String[] expected_Element){
			for(int i=0; i<expected_Element.length; i++){
				if(Actual_Element.get(i).getText().equalsIgnoreCase(expected_Element[i]) == false){
					System.out.println(Actual_Element.get(i).getText() + " is not matching with: "+ expected_Element[i]);
					return false;
				}
				System.out.println(Actual_Element.get(i).getText() + " is matching with: "+ expected_Element[i]);
			}
		System.out.println("All Elements are matched!!!");
		return true;		
	}
}
