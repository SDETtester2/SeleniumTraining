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
import org.openqa.selenium.interactions.Actions;

import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyEvents2{
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

		driver.get("https://www.salesforce.com/form/signup/freetrial-elf-v2-hp/?d=cta-jumbotron-2-freetrial-elf");
		
		WebElement firstname = driver.findElement(By.xpath("//input[@name='UserFirstName']"));
		firstname.sendKeys("testing copy paste");
		WebElement title = driver.findElement(By.xpath("//input[@name='UserTitle']"));
		Actions action = new Actions(driver);
		action.keyDown(firstname, Keys.CONTROL).sendKeys("a").sendKeys("x").build().perform();
		Thread.sleep(2000);
	    action.keyDown(title, Keys.CONTROL).sendKeys("v").build().perform();
		
	
	}
}
