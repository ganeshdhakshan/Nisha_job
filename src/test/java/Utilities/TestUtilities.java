package Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Base.BaseClass;

public class TestUtilities extends BaseClass {
	
//	public static WebDriver driver = null;
	
	public WebElement findElement(String locator) {
		WebElement findElement = driver.findElement(By.xpath(locator));
		return findElement;
	}

	public void click(String locator) {
		WebElement findElement = driver.findElement(By.xpath(locator));
		findElement.click();
	}
	
	public String screenShot(WebDriver driver,String name) throws IOException {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyyhhmmss");
		String format = sdf.format(date);
        TakesScreenshot ts = (TakesScreenshot)driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File destination= new File("C:\\Users\\Lenovo\\eclipse-workspace\\Ganesh\\RealTimeScenarios\\target\\Reports\\Report\\Attachments\\"+name+format+".png");
//        File destination= new File("C:\\Users\\Lenovo\\eclipse-workspace\\Ganesh\\RealTimeScenarios\\target\\Reports\\Report"+format+"\\Attachments\\screen_"+format+".png");
        FileUtils.copyFile(source,destination);
        return destination.getAbsolutePath();
	}
	public String takeScreenShot() throws IOException {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyyhhmmss");
		String format = sdf.format(date);
        TakesScreenshot ts = (TakesScreenshot)driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File destination= new File("C:\\Users\\Lenovo\\eclipse-workspace\\Ganesh\\RealTimeScenarios\\target\\Reports\\Report\\Attachments\\"+format+".png");
//        File destination= new File("C:\\Users\\Lenovo\\eclipse-workspace\\Ganesh\\RealTimeScenarios\\target\\Reports\\Report"+format+"\\Attachments\\screen_"+format+".png");
        FileUtils.copyFile(source,destination);
        return destination.getAbsolutePath();
	}
}
