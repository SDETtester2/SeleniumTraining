package utlities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class TestListener implements ITestListener{

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		System.out.println("Test finish captured");
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		System.out.println("Test Started captured");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		System.out.println("Test failedbutwithin success captured");
	}

	public void onTestFailure(ITestResult arg0) {
		System.out.println("Test failed captured");
		
	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		System.out.println("Test skipped captured");
	}

	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		System.out.println("Test Start captured");
	}

	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		System.out.println("Test result captured");
	}
	
	
}
