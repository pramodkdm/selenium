package PrmodKadamacademy.pageprojects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import PramodKadamacademy.AbstractComponents.Abstractcomponents;

public class Cartpage extends Abstractcomponents {
	
	WebDriver driver;
	// this constructor will execute before everything
	public Cartpage(WebDriver driver)
	{
		super(driver); // every child should send the driver to the parent class
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	// List<WebElement> cart = driver.findElements(By.cssSelector(".cartSection h3"));
	@FindBy(css=".cartSection h3")
	List<WebElement> cartproducts;
	
	// Boolean match = cart.stream().anyMatch(p -> p.getText().equalsIgnoreCase(name));
	// Assert.assertTrue(match);
	
	public Boolean toCheckAddedProducts(String name)
	{
		Boolean match = cartproducts.stream().anyMatch(p -> p.getText().equalsIgnoreCase(name));
		return match;	
	}
	
	// driver.findElement(By.xpath()).click();
	@FindBy(xpath="//div/ul/li/button")
	WebElement checkout;
	
	public Checkoutpage goToCheckout()
	{
		checkout.click();
		Checkoutpage check= new Checkoutpage(driver);
				return check;
	}
	
	
	

}
