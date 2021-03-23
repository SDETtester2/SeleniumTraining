package UIpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebElementsMethods {
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
		}
		driver.get("https://profile.oracle.com/myprofile/account/create-account.jspx");

		// sendkeys method

		WebElement email = driver.findElement(By.xpath("//input[@name='email']"));
		email.sendKeys("testing@gmail.com");
		// clear method

				email.clear();

		// isDisplayed
		WebElement link = driver.findElement(By.xpath("//input[@id='postalCode::content']//following::a[1]"));
		boolean d = link.isDisplayed();
		System.out.println(d);
		// isenabled
		boolean e = link.isEnabled();
		System.out.println(e);

		// isselected();
		boolean s = link.isSelected();
		System.out.println(s);

		// gettagname
		String tagname = email.getTagName();
		System.out.println(tagname);

		// getattribute

		String attribute = email.getAttribute("name");
		System.out.println(attribute);

		// getcss
		WebElement button = driver.findElement(By.xpath("//a[@role='button']"));
		String value = button.getCssValue("background");
		System.out.println(value);

		// getsize,getlocation
		Dimension v = button.getSize();
		System.out.println(v);
		
		//getlocation
		Point l = button.getLocation();
		System.out.println(l);
		
		//click
		link.click();
		System.out.println("newpage opened");
		
		//submit
		driver.get("https://profile.oracle.com/myprofile/account/create-account.jspx");
		WebElement buttonone = driver.findElement(By.xpath("//a[@role='button']"));
		buttonone.submit();
		System.out.println("error msg showed in page");

		driver.quit();
	}

}
