package UIpractice;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataDrivenTesting {
	public static String browser = "Edge";
	public static WebDriver driver;

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException {
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

	
		driver.get("http://advantageonlineshopping.com/#/register");
		driver.manage().window().maximize();

		// Read location of the file
		FileInputStream file = new FileInputStream("C:\\JAVA Details\\JAVA Details\\Read Data Files\\Read1.xlsx");
		// Go to the workbook
		XSSFWorkbook wb = new XSSFWorkbook(file);

		// Go to the needed sheet in the workbook
		XSSFSheet sh = wb.getSheet("Sheet1");

		// Get the row numbers in the sheet

		int rownum = sh.getLastRowNum();

		for (int i = 1; i <= rownum; i++) {

			XSSFRow CurrentRow = sh.getRow(i);

			String UserName = CurrentRow.getCell(0).getStringCellValue();
			String Email = CurrentRow.getCell(1).getStringCellValue();
			String Password = CurrentRow.getCell(2).getStringCellValue();
			String FirstName = CurrentRow.getCell(3).getStringCellValue();
			String LastName = CurrentRow.getCell(4).getStringCellValue();
			int PhoneNumber = (int) CurrentRow.getCell(5).getNumericCellValue();
			String Country = CurrentRow.getCell(6).getStringCellValue();
			String City = CurrentRow.getCell(7).getStringCellValue();
			String Address = CurrentRow.getCell(8).getStringCellValue();
			String State = CurrentRow.getCell(9).getStringCellValue();
			int Postal = (int) CurrentRow.getCell(10).getNumericCellValue();

			// Find element for register
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			WebElement u1 = driver.findElement(By.xpath("//input[@name='usernameRegisterPage']"));
			u1.sendKeys(UserName);
			WebElement e1 = driver.findElement(By.xpath("//input[@name='emailRegisterPage']"));
			e1.sendKeys(Email);
			WebElement p1 = driver.findElement(By.xpath("//input[@name='passwordRegisterPage']"));
			p1.sendKeys(Password);
			WebElement p2 = driver.findElement(By.xpath("//input[@name='confirm_passwordRegisterPage']"));
			p2.sendKeys(Password);

			WebElement f1 = driver.findElement(By.xpath("//input[@name='first_nameRegisterPage']"));
			f1.sendKeys(FirstName);
			WebElement l1 = driver.findElement(By.xpath("//input[@name='last_nameRegisterPage']"));
			l1.sendKeys(LastName);
			WebElement ph1 = driver.findElement(By.xpath("//input[@name='phone_numberRegisterPage']"));
			ph1.sendKeys(String.valueOf(PhoneNumber));

			// Select Country

			Select se = new Select(driver.findElement(By.xpath("//select[@name='countryListboxRegisterPage']")));
			se.selectByVisibleText(Country);

			// Find element for city,Address,State,Postal

			WebElement c1 = driver.findElement(By.xpath("//input[@name='cityRegisterPage']"));
			c1.sendKeys(City);
			WebElement ad1 = driver.findElement(By.xpath("//input[@name='addressRegisterPage']"));
			ad1.sendKeys(Address);
			WebElement st1 = driver.findElement(By.xpath("//input[@name='state_/_province_/_regionRegisterPage']"));
			st1.sendKeys(State);
			WebElement po1 = driver.findElement(By.xpath("//input[@name='postal_codeRegisterPage']"));
			po1.sendKeys(String.valueOf(Postal));

			/*
			 * WebElement ch =
			 * driver.findElement(By.xpath("//span[@translate='offers_promotion']"));
			 * 
			 * if (ch.isSelected()) {
			 * 
			 * ch.click(); } //Click Register
			 * driver.findElement(By.xpath("//button[@id='register_btnundefined']")).click()
			 * ;
			 * 
			 * if(driver.getPageSource().contains("registerSuccess")) {
			 * System.out.println("Registaration completed for"+ i +"record");
			 * 
			 * }else { System.out.println("Registaration not completed for"+ i +"record"); }
			 */

			u1.clear();
			e1.clear();
			p1.clear();
			p2.clear();
			f1.clear();
			l1.clear();
			ph1.clear();
			c1.clear();
			ad1.clear();
			st1.clear();
			po1.clear();

		}
		driver.quit();
	}

}
