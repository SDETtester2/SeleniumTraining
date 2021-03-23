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

public class UploadDownloadFile{
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
		
		
		
		
		String filepath = "C:\\JAVA Details\\JAVA Details\\picture files\\";
        String inputFilePath = "C:\\JAVA Details\\JAVA Details\\picture files\\";
        Screen s = new Screen();
        Pattern fileInputTextBox = new Pattern(filepath + "Filebox.PNG");
        
        Pattern openButton = new Pattern(filepath + "openbox2.PNG");
      
       driver.get("http://demo.guru99.com/test/image_upload/index.php");

        // Click on Browse button and handle windows pop up using Sikuli
       Actions builder = new Actions(driver);

       builder.moveToElement(driver.findElement(By.xpath("//input[@name='photoimg']"))).click().build().perform();
       // driver.findElement(By.xpath(".//*[@id='photoimg']")).click();
        s.wait(fileInputTextBox, 20);
        s.type(fileInputTextBox, inputFilePath + "cat.PNG");
        s.click(openButton);

        // Close the browser
       // driver.close();
		

		/*driver.get("https://opensource-demo.orangehrmlive.com/index.php/pim/addEmployee");
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
	
		
		
		//Add Employee
		
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("tester");
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@id='employeeId']")).sendKeys("120");
		driver.findElement(By.xpath("//input[@name='photofile']")).sendKeys(Keys.TAB);;
		
		//upload
		
		String filebox = "C:\\JAVA Details\\JAVA Details\\picture files\\Filebox.PNG";
		String openbutton = "C:\\JAVA Details\\JAVA Details\\picture files\\openbox.PNG";
		String picture = "C:\\JAVA Details\\JAVA Details\\picture files\\cat.PNG";
		
		Screen s = new Screen();                
		Pattern fileinput = new Pattern(filebox);
		Pattern opbutton = new Pattern(openbutton);
		
		s.wait(fileinput, 20);
		s.type(fileinput, picture);
		s.click(opbutton);
		*/
		
		
		
		
	}
}
