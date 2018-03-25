package Herokuapp.TestCases;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Herokuapp.Base.DriverClass;

public class A008_DragAndDrop extends DriverClass{
	
	private WebElement eleA;
	private WebElement eleB;
	private int x1, y1, x2, y2;
	
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
	private void DragAndDrop() throws InterruptedException, AWTException{
		driver.get("http://the-internet.herokuapp.com/drag_and_drop");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//eleA = driver.findElement(By.id("column-a"));
		//eleA = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/header"));
		//eleA = driver.findElement(By.xpath("//*[@class='column'][1]"));
		//eleA = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/header"));
		//eleA = driver.findElement(By.cssSelector("div#column-a.column"));
		eleA = driver.findElement(By.xpath("//*[@id='column-a']"));
		org.openqa.selenium.Dimension dimA = eleA.getSize();
		x1 = eleA.getLocation().getX()+ dimA.width/2;
		y1 = eleA.getLocation().getY()+ dimA.height/2;
		System.out.println("X1 point is: "+ x1 + " Y1 point is: "+ y1);
		
		//eleB = driver.findElement(By.id("column-b"));
		
		eleB = driver.findElement(By.xpath("//*[@id='column-b']"));
		
		x2 = eleB.getLocation().getX()+ dimA.width/2;
		y2 = eleB.getLocation().getY()+ dimA.height/2;
		
		System.out.println("X2 point is: "+ x2 + " Y2 point is: "+ y2);		
		
		Point coordinate1 = eleA.getLocation();
		
		//new Actions(driver).dragAndDropBy(eleA, x2, y2).build().perform();
		//Actions builder = new Actions(driver);
		
		//builder.moveToElement(eleA, 317, 162).build().perform();
		
		//builder.dragAndDrop(eleA, eleB).perform();
		
		
		
		
		String xto=Integer.toString(eleB.getLocation().x);
	    String yto=Integer.toString(eleB.getLocation().y);
	    ((JavascriptExecutor)driver).executeScript("function simulate(f,c,d,e){var b,a=null;for(b in eventMatchers)if(eventMatchers[b].test(c)){a=b;break}if(!a)return!1;document.createEvent?(b=document.createEvent(a),a==\"HTMLEvents\"?b.initEvent(c,!0,!0):b.initMouseEvent(c,!0,!0,document.defaultView,0,d,e,d,e,!1,!1,!1,!1,0,null),f.dispatchEvent(b)):(a=document.createEventObject(),a.detail=0,a.screenX=d,a.screenY=e,a.clientX=d,a.clientY=e,a.ctrlKey=!1,a.altKey=!1,a.shiftKey=!1,a.metaKey=!1,a.button=1,f.fireEvent(\"on\"+c,a));return!0} var eventMatchers={HTMLEvents:/^(?:load|unload|abort|error|select|change|submit|reset|focus|blur|resize|scroll)$/,MouseEvents:/^(?:click|dblclick|mouse(?:down|up|over|move|out))$/}; " +
	    "simulate(arguments[0],\"mousedown\",0,0); simulate(arguments[0],\"mousemove\",arguments[1],arguments[2]); simulate(arguments[0],\"mouseup\",arguments[1],arguments[2]); ",
	    eleA,xto,yto);
		
		
		
		
		
		
		
	/*	Robot robot = new Robot();
		  robot.mouseMove(x1,y1+100);
		  robot.mousePress(InputEvent.BUTTON2_DOWN_MASK);
		  System.out.println("1");
		  Thread.sleep(5000);		
		//builder.clickAndHold(eleA).build().perform();
		builder.click().clickAndHold(eleA).build().perform();
		System.out.println("2");
		//Thread.sleep(5000);
		 Thread.sleep(5000);
		builder.moveToElement(eleB).build().perform();
		//builder.moveByOffset(x2, y2).build().perform();
		System.out.println("3");*/
		Thread.sleep(10000);
	}

}
