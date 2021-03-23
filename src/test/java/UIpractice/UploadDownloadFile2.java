package UIpractice;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.sikuli.script.SikuliException;

import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UploadDownloadFile2{
	public static String browser = "Firefox";
			
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException, SikuliException {
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
		
		
		
		
		
      
		

		driver.get("https://opensource-demo.orangehrmlive.com/index.php/pim/addEmployee");
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");
		driver.findElement(By.xpath("//input[@name='Submit']")).click();
	
		
		
		//Add Employee
		
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("tester");
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@id='employeeId']")).sendKeys("120");
	
		Actions builder = new Actions(driver);

	    builder.moveToElement(driver.findElement(By.xpath("//input[@name='photofile']"))).click().build().perform();
		
		
		//upload
		
		String filebox = "C:\\JAVA Details\\JAVA Details\\picture files\\Filebox.PNG";
		String openbutton = "C:\\JAVA Details\\JAVA Details\\picture files\\openbox2.PNG";
		String picture = "C:\\JAVA Details\\JAVA Details\\picture files\\cat.PNG";
		
		Screen s = new Screen();                
		Pattern fileinput = new Pattern(filebox);
		Pattern opbutton = new Pattern(openbutton);
		
		s.wait(fileinput, 20);
		s.type(fileinput, picture);
		s.click(opbutton);
		
		//Download
		
		driver.get("http://demo.automationtesting.in/FileDownload.html");
		
		driver.findElement(By.xpath("//textarea[@id='textbox']")).sendKeys("tester text download");
		driver.findElement(By.xpath("//button[@id='createTxt']")).click();
		driver.findElement(By.xpath("//a[@id='link-to-download']")).click();
		
		String okbutton = "C:\\JAVA Details\\JAVA Details\\picture files\\ok.PNG";
		String savebutton = "C:\\JAVA Details\\JAVA Details\\picture files\\save.PNG";
		Screen s1= new Screen();
		s1.click(savebutton);
		s1.click(okbutton);
		
		
		
		
	}
}
