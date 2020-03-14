package com.training.pom;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RETC_009_POM {
	private WebDriver driver; 


	public RETC_009_POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'Plots')]")
	private WebElement plots; 
	
	@FindBy(xpath="//div[@id='wpmm-megamenu']//div[contains(@class,'wpmm-posts wpmm-4-posts')]//a[contains(text(),'Donec quis')]")
	private WebElement donecquis; 

	@FindBy(name="keyword_search")
	private WebElement address;
	
	@FindBy(xpath="//div[@id='_property_type_chosen']//a[@class='chosen-single chosen-default']")
	private WebElement propertyType;
	
	@FindBy(xpath="//span[contains(text(),'Any Regions')]")
	private WebElement region;
	
	@FindBy(xpath="//button[@class='button fullwidth']")
	private WebElement searchButton; 
	
	
	public void addressSearch(String address) {
		this.address.clear();
		this.address.sendKeys(address);

	}
	public void region(String region) {
		this.region.clear();
		this.region.sendKeys(region);
	}
	
	public void propertyType(String propertyName) {
		this.propertyType.clear();
		this.propertyType.sendKeys(propertyName);

	}
	
	public void clickPlots()
	{   
		plots.click();
	}
	public void clickSearch() {
		this.searchButton.click(); 
	}
}
