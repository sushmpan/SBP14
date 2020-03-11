package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RETC_008_POM {
	private WebDriver driver; 
	

	public RETC_008_POM(WebDriver driver) {
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
	
}
