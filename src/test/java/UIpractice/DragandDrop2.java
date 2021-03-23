package UIpractice;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class DragandDrop2 {
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

		driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml5_draganddrop");
		driver.manage().window().maximize();
		WebElement frame = driver.findElement(By.xpath("//iframe[@id='iframeResult']"));
		JavascriptExecutor jexec = (JavascriptExecutor)driver;
		driver.switchTo().frame(frame);
		Thread.sleep(2000);
		System.out.println("Entered into frame");
		
		//Execute script
		jexec.executeScript("allowDrop(ev);");
		jexec.executeScript("drag(ev);");
		jexec.executeScript("drop(ev);");
		Thread.sleep(2000);
     
      System.out.println("drag and drop completed");
      
      
		
	}
}
