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
import com.training.pom.RETC_039_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_039 {

	private WebDriver driver;
	private String baseUrl;
	private static Properties properties;
	private ScreenShot screenShot;
	private RETC_039_POM retc_039;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		retc_039 = new RETC_039_POM(driver);
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
		
		retc_039.clickLogin();
		retc_039.loginname("admin");
		Thread.sleep(3000);
		retc_039.password("admin@123");
		retc_039.signIn();
		retc_039.Click_post();
		retc_039.select_category();
		retc_039.category_name("New Launches");
		retc_039.add_slug("launch");
		retc_039.select_parentcategory();
		retc_039.getDescription("New Launches of villas, apartments, flats");
		retc_039.submit();
		Thread.sleep(3000);
		retc_039.Click_post();
		retc_039.add_newPost();
		retc_039.postTitle("New Launches");
		retc_039.content(" New Launch in Home");
		retc_039.post_publish();
		screenShot.captureScreenShot("First");
	}
}
