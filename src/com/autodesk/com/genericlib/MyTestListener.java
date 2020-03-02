package com.autodesk.com.genericlib;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.google.common.io.Files;

public class MyTestListener implements ITestListener 
{

	
	int passCount,failCount,skipCount;
	@Override
	public void onTestStart(ITestResult result) {
		Reporter.log(result.getName()+"script execution started"+new Date(),true);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		passCount++;
		Reporter.log(result.getName()+"script passed"+new Date(),true);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		failCount++;
		Reporter.log(result.getName()+"script failed"+new Date(),true);
		/*TakesScreenshot ts=(TakesScreenshot) BaseLib.driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		File desFile=new File("./screenshots/screenshot.png");
		
		try {
			Files.copy(srcFile, desFile);
		} catch (IOException e) {
			
			e.printStackTrace();
		}*/
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		skipCount++;
		Reporter.log(result.getName()+"script skipped"+new Date(),true);
		
	}

	@Override
	public void onStart(ITestContext context) {
		
		
		Reporter.log(context.getName()+"Framework execution started"+new Date(),true);
		
	}

	@Override
	public void onFinish(ITestContext context) {
		Reporter.log(context.getName()+"framework execution ends"+new Date(),true);
		Reporter.log("Total test passed"+passCount,true);
		Reporter.log("Total test failed"+failCount,true);
		Reporter.log("Total script skipped"+skipCount,true);
	}
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}
	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}
	

}
