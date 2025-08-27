package PrmodKadamacademy.pageprojects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import PramodKadamacademy.AbstractComponents.Abstractcomponents;

public class Landingpage extends Abstractcomponents { // here we access the parent class for repeated code
	
	// here we aremoving all the locators of landing page in this class 
	WebDriver driver;
	// this constructor will execute before everything
	public Landingpage(WebDriver driver)
	{
		super(driver); // to send this driver to parent class
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	//WebElement useremail= driver.findElement(By.id("userEmail"));
	// pagefactory to reduce the syntax
	@FindBy(id="userEmail")
	WebElement email;
	
	@FindBy(id="userPassword")
	WebElement password;
	
	@FindBy(id="login")
	WebElement submit;
	
	 
	@FindBy(css="[Class*='flyInOut']")
	WebElement errormessage;
	
	//Actionmethods - instead of 3 test you can add in one action method
	
	public ProductCatalogue loginapp(String mail, String pass)
	{
		email.sendKeys(mail);
		password.sendKeys(pass);
		submit.click();
		ProductCatalogue pc= new ProductCatalogue(driver);
		return pc;
	}
	
	public String getErrorMessage()
	{
		waitforWebElementToAppear(errormessage);
		String text= errormessage.getText();
		return text;
	}
	
	public void Goto()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}

	

}
