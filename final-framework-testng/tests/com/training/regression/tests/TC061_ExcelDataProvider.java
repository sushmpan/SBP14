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
import com.training.pom.RETC_060_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TC061_ExcelDataProvider {
	private WebDriver driver;
	private String baseUrl;
	private RETC_060_POM retc_060_pom;
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
		retc_060_pom = new RETC_060_POM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test(dataProvider = "dataprovider_TC061", dataProviderClass = LoginDataProviders.class)
	public void RETC_060_DBTest(String salesprice, String downpayment,String LoanTerm, String interest_rate ) throws InterruptedException {
		retc_060_pom.getSalesprice(salesprice);
		retc_060_pom.getDownpayment(downpayment);
		retc_060_pom.getYears(LoanTerm);
		retc_060_pom.getInterest(interest_rate);
		retc_060_pom.calculateInterest();
		screenShot.captureScreenShot();

	}

}