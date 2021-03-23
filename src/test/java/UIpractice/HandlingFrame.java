package UIpractice;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;

import io.github.bonigarcia.wdm.WebDriverManager;
public class HandlingFrame {
	public static String browser = "Edge";
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

		
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_default");
		 driver.manage().window().maximize();
		 //This will throws error of handling frame
		// driver.findElement(By.xpath("//button[text()='Click Me!']")).click();
		 
		 // A page can have multiple iframe. First We need to find  xpath for required iframe
		 WebElement framebyelemnet = driver.findElement(By.xpath("//iframe[@id='iframeResult']"));
		 //Then use switch method to navigate to the correct iframe. This iframe switch over by using Webelement
		 driver.switchTo().frame(framebyelemnet);
		 driver.findElement(By.xpath("//button[text()='Click Me!']")).click();
		 
		 
		 
		 //Switch to iframe using name or id of iframe
		 driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_default");
		 driver.manage().window().maximize();
		 driver.switchTo().frame("iframeResult");
		 driver.findElement(By.xpath("//button[text()='Click Me!']")).click();
		 
		 //Switch to iframe using index of the iframe
		 driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_default");
		 driver.manage().window().maximize();
		 //To find frame index , you need enter //iframe in the search html box. It will display how many iframe tag
		 //presented in the page. move the cursor and find out which index it will stop. Each index start with 0
		 // For Example. if the page have 2 frame and the current frame is 1 ,then index of that iframe is 0
		 driver.switchTo().frame(0);
		 driver.findElement(By.xpath("//button[text()='Click Me!']")).click();
		 
		 
		 
		 
		 
		 
		 
		 
		
		
		
		
}
}
