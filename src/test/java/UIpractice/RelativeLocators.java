package UIpractice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;//This library is for Relative locators 

public class RelativeLocators {
   public static String browser = "Edge";
   public static WebDriver driver;
   //Notes: If we are instantiate firefox driver and chrome driver with two different reference variable name, we need to 
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
		  driver.get("https://www.saucedemo.com/");
		
		  //Below Locator
		  WebElement unameone = driver.findElement(By.id("user-name"));
		  unameone.sendKeys("standard_user");
		  WebElement pwone = driver.findElement(By.id("password"));
		  pwone.sendKeys("secret_sauce");
		  WebElement button = driver.findElement(withTagName("input").below(pwone));
		  button.click();
		  Thread.sleep(4000);
		  System.out.println("Below locator executed");
		  Thread.sleep(3000);
		  
		  //Above Locator
		  driver.get("https://www.saucedemo.com/");
		  WebElement password = driver.findElement(By.id("password"));
		  password.sendKeys("secret_sauce");
		  WebElement username = driver.findElement(withTagName("input")
                  .above(password));
		  username.sendKeys("standard_user");
		  System.out.println("Above locator executed");
		  Thread.sleep(2000);
		  username.clear();
		  password.clear();
		;
		  Thread.sleep(3000);
		  
		  
		  
		  //the Right of locator
		  
			driver.get("https://www.google.com/");
			 WebElement textboxone = driver.findElement(By.name("q"));
			  textboxone.sendKeys("Java");
			  Thread.sleep(2000);
	          WebElement bone = driver.findElement(By.name("btnK"));
	          WebElement btwo = driver.findElement(withTagName("input").toRightOf(bone));
	          Thread.sleep(3000);
	          btwo.click();
	          System.out.println("the right of locator executed");
	         
	          Thread.sleep(3000);
			  
		  // Near locator
		  driver.get("https://www.google.com/");
		  WebElement textbox = driver.findElement(By.name("q"));
		  textbox.sendKeys("Java");
		  Thread.sleep(2000);
          WebElement bthree = driver.findElement(By.name("btnI"));
          WebElement bfour = driver.findElement(withTagName("input").near(bthree));
          Thread.sleep(3000);
          bfour.click();
          System.out.println("Near Locator Executed");
          Thread.sleep(3000);
           
          //Close the driver
          driver.quit();
}
}