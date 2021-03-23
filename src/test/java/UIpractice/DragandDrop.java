package UIpractice;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragandDrop {
	public static String browser = "Firefox";
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		if (browser.equals("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equals("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		WebElement frame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(frame);
		Thread.sleep(2000);
		System.out.println("Entered into frame");
		WebElement drag = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement drop = driver.findElement(By.xpath("//div[@id='droppable']"));
//		int x = drop.getLocation().getX();
//		int y = drop.getLocation().getY();
		System.out.println("Found expath");
		Actions draganddrop = new Actions(driver);
		Thread.sleep(2000);
		System.out.println("Going to drag");
		draganddrop.dragAndDrop(drag, drop).perform();
		//draganddrop.dragAndDrop(drag, drop).build().perform();
		
    // draganddrop.clickAndHold(drag).moveToElement(drop).release().build().perform();;
     
      System.out.println("drag and drop completed");
      
      //ReSizable
      driver.get("https://jqueryui.com/resizable/");
		driver.manage().window().maximize();
		WebElement frame2 = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(frame2);
		Thread.sleep(2000);
		System.out.println("Entered into frame");
		WebElement dragedge = driver.findElement(By.xpath("//div[@class='ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se']"));
		Actions resize = new Actions(driver);
		resize.dragAndDropBy(dragedge, 353, 170).perform();
		
		
	//Right Click
		
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		WebElement frame3 = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(frame3);
		Thread.sleep(2000);
		System.out.println("Entered into frame");
		WebElement drag2 = driver.findElement(By.xpath("//div[@id='draggable']"));
		Actions draganddrop2 = new Actions(driver);
		Thread.sleep(2000);
		System.out.println("Going to drag");
		draganddrop2.contextClick(drag2).perform();
      
		
		
	}
}
