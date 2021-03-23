package utlities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import common.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.mysql.cj.xdevapi.Result;

import ExtentReport.ExtentManager;

public class ExtentListener implements ITestListener{
	
	private static ExtentReports extent = ExtentManager.setExtent();
	private static ThreadLocal<ExtentTest> extenttest = new ThreadLocal<ExtentTest>();

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		if(extent != null) {
			extent.flush();
		}
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		WebDriver driver =((BaseTest)result.getInstance()).driver;
		
		try {
			String path = getScreenshot(driver,result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String logtext ="<b>Test Method "+result.getMethod().getMethodName()+"failure</b>";
		extenttest.get().log(Status.FAIL,logtext); // to add name in extent report
		extenttest.get().log(Status.FAIL, "TEST CASE FAILED IS " + result.getThrowable());
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String logtext ="<b>Test Method "+result.getMethod().getMethodName()+"skipped</b>";
		//logger = extent.createTest("passTest");
		//Assert.assertTrue(true);
		//To generate the log when the test case is passed
		extenttest.get().log(Status.SKIP, logtext);
		
	}

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ExtentTest test = extent.createTest(result.getTestClass().getName()+"::"+result.getMethod().getMethodName());
		extenttest.set(test);
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		String logtext ="<b>Test Method "+result.getMethod().getMethodName()+"successful</b>";
		//logger = extent.createTest("passTest");
		//Assert.assertTrue(true);
		//To generate the log when the test case is passed
		extenttest.get().log(Status.PASS,logtext);
		
	}
	
	 public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException {
		  String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		  TakesScreenshot ts = (TakesScreenshot) driver;
		  File source = ts.getScreenshotAs(OutputType.FILE);
		  
		  // after execution, you could see a folder "FailedTestsScreenshots" under src folder
		  String destination = System.getProperty("user.dir") + "/Screenshotsdetails/" + screenshotName + dateName + ".png";
		  File finalDestination = new File(destination);
		  FileUtils.copyFile(source, finalDestination);
		  return destination;
		 }

}
