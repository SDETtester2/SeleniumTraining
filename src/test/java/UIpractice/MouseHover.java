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

public class MouseHover {
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

		driver.get("https://www.amazon.com/");
		
		WebElement hover = driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));
		Actions action = new Actions(driver);
		action.moveToElement(hover).perform();
		WebElement sublink= driver.findElement(By.xpath("//span[text()='Orders']"));
		sublink.click();
		
	
	}
}
