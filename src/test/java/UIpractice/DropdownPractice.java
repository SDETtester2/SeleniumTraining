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

public class DropdownPractice {
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
			// Single selection from dropdown
			WebElement country = driver
					.findElement(By.xpath("//option[@value='DZ']//parent::select[@id='country::content']"));
			// Explanation: //option[@value='DZ']- child tag
			// parent::select[@id='country::content']")); - parent tag. This parent tag
			// contains Country dropdown
			Select se = new Select(country);
			// Syntax : select (WebElement element)
			se.selectByVisibleText("USA");
			// se.selectByIndex(5);
			// se.selectByValue("BS");
			System.out.println("single dropdown selected");
			
			
			
			//Multiselect option
			
			driver.get("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
			WebElement multi = driver.findElement(By.xpath("//select[@id='multi-select']"));
			Select multise = new Select(multi);
			multise.selectByIndex(4);
			multise.selectByValue("Washington");
			multise.selectByVisibleText("Florida");
			List<WebElement> list1 = multise.getAllSelectedOptions();
			//System.out.println(list1);
			System.out.println(list1.size());
			multise.deselectAll();
			multise.selectByIndex(3);
			List<WebElement> list2 = multise.getAllSelectedOptions();
			//System.out.println(list1);
			System.out.println(list2.size());
			
			
		}

	}

}
