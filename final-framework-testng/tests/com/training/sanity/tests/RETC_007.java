package com.training.sanity.tests;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.RETC_007_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_007 {

	private WebDriver driver;
	private String baseUrl;
	private static Properties properties;
	private ScreenShot screenShot;
	private RETC_007_POM retc;


	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		retc = new RETC_007_POM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void validLoginTest() throws InterruptedException {
		retc.tabMouseHover();
		Thread.sleep(3000);
		retc.getName("Sushma");
		retc.getMessage("2BHK in bangalore");;
		retc.getEmail("Query");
		retc.getSubject("Apartment Requirement for rent");
		Reporter.log("All the required details has been entered successfully");
		retc.clickSubmit();
		Reporter.log("All the required details has been entered and submitted");
		screenShot.captureScreenShot("TC007");
	}
}
