package Trail;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class BaseUtil {
	
	
	private String getScreenshot(WebDriver driver) throws IOException {
		TakesScreenshot shot = (TakesScreenshot)driver;
		File source = shot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source,new File("C:\\Users\\Lenovo\\eclipse-workspace\\Ganesh\\RealTimeScenarios\\src\\Attachments\\shot.png") );
		return source.getAbsolutePath();
}
}