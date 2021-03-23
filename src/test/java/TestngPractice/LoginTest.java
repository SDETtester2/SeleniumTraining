package TestngPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;


import common.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest extends BaseTest{
	
	
	

   
	@Test
	public void login() {
		
		
		driver.get("https://profile.oracle.com/myprofile/account/create-account.jspx");

		// sendkeys method

		WebElement email = driver.findElement(By.xpath("//input[@name='email']"));
		email.sendKeys("testing@gmail.com");
		
}
}