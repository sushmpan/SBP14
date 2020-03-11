package com.training.pom;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RETC_038_POM {
	private WebDriver driver; 

	public RETC_038_POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'Blog')]")
	private WebElement blog; 
	
	@FindBy(xpath="//a[@class='button fullwidth margin-top-20']")
	private WebElement dropUsMail;
	
	
	@FindBy(name="name")
	private WebElement name;
	
	@FindBy(name="subject")
	private WebElement sub;

	
	@FindBy(name="email")
	private WebElement email;
	
	
	@FindBy(xpath="//textarea[@placeholder='Message']")
	private WebElement message;
	
	
	@FindBy(xpath="//input[@class='wpcf7-form-control wpcf7-submit']")
	private WebElement send; 
	
	
	public void Name(String name) {
		this.name.clear();
		this.name.sendKeys(name);
	}
	
	public void subject(String subject) {
		this.sub.clear(); 
		this.sub.sendKeys(subject); 
	}
	
	public void message(String message) {
		this.message.clear();
		this.message.sendKeys(message);
	}
	
	public void email(String email) {
		this.email.clear(); 
		this.email.sendKeys(email); 
	}
	
	public void sendmail()
	{
		this.send.click(); 
	}
	public void contactUs()
	{
		this.dropUsMail.click(); 
	}
	public void clickBlog()
	{   
		blog.click();
	}
	
}
