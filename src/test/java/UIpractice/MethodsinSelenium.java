package UIpractice;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MethodsinSelenium {
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

		// get command

		driver.get("https://www.saucedemo.com/");

		// getCurrentUrl()
		String actualurl = driver.getCurrentUrl();
		System.out.println(actualurl);

		// gettitle command

		String title = driver.getTitle();
		System.out.println(title);

		// getpagesource

		String source = driver.getPageSource();
		System.out.println(source);

		// source lenght
		int length = source.length();
		System.out.println(length);

		// manage

		driver.manage().window().maximize();

		// manage

		driver.manage().window().minimize();

		// equals

		if (actualurl.equals("https://www.saucedemo.com/")) {
			System.out.println("correct url");
		} else {
			System.out.println("wrong url");

		}

		Thread.sleep(3000);
		// navigate

		driver.navigate().to("https://www.google.com/");
		System.out.println("navigated to google");
		String windowone = driver.getWindowHandle();
		System.out.println(windowone);

		Thread.sleep(2000);
		driver.navigate().back();
		System.out.println("navigated back");

		Thread.sleep(2000);
		driver.navigate().forward();

		System.out.println("navigated forward");
		Thread.sleep(2000);
		Set<String> windowtwo = driver.getWindowHandles();
		System.out.println(windowtwo);

		driver.navigate().refresh();
		System.out.println("page refreshed");

		// quit
		driver.quit();
	}
}
