package Herokuapp.Base;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;

public class TableContent {

public String fName;
public String lName; 
	
	public TableContent(String lName, String fName) {    
		this.lName = lName;
	    this.fName = fName; 	        
	}
	
	/*public void getfName(){
		
	}
	
	public String setfName(){
	
		return fName;
	}*/
	
	
/*	Hashtable<List<WebElement>, List<WebElement>> tableContent = new Hashtable<List<WebElement>, List<WebElement>>();
	
	tableContent.put(getLastNameList(table_td_lastName), getLastNameList(table_td_firstName));
	for(Map.Entry m:tableContent.entrySet()){  
		   System.out.println(m.getKey()+" "+m.getValue());  
		  } 

	for(int i=0; i<tableContent.size(); i++){
		String fname;
		String lname;
		lname = tableContent.get(i).toString();
		System.out.println(lname);
	}*/
}
