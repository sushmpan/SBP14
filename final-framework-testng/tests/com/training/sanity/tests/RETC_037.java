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
import com.training.pom.RETC_037_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_037 {

	private WebDriver driver;
	private String baseUrl;
	private static Properties properties;
	private ScreenShot screenShot;
	private RETC_037_POM retc_037;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		retc_037 = new RETC_037_POM(driver);
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
	public void validLoginTest() {
		
		retc_037.clickPlots();
		retc_037.addressSearch("Electronic City, Bengaluru, Karnataka, India");
		retc_037.searchButtonClick();
		Reporter.log("Search Creteria has been enetered");
		retc_037.resultClick();
		retc_037.yourName("selenium");
		retc_037.email("selenium@gmail.com");
		retc_037.message("looking for apartment");
		retc_037.subject("apartment");
		Reporter.log("Enquiry related to apartment has been sent");
		screenShot.captureScreenShot("TC037");
	}
}
