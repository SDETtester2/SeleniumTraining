package UIpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

//import com.sun.org.apache.bcel.internal.generic.Select;
//import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XpathPracticeTwo {
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

		driver.get("https://profile.oracle.com/myprofile/account/create-account.jspx");

		// XPath axes methods

		// using child xpath
		// syntax= //tagname[@attribute='value']//child::tagname
		WebElement email = driver.findElement(By.xpath("//form[@id='f1']//child::input[@name='email']"));
		// Explanation: //form[@id='f1']/ = parent tag
		// child = helps to find child tag
		// ::input = it will list child input tags under parent tag
		// [@name='email'] = to fetch a specific input tag . this will select email
		// address field.

		email.sendKeys("testing@gmail.com");
		System.out.println("child xpath executed");
		Thread.sleep(2000);

		// Using Following xpath
		// Syntax: //tagname[@attribute='value']//following::tagname
		WebElement pwd = driver.findElement(By.xpath("//tr[@id='emailPanel']//following::input[2]"));
		// Explanation : //tr[@id='emailPanel'] - current node
		// //following::input[2] - following node. this following node contains password
		// textbox location
		pwd.sendKeys("testing");
		System.out.println("following xpath executed");

		// Using parent xpath
		// Syntax: //tagname[@attribute='value']//parent::tagname

		// selecting from dropdown menu. It has select tag
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
		System.out.println("Parent xpath executed");

		// Following Sibling
		// syntax = //tagname[@attribute='value']//following-sibling::tagname
		WebElement repwd = driver
				.findElement(By.xpath("//tr[@id='emailPanel']//following-sibling::td//following::input[2]"));
		// Explanation: //tr[@id='emailPanel'] = current node that contains 2 sibling
		// following-sibling::td = finding the 2 siblings with tagname td
		// following::input[2]= inside the sibling input tags are following. providing
		// particular index to
		// find the exact location of repassword textbox

		repwd.sendKeys("testing");
		System.out.println("Following sibling executed");

		// preceding
		// syntax = //tagname[@attribute='value']//preceding::tagname
		WebElement firstname = driver.findElement(By.xpath("//input[@placeholder = 'Last Name']//preceding::input[1]"));
		// Explanation: //input[@placeholder = 'Last Name'] = current node that contains
		// 5 before node
		// preceding::input[1] = providing exact index to find the firstname textbox
		firstname.sendKeys("test");
		System.out.println("Preceding executed");

		// preceding sibling
		// syntax = //tagname[@attribute='value']//preceding::tagname
		WebElement Lastname = driver.findElement(By
				.xpath("//tr[@id='jobTitlePanel']//preceding-sibling::tr[1]//child::input[@placeholder='Last Name']"));
		// Explantion = //tr[@id='jobTitlePanel'] = this current node have multiple
		// before sibling
		// preceding-sibling::tr[1] = this will choose exact sibling but unable to find
		// exact location of lastname
		//// child::input[@placeholder='Last Name'] = this will select exact location of
		// lastname textbox
		Lastname.sendKeys("one");
		System.out.println("Preceding sibling executed");

		// descendant
		// syntax= //tagname[@attribute='value']//descendant::tagname
		WebElement jobtitle = driver.findElement(By.xpath("//form[@id='f1']//descendant::input[6]"));
		// Explanation = //form[@id='f1'] = parent node and contains multiple children
		// and grandchildren
		// descendant::input[6] = exact children of parent node and it locates
		// jobtitlebox
		jobtitle.sendKeys("tester");
		System.out.println("descendant executed");

		// ancestor
		WebElement state = driver.findElement(By.xpath("//option[@value='3']//ancestor::select"));
		Select stateselect = new Select(state);
		stateselect.selectByVisibleText("Arkansas");
		System.out.println("ancestor executed");

	}
}
