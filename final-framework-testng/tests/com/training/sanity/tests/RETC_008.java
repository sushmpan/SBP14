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
import com.training.pom.RETC_008_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_008 {

	private WebDriver driver;
	private String baseUrl;
	private static Properties properties;
	private ScreenShot screenShot;
	private RETC_008_POM Retc_008;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		Retc_008 = new RETC_008_POM(driver);
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
		Retc_008.tabMouseHover();
		Retc_008.getSalesprice("400000");
		Retc_008.getDownpayment("20000");
		Retc_008.getYears("20");
		Thread.sleep(2000);
		Retc_008.getInterest("7.25");
		Reporter.log("All the required fields has been entered successfully");;
		Retc_008.calculateInterest();
		Reporter.log("Monthly payment is calculated ");;
		Retc_008.monthlyPaymentValidation();
		Reporter.log("Monthly payment displayed as expected ");

		screenShot.captureScreenShot("TC008");
	
} }
