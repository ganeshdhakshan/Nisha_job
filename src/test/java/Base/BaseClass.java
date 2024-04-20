package Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {

	public static WebDriver driver;

	public void launchDriver() {
		driver = new ChromeDriver();
	}

	public void launchUrl(String url) {
		driver.get(url);
	}

	public void maximizeWindow() {
		driver.manage().window().maximize();
	}
	
	public void implicitWait() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	public void pageLoad() {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	}
	public void closeBrowser() {
        driver.close();
	}
	public String getValueFromPropertyFile(String key) throws IOException {
		Properties p = new Properties();
		File file = new File("C:\\Users\\Lenovo\\eclipse-workspace\\Ganesh\\RealTimeScenarios\\src\\test\\resources\\property.properties");
		FileInputStream stream = new FileInputStream(file);
		p.load(stream);
		Object object = p.get(key);
		String value = (String)object;
		return value;
	}
	
}
