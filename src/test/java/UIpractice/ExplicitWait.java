package UIpractice;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;

import io.github.bonigarcia.wdm.WebDriverManager;
public class ExplicitWait {
	public static String browser = "Edge";
	public static WebDriver driver;
	@SuppressWarnings("deprecation")
	public static void main(String[] args)  {
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

		
		driver.get("https://www.amazon.com/");
		//driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		
		WebElement searchbox = driver.findElement(By.id("twotabsearchtextbox"));
        searchbox.sendKeys("laptop");
       // Thread.sleep(4000);
        WebElement buttons = driver.findElement(By.id("nav-search-submit-button" ));
        //driver.findElement(By.xpath("//input[@class='nav-input']")).click();
        buttons.click();
        
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
       WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
       WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(20));
//        WebElement price = driver.findElement(By.xpath("//span[text()='MSI']"));
//        Actions action = new Actions(driver);
//        action.moveToElement(price);
//        action.perform();
       // WebElement se = driver.findElement(By.xpath("//span[text()='Microsoft']"));
       
        WebElement se1 = driver.findElement(By.xpath("//span[text()='Microsoft']"));
         se1.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Clear']"))).click();
        //se1.click();
        
       // WebElement dtwo = driver.findElement(By.xpath("//span[text()='Apple']"));
       // dtwo.click();
       // dtwo.click();
        
        wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Apple']"))).click();
        System.out.println("It's clicked apple");
        wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Apple']"))).click();
        System.out.println("It's unclicked apple");
        
}
}
