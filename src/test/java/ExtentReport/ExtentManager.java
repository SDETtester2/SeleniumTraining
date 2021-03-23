package ExtentReport;


import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ExtentManager {
	
	//public WebDriver driver;
	 
	 private static ExtentReports extent;
	
	@BeforeClass
	public static ExtentReports setExtent() {
		
		ExtentHtmlReporter htmlReporter;
		  // specify location of the report
		  htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/automationextentReport.html");

		  htmlReporter.config().setDocumentTitle("Automation Report"); // Tile of report
		  htmlReporter.config().setReportName("Functional Testing"); // Name of the report
		  htmlReporter.config().setTheme(Theme.DARK);
		  
		  extent = new ExtentReports();
		  extent.attachReporter(htmlReporter);
		  
		  // Passing General information
		  extent.setSystemInfo("Host name", "localhost");
		  extent.setSystemInfo("Environemnt", "QA");
		  extent.setSystemInfo("user", "anu");
		  return extent;
		  
		 }

}
