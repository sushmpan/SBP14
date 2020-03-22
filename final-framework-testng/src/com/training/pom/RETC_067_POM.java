package com.training.pom;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class RETC_067_POM {
	private WebDriver driver; 
	XSSFCell cell1, cell2, cell3;

	public RETC_067_POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	//Element identification used for TC060 and TC067
	@FindBy(xpath="//a[contains(text(),'New Launch')]")
	private WebElement newlaunch; 
	
	@FindBy(xpath="//div[@id='wpmm-megamenu']//div[contains(@class,'wpmm-posts wpmm-4-posts')]//a[contains(text(),'Donec quis')]")
	private WebElement donecquis; 

	
	@FindBy(name="amount")
	private WebElement salesprice;
	
	
	@FindBy(id="downpayment")
	private WebElement downpayment;
	
	@FindBy(xpath="//input[@id='years']")
	private WebElement LoanTerm;
	
	@FindBy(xpath="//input[@id='interest']")
	private WebElement interest_rate;
	
	@FindBy(xpath="//button[@class='button calc-button']")
	private WebElement submitBtn; 
	
	@FindBy(xpath="//div[@class='notification success']")
	private WebElement actualInterestmessage; 
	
	
	//Methods used in TC060 and TC067
	public void getSalesprice(String amount) {
		this.salesprice.clear();
		this.salesprice.sendKeys(amount);
	}
	
	public void getDownpayment(String downpayment) {
		this.downpayment.clear(); 
		this.downpayment.sendKeys(downpayment); 
	}
	
	public void getYears(String year) {
		this.LoanTerm.clear();
		this.LoanTerm.sendKeys(year);
	}
	
	public void getInterest(String Interest) {
		//this.interest_rate.clear(); 
		this.interest_rate.sendKeys(Interest); 
	}
	
	public void calculateInterest()
	{
		this.submitBtn.click(); 
	}
	public void tabMouseHover() throws InterruptedException
	{   
		Actions act = new Actions(driver);
		act.moveToElement(newlaunch).build().perform();
		Thread.sleep(3000);
		donecquis.click();
	}
	public void interestValidation_1() throws InterruptedException, IOException
	{   
		try {
	FileInputStream fis = new FileInputStream("C:\\Users\\SushmaPandey\\Desktop\\selenium\\TC_60_testdata.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Sheet1");
		cell1 = sheet.getRow(0).getCell(4);
		String expectedText1 = cell1.getStringCellValue();
		String act1= actualInterestmessage.getText();
		Thread.sleep(3000);
		Assert.assertEquals(act1, expectedText1);
		System.out.println("Correct Monthly payment displayed");
	} catch (IOException e)
	
	{
		System.out.println("Error" + e);
	}}
	
	// Method for Test case 67
		public void checkForNullValidation()
	
	{
		if(salesprice.getAttribute("value").matches("null"))
		{
			System.out.println("please enter sales price monthly payment calculated");
		}
		else if(interest_rate.getAttribute("value").matches("null"))
		{
			System.out.println("please enter interets rate  to get the monthly payment calculated");
		}
		else if(LoanTerm.getAttribute("value").matches("null"))
		{
			System.out.println("please enter loan term  value to get the monthly payment calculated");
		}
		else if(downpayment.getAttribute("value").matches("null"))
		{
			System.out.println("please enter down payment value to get the monthly payment calculated");
		}


	}
}
