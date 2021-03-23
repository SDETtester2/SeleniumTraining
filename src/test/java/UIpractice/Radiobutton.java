package UIpractice;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;

import io.github.bonigarcia.wdm.WebDriverManager;
public class Radiobutton {
	public static String browser = "Edge";
	public static WebDriver driver;
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

		
		driver.get("https://www.priceline.com/");
		
		
		WebElement flight = driver.findElement(By.xpath("//div[text()='FLIGHTS']"));
       flight.click();
        Thread.sleep(4000);
        driver.manage().window().maximize();
        
        WebElement buttons = driver.findElement(By.xpath("//form[@id ='flight-search-form']//child::label[text()='One-way']"));
        buttons.click();
      
        Thread.sleep(4000);
        
        
          WebElement buttons2 = driver.findElement(By.xpath("//form[@id ='flight-search-form']//child::label[text()='Multi-destination']"));
          
          if(!buttons2.isSelected()) {
        	  buttons2.click();
          }

}
}
