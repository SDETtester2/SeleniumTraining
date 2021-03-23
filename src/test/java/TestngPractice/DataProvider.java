package TestngPractice;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;


import common.BaseTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import utlities.DataEntry;
public class DataProvider  extends BaseTest{
	
	

  
	
	@Test(dataProvider = "register", dataProviderClass =DataEntry.class )
	
	public void datatest(String username, String email)  {
  
		
	driver.get("http://advantageonlineshopping.com/#/register");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	WebElement u1 = driver.findElement(By.xpath("//input[@name='usernameRegisterPage']"));
	u1.sendKeys(username);
	WebElement e1 = driver.findElement(By.xpath("//input[@name='emailRegisterPage']"));
	e1.sendKeys(email);
	
	
	
}
}
