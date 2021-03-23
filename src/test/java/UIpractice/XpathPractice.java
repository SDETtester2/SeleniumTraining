package UIpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class XpathPractice {
	public static String browser = "Edge";
	public static WebDriver driver;
	// Notes: If we are instantiate firefox driver and chrome driver with two
	// different reference variable name, we need to
	// repeat the same automation code again for each variable (Example:driver ,
	// driverone).
	// For remove the ambiguity in the code , we need to instantiate a
	// webdriverManager.
	// But Webdriver Manager is interface. We cannot instantiate a interface but we
	// can instantiate a class that can
	// implements a interface. Chromedriver, firefoxdriver, edgedriver are classes
	// that implement a Webdriver Manager.
	// so we can instantiate these classes inside the if else loop.

	public static void main(String[] args) {
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

			driver.get("https://profile.oracle.com/myprofile/account/create-account.jspx");

			// find basic xpath
			// Syntax= // tagname [@attribute='value']
			// or //*[@attribute='value']

			WebElement email = driver.findElement(By.xpath("//input[@id='email::content']"));
			email.sendKeys("testgmail@gmail.com");
			System.out.println("basic xpath executed");

			// using or xpath
			// • Syntax:/tagname[@attribute='value' or @attribute='value']
			WebElement fname = driver.findElement(By.xpath("//input[@id='firstName::content' or @name='firstName']"));
			fname.sendKeys("testing");
			System.out.println("Using OR xpath executed");

			// Using and xpath
			// • Syntax:/tagname[@attribute='value' and @attribute='value']
			WebElement lname = driver.findElement(By.xpath("//input[@id='lastName::content' or @name='lastName']"));
			lname.sendKeys("purpose");
			System.out.println("Using and xpath executed");

			// Using Contains xpath
			// Syntax: //<HTML tag>[contains(@attribute_name,'attribute_value')]  
			// OR
			// *[contains(@attribute_name,'attribute_value')] 

			WebElement job = driver.findElement(By.xpath("//input[contains(@id,'jobTitle')]"));
			job.sendKeys("tester");
			System.out.println("Using Contains xpath executed");

			// Using Startswith xpath

			// Syntax: //<HTML tag>[starts-with(@attribute_name,'attribute_value')]  
			// OR
			// *[starts-with(@attribute_name,'attribute_value')]  

			WebElement phone = driver.findElement(By.xpath("//input[starts-with(@id,'workPhone')]"));
			phone.sendKeys("3250983209");
			System.out.println("Using startswith xpath executed");

			// Using text() xpath
			// Syntax: //tagname[text()=’text value‘]

			WebElement text = driver.findElement(By.xpath("//a[text()='Account Help']"));
			text.click();
			System.out.println("Using text xpath executed");

			driver.quit();

		}

	}

}
