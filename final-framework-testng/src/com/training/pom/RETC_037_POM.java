package com.training.pom;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RETC_037_POM {
	private WebDriver driver; 

	public RETC_037_POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'Plots')]")
	private WebElement plots; 
	
	@FindBy(id="keyword_search")
	private WebElement address;
	
	
	@FindBy(xpath="//button[@class='button fullwidth']")
	private WebElement searchbutton;
	
	@FindBy(xpath="//span[contains(text(),'Cras enim ligula')]")
	private WebElement searchresult;

	
	@FindBy(name="your-name")
	private WebElement yourname;
	
	
	@FindBy(name="your-email")
	private WebElement email;
	
	@FindBy(name="your-subject")
	private WebElement subject;
	
	@FindBy(name="your-message")
	private WebElement message;
	
	@FindBy(xpath="//input[@value='Send']")
	private WebElement submitBtn; 
	
	public void addressSearch(String address) {
		this.address.clear();
		this.address.sendKeys(address);
	}

	public void yourName(String yourName) {
		this.yourname.clear();
		this.yourname.sendKeys(yourName);
	}
	
	public void subject(String subject) {
		this.subject.clear(); 
		this.subject.sendKeys(subject); 
	}
	
	public void message(String message) {
		this.message.clear();
		this.message.sendKeys(message);
	}
	
	public void email(String email) {
		this.email.clear(); 
		this.email.sendKeys(email); 
	}
	
	public void searchButtonClick()
	{
		this.searchbutton.click(); 
	}
	public void resultClick()
	{
		this.searchresult.click(); 
	}
	public void clickPlots()
	{   
		plots.click();
	}
	
}
