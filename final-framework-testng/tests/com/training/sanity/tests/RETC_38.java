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
import com.training.pom.RETC_038_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_38 {

	private WebDriver driver;
	private String baseUrl;
	private static Properties properties;
	private ScreenShot screenShot;
	private RETC_038_POM retc_038;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		retc_038 = new RETC_038_POM(driver);
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
		
		retc_038.clickBlog();
		Thread.sleep(3000);
		retc_038.clickContactUs();
		retc_038.getName("selenium");
		retc_038.getEmail("selenium@gmail.com");
		retc_038.getMessage("looking for apartment");
		retc_038.getSubject("apartment");
		retc_038.sendMail();
		screenShot.captureScreenShot("First");
	}
}
