package com.qsp.vtiger.genericUtility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ListenerImplementationClass implements ITestListener {

	
	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		test=report.createTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getMethod().getMethodName());
		test.log(Status.PASS, result.getThrowable());
		
	}
	
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL,result.getMethod().getMethodName());
		test.log(Status.FAIL, result.getThrowable());
		
	    try {
	    	String screenShotName=WebDriverUtility.takeScreenShot(BaseClass.sDriver, result.getMethod().getMethodName());
	    	test.addScreenCaptureFromPath(screenShotName);
	    	} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getMethod().getMethodName());
		test.log(Status.SKIP, result.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
	ExtentSparkReporter spark=new ExtentSparkReporter("./ExtentReports/vtigerReport.html");
	
	spark.config().setTheme(Theme.DARK);
	spark.config().setReportName("Vtiger Extent Report");
	spark.config().setDocumentTitle("Vtiger Report");
	
	report=new ExtentReports();
	report.attachReporter(spark);
	report.setSystemInfo("createdBy", "Akash");
	report.setSystemInfo("ReviwedBy", "Deepak");
	report.setSystemInfo("platform", "windows11");
	report.setSystemInfo("ServerName","ApacheTomcat");
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		report.flush();
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	/*public void onTestFailure(ITestResult result) {

		String testCaseName = result.getMethod().getMethodName();             //it willl give the name of the method whose screenshots is being taken.
		
		TakesScreenshot ts=(TakesScreenshot)BaseClass.sDriver;
		 File source = ts.getScreenshotAs(OutputType.FILE);
		 File destination = new File("C:\\Users\\SHUBHAM\\eclipse-A.Project\\vtiger\\Screenshots"+testCaseName+".png");
		 try {
			Files.copy(source, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
}*/
