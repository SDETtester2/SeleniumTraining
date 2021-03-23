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
public class Checkbox {
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

		
		driver.get("https://www.amazon.com/");
		
		
		WebElement searchbox = driver.findElement(By.id("twotabsearchtextbox"));
        searchbox.sendKeys("laptop");
        Thread.sleep(4000);
        WebElement buttons = driver.findElement(By.id("nav-search-submit-button" ));
        //driver.findElement(By.xpath("//input[@class='nav-input']")).click();
        buttons.click();
        Thread.sleep(4000);
        driver.manage().window().maximize();
        Thread.sleep(2000);
//        WebElement price = driver.findElement(By.xpath("//span[text()='MSI']"));
//        Actions action = new Actions(driver);
//        action.moveToElement(price);
//        action.perform();
        WebElement se = driver.findElement(By.xpath("//span[text()='Microsoft']"));
        Thread.sleep(4000);
        WebElement se1 = driver.findElement(withTagName("i").near(se));
        se1.click();
        Thread.sleep(4000);
        WebElement dtwo = driver.findElement(By.xpath("//span[text()='Apple']"));
        dtwo.click();
        Thread.sleep(4000);
        dtwo.click();
}
}
