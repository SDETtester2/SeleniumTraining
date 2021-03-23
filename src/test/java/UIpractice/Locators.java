package UIpractice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Locators {
   public static String browser = "Edge";
   public static WebDriver driver;
   //Notes: If we are instantiate firefox driver and chrome driver with two different variable name, we need to 
   //repeat the same automation code again for each variable (Example:driver , driverone). 
   //For remove the ambiguity in the code , we need to instantiate a webdriverManager. 
   //But Webdriver Manager is interface. We cannot instantiate a interface but we can instantiate a class  that can
   // implements a interface. Chromedriver, firefoxdriver, edgedriver are classes that implement a Webdriver Manager.
   // so we can instantiate these classes inside the if else loop.
   
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		if (browser.equals("Firefox")) {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	}else if (browser.equals("Chrome")){
	 WebDriverManager.chromedriver().setup();
	 driver = new ChromeDriver();
	} else if (browser.equals("Edge")) {
      WebDriverManager.edgedriver().setup();
      driver = new EdgeDriver();
}
		  
		// using all 8 locators
		  driver.get("https://www.saucedemo.com/");
		  WebElement username = driver.findElement(By.id("user-name"));
		  username.sendKeys("standard_user");
		  username.clear();
		  Thread.sleep(2000);
		  WebElement usernameone = driver.findElement(By.cssSelector("#user-name"));// right click on the html click 
		                                                                            //copy and choose css selector & copy here
		  usernameone.sendKeys("standard_user");
		  usernameone.clear();
		  Thread.sleep(2000);
		  WebElement usernametwo = driver.findElement(By.className("form_input"));
		  usernametwo.sendKeys("standard_user");
		  usernametwo.clear();
		  Thread.sleep(2000);
		  WebElement usernamethree = driver.findElement(By.name("user-name"));
		 usernamethree.sendKeys("standard_user");
		  usernamethree.clear();
		  Thread.sleep(2000);
		  WebElement usernamefour = driver.findElement(By.xpath("//*[@id=\"user-name\"]"));// right click on the html click 
                                                                                          //copy and choose xpath & copy here
		  usernamefour.sendKeys("standard_user");
		  usernamefour.clear();
		  Thread.sleep(2000);
		  WebElement usertag = driver.findElement(By.tagName("input"));
		  usertag.sendKeys("standard_user");
		  driver.get("https://www.selenium.dev/documentation/en/getting_started/");
		  WebElement link = driver.findElement(By.linkText("Quick tour"));
		  link.click();
		  Thread.sleep(3000);
		  driver.get("https://www.selenium.dev/documentation/en/getting_started/");
		  WebElement linktwo= driver.findElement(By.partialLinkText("Quick"));
		  linktwo.click();
		  Thread.sleep(2000);
		  driver.quit();
		
}
}