package Test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.BaseClass;
import Page.Page1;

public class MainTest {
	
	private Page1 page1;
	private BaseClass baseClass;
	
	public MainTest() {
		this.page1 = new Page1();
		this.baseClass = new BaseClass();
		
	}
	@AfterMethod
	private void closeDriver() {
baseClass.closeBrowser();
	}
	
	@Test(priority =1)
	private void launching1() throws IOException {
		page1.urlLaunching();
		Assert.assertTrue(true);

	}
	
	@Test(priority =2)
	private void launching2() throws IOException {
		page1.urlLaunching();
		Assert.assertTrue(false);
	}
	
	@Test(priority =3,dependsOnMethods = {"launching2"})
	private void launching3() throws IOException {
		page1.urlLaunching();
		Assert.assertTrue(true);

	}

}
