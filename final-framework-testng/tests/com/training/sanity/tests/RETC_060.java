package com.training.sanity.tests;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.RETC_060_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_060 {

	private WebDriver driver;
	private String baseUrl;
	private static Properties properties;
	private ScreenShot screenShot;
	private RETC_060_POM Retc_060;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		Retc_060 = new RETC_060_POM(driver);
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
		Retc_060.tabMouseHover();
		Retc_060.getSalesprice("400000");
		Retc_060.getDownpayment("20000");
		Retc_060.getYears("20");
		Thread.sleep(2000);
		Retc_060.getInterest("7.25");
		Retc_060.calculateInterest();
		screenShot.captureScreenShot("First");
	}
}
