package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homePOM {
	private WebDriver driver; 
	
	public homePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className="fa-user")
	private WebElement user_icon; 
	
	
	public void clickUserIcon() {
		this.user_icon.click();
	}
	
	}
