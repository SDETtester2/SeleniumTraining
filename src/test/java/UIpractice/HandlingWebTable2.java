package UIpractice;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
//import org.openqa.selenium.WebDriver.Timeouts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingWebTable2 {
	public static String browser = "Edge";
	public static WebDriver driver;

	//@SuppressWarnings("deprecation")
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

		driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");
		
		/*step 1: Find the table location
		step 2: find the row size
		step3: Find the column size
		step 4: Iterate rows & columns and get text*/
		
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		//step1
		driver.findElement(By.xpath("//table[@class='tsc_table_s13']"));
		//Step2
		List<WebElement> rows = driver.findElements(By.xpath("//table[@class='tsc_table_s13']/tbody/tr/th"));
		int rowsize = rows.size();
		System.out.println(rowsize);
		
		//finding column size, you need to give tree index also. Then only it will show correct column nos such as 6
		//otherwise will list total no of columns such as 24
		//step 3
		List<WebElement> columns = driver.findElements(By.xpath("//table[@class='tsc_table_s13']/tbody/tr[1]/td"));
		int columnsize= columns.size();
		System.out.println(columnsize);
		
		//step 4
		for(int i = 1; i < rowsize; i++) {
			
			
			for(int j= 1; j<columnsize; j++) {
			
				
				System.out.println(driver.findElement(By.xpath("//table[@class='tsc_table_s13']/tbody/tr["+i+"]/td["+j+"]")).getText()+"");
			   
		}
		
	}
}
}
