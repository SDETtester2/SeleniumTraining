package UIpractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PrintAllLinks {
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
			
			//Total Links count and name of the links from webpage
			
			List<WebElement> links = driver.findElements(By.tagName("a"));
			System.out.println(links.size());
			for(int i=0;i<links.size();i++) {
			String linkstext = links.get(i).getText();
			System.out.println(linkstext);
			String linksname = links.get(i).getAttribute("href");
			System.out.println(linksname);
			}
			System.out.println("it lists all the link");
			//Dropdown list
			
			List<WebElement> drops = driver.findElements(By.tagName("option"));
			System.out.println(drops.size());
			for(int j=0;j<drops.size();j++) {
			System.out.println(drops.get(j).getAttribute("value"));
		}

			}
		}
	}
