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
import com.training.generics.ScreenShot;
import com.training.pom.RETC_068_069_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TC068_ExcelDataProvider {
	private WebDriver driver;
	private String baseUrl;
	private RETC_068_069_POM retc_068_069_pom;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		retc_068_069_pom = new RETC_068_069_POM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test(dataProvider = "dataprovider_TC068", dataProviderClass = LoginDataProviders.class)
	public void RETC_060_DBTest(String salesprice, String downpayment,String LoanTerm, String interest_rate, String expectedMessage ) throws InterruptedException, IOException {
		retc_068_069_pom.tabMouseHover();
		retc_068_069_pom.getSalesprice(salesprice);
		retc_068_069_pom.getDownpayment(downpayment);
		retc_068_069_pom.getYears(LoanTerm);
		retc_068_069_pom.getInterest(interest_rate);
		retc_068_069_pom.calculateInterest();
		retc_068_069_pom.interestValidation_1();
		Thread.sleep(3000);
		screenShot.captureScreenShot();

	} }

