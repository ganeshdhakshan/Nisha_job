package ExtentReportScenario;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
	
	public static ExtentReports generateExtentReport() {
ExtentReports reports = new ExtentReports();
File file = new File(System.getProperty("user.dir")+"\\target\\Reports\\ExtentReport\\eReport.html");
ExtentSparkReporter spark = new ExtentSparkReporter(file);
reports.attachReporter(spark);
return reports;
	}

}
