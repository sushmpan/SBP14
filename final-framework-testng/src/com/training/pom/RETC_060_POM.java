package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class RETC_060_POM {
	private WebDriver driver; 
	private String expectedInterestAmount1 = "Monthly Payment: 242.07 Rs.";
	private String expectedInterestAmount2 = "Monthly Payment: 3313.21 Rs.";
	private String expectedInterestAmount3 = "Monthly Payment: 84.85 Rs.";


	public RETC_060_POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
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
	
	@FindBy(xpath="//strong[@class='calc-output']")
	private WebElement actualInterestamount; 
	
	
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
	public void interestValidation_1() throws InterruptedException
	{
		String act1= actualInterestmessage.getText();
		String act2= actualInterestamount.getText();
		String act3= act1.concat(act2);
		Thread.sleep(3000);
		Assert.assertEquals(act3, expectedInterestAmount1);
		System.out.println("Correct Interest Amount displayed");
	}
	public void interestValidation_2() throws InterruptedException
	{
		String act1= actualInterestmessage.getText();
		String act2= actualInterestamount.getText();
		String act3= act1.concat(act2);
		Thread.sleep(3000);
		Assert.assertEquals(act3, expectedInterestAmount2);
		System.out.println("Correct Interest Amount displayed");
	}
	public void interestValidation_3() throws InterruptedException
	{
		String act1= actualInterestmessage.getText();
		String act2= actualInterestamount.getText();
		String act3= act1.concat(act2);
		Thread.sleep(3000);
		Assert.assertEquals(act3, expectedInterestAmount3);
		System.out.println("Correct Interest Amount displayed");
	}
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
