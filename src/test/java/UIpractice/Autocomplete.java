package UIpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Autocomplete {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.setProperty("webdriver.edge.driver","C:\\JAVA
		// Details\\Downloads\\Selenium webdrivers\\msedgedriver.exe");
		// WebDriverManager.edgedriver().setup();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.google.com/");
		WebElement enterbox = driver.findElement(By.name("q"));
		enterbox.clear();
		enterbox.sendKeys("javascript");
		enterbox.sendKeys(Keys.ARROW_DOWN);
		enterbox.sendKeys(Keys.ENTER);
		driver.close();
	}
}
