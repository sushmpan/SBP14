package com.training.regression.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.training.bean.LoginBean;
import com.training.dao.ELearningDAO;
import com.training.dataproviders.LoginDataProviders;
import com.training.generics.GenericMethods;
import com.training.generics.ScreenShot;
import com.training.pom.RETC_068_069_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_069_DBTest {
	private WebDriver driver;
	private String baseUrl;
	private RETC_068_069_POM retc_068_69_pom;
	private static Properties properties;
	private ScreenShot screenShot;
	private GenericMethods genericMethods; 
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		retc_068_69_pom = new RETC_068_069_POM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		genericMethods = new GenericMethods(driver); 
		// open the browser
		driver.get(baseUrl);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}


	@Test(dataProvider = "dataprovider_TC069", dataProviderClass = LoginDataProviders.class)
	public void RETC_060_DBTest(String salesprice, String downpayment,String LoanTerm, String interest_rate) throws InterruptedException, IOException {
		retc_068_69_pom.tabMouseHover();
		retc_068_69_pom.blankFieldValidation();
		retc_068_69_pom.getSalesprice(salesprice);
		retc_068_69_pom.getDownpayment(downpayment);
		retc_068_69_pom.getYears(LoanTerm);
		retc_068_69_pom.getInterest(interest_rate);
		retc_068_69_pom.calculateInterest();
		Thread.sleep(3000);
				
	
		//screenShot.captureScreenShot();


	}

} 