package Listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import ExtentReportScenario.ExtentReport;
import Utilities.TestUtilities;

public class AllListeners extends TestUtilities implements ITestListener{
	
	ExtentReports extent = ExtentReport.generateExtentReport();
	ExtentTest createTest;

	@Override
	public void onTestStart(ITestResult result) {
		String name = result.getName();
		createTest = extent.createTest(name);
		createTest.log(Status.INFO, name+" Execution is started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String name = result.getName();
		createTest.log(Status.PASS, name+" Execution is passed");
	try {
//		createTest.log(Status.PASS, MediaEntityBuilder.createScreenCaptureFromBase64String(takeScreenShot(), name).build());
		createTest.log(Status.PASS, MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(), name).build());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String name = result.getName();
		 createTest.log(Status.FAIL, name+"  is failed");
		 createTest.log(Status.INFO, result.getThrowable());
		 WebDriver driver = null;
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
			createTest.log(Status.FAIL, MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(), name).build());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {
			createTest.addScreenCaptureFromPath(screenShot(driver,name), name);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String name = result.getName();
		createTest.log(Status.SKIP, name+" Execution is skipped");
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
		File file = new File ("C:\\Users\\Lenovo\\eclipse-workspace\\Ganesh\\RealTimeScenarios\\target\\Reports\\ExtentReport\\eReport.html");
		try {
			Desktop.getDesktop().browse(file.toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
