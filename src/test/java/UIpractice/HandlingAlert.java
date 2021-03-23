package UIpractice;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;

import io.github.bonigarcia.wdm.WebDriverManager;
public class HandlingAlert {
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

		
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_alert");
		 driver.manage().window().maximize();
		 //accepting alert using accept() method and get text of the alert using getText()
		 driver.switchTo().frame("iframeResult");
		 driver.findElement(By.xpath("//button[text()='Try it']")).click();
		 String text = driver.switchTo().alert().getText();
		 System.out.println(text);
		 //import alert class and no need to enter driver.switchTo().alert() all the time
		 Alert alert = driver.switchTo().alert();
		 Thread.sleep(2000);
		 alert.accept();
		 System.out.println(driver.getTitle());
		 
		 
		 
		 // dismissing alert using dismiss()
		 
		 driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_alert");
		 driver.manage().window().maximize();
		 //accepting alert using accept() method and get text of the alert using getText()
		 driver.switchTo().frame("iframeResult");
		 driver.findElement(By.xpath("//button[text()='Try it']")).click();
		 Alert alerttwo = driver.switchTo().alert();
		 Thread.sleep(2000);
		 alerttwo.dismiss();
		 
		 //send text to the alert box using sendkeys();
		 driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
		 driver.manage().window().maximize();
		 driver.switchTo().frame("iframeResult");
		 driver.findElement(By.xpath("//button[text()='Try it']")).click();
		 Alert alertthree = driver.switchTo().alert();
		 Thread.sleep(2000);
		 alertthree.sendKeys("Hi Selenium");
		 alertthree.accept();
		 
		 
		
		
		
		
}
}
