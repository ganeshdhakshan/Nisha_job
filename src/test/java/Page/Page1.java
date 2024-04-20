package Page;

import java.io.IOException;

import org.openqa.selenium.WebElement;

import Base.BaseClass;
import Utilities.TestUtilities;
import Xpath.Page1Xpath;

public class Page1{

	private BaseClass baseClass;
	private Page1Xpath page1xpath;
	private TestUtilities testutilities;
	
	public Page1() {
		this.baseClass = new BaseClass();
		this.testutilities = new TestUtilities();
	}
	
	public void urlLaunching() throws IOException {
	
		baseClass.launchDriver();
		baseClass.launchUrl(baseClass.getValueFromPropertyFile("url"));
		baseClass.pageLoad();
		baseClass.maximizeWindow();
		baseClass.implicitWait();
		testutilities.click(page1xpath.myAccount);
//		testutilities.screenShot();
	}
	
}
