package com.training.pom;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RETC_007_POM {
	private WebDriver driver; 


	public RETC_007_POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'New Launch')]")
	private WebElement newlaunch; 
	
	@FindBy(xpath="//div[@id='wpmm-megamenu']//div[contains(@class,'wpmm-posts wpmm-4-posts')]//a[contains(text(),'Donec quis')]")
	private WebElement donecquis; 

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
	
	public void tabMouseHover() throws InterruptedException
	{   
		Actions act = new Actions(driver);
		act.moveToElement(newlaunch).build().perform();
		Thread.sleep(3000);
		donecquis.click();
	}
	public void clickSubmit() {
		this.submitBtn.click(); 
	}
}
