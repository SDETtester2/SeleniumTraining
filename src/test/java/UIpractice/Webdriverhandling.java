package UIpractice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Webdriverhandling {
   public static String browser = "Chrome";
   public static WebDriver driver;
   //Notes: If we are instantiate firefox driver and chrome driver with two different variable name, we need to 
   //repeat the same automation code again for each variable (Example:driver , driverone). 
   //For remove the ambiguity in the code , we need to instantiate a webdriverManager. 
   //But Webdriver Manager is interface. We cannot instantiate a interface but we can instantiate a class  that can
   // implements a interface. Chromedriver, firefoxdriver, edgedriver are classes that implement a Webdriver Manager.
   // so we can instantiate these classes inside the if else loop.
   
	public static void main(String[] args) {
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
		  WebElement username = driver.findElement(By.id("user-name"));
		  username.sendKeys("standard_user");
		  WebElement password = driver.findElement(By.id("password"));
		  password.sendKeys("secret_sauce");
		  WebElement button = driver.findElement(By.className("btn_action"));
		  button.click();
		  driver.quit();
}
}