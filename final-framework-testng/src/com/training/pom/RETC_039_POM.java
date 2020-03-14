package com.training.pom;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RETC_039_POM {
	private WebDriver driver; 

	public RETC_039_POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@class='sign-in']")
	private WebElement login; 
	
	@FindBy(id="user_login")
	private WebElement loginId;
	
	
	@FindBy(id="user_pass")
	private WebElement password;
	
	@FindBy(name="subject")
	private WebElement Subject;
	
	
	@FindBy(xpath="//div[contains(text(),'Posts')]")
	private WebElement post;
	
	
	@FindBy(xpath="//a[contains(text(),'Categories')]")
	private WebElement category;
	
	
	@FindBy(name="tag-name")
	private WebElement new_category; 
	
	@FindBy(name="slug")
	private WebElement add_slug;
	
	
	@FindBy(name="description")
	private WebElement Description;
	
	@FindBy(name="submit")
	private WebElement Submitbutton;
	
	@FindBy(linkText="All Posts")
	private WebElement allPost;
	
	@FindBy(name="login")
	private WebElement signIn;
	
	@FindBy(xpath="//select[@id='parent']")
	private WebElement parentCategory;
	
	@FindBy(name="post_title")
	private WebElement postTitle;
	
	@FindBy(name="content")
	private WebElement contentText;
	
	public void content(String content) {
		this.contentText.clear();
		this.contentText.sendKeys(content);
	}
	
	@FindBy(xpath="//a[@class='page-title-action']")
	private WebElement AddNewPost;
	
	@FindBy(name="publish")
	private WebElement postPublish;		
	
	public void postTitle(String title) {
		this.postTitle.clear();
		this.postTitle.sendKeys(title);
	}
	
	public void getDescription(String descp) {
		this.Description.clear();
		this.Description.sendKeys(descp);
	}
	
	public void add_slug(String slug) {
		this.add_slug.clear(); 
		this.add_slug.sendKeys(slug); 
	}
	
	public void add_name(String name) {
		this.new_category.clear(); 
		this.new_category.sendKeys(name); 
	}
	public void password(String pwd) {
		this.password.clear();
		this.password.sendKeys(pwd);
	}
	
	public void loginname(String login) {
		this.loginId.clear(); 
		this.loginId.sendKeys(login); 
	}
	
	public void select_category()
	{
		this.category.click(); 
	}
	public void category_name(String catname)
	{
		this.new_category.sendKeys(catname); 
	}
	
	
	public void clickLogin()
	{   
		login.click();
	}
	public void submit()
	{   
		Submitbutton.click();
	}
	public void signIn()
	{   
		signIn.click();
	}
	public void Click_post()
	{   
		post.click();
	}
	
	public void select_parentcategory()
	{
		Select sct= new Select(parentCategory);
		sct.selectByIndex(1);
	}
	
	public void Click_Allpost()
	{   
		allPost.click();
	}
	
	public void add_newPost()
	{   
		AddNewPost.click();
	}
	public void post_publish()
	{   
		postPublish.click();
	}
	
	
}
