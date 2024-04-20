package Trail;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ExtentRep {
	
	/*
	 * public static ExtentReports Report() { ExtentReports report = new
	 * ExtentReports(); ExtentSparkReporter reporter = new ExtentSparkReporter(
	 * "C:\\Users\\Lenovo\\eclipse-workspace\\Ganesh\\RealTimeScenarios\\src\\Reports\\report.html"
	 * ); report.attachReporter(reporter); return report; }
	 
	 */
	public static ExtentReports generateExtentReport() {
		ExtentReports reports = new ExtentReports();
		File file = new File(System.getProperty("user.dir")+"\\target\\Reports\\ExtentReport\\eReport.html");
		ExtentSparkReporter spark = new ExtentSparkReporter(file);
		reports.attachReporter(spark);
		return reports;
			}
	
}
