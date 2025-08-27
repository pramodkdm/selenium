package PrmodKadamacademy.pageprojects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import PramodKadamacademy.AbstractComponents.Abstractcomponents;

public class orderPage extends Abstractcomponents {
	
	WebDriver driver;
	// this constructor will execute before everything
	public orderPage(WebDriver driver)
	{
		super(driver); // every child should send the driver to the parent class
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	// List<WebElement> cart = driver.findElements(By.cssSelector(".cartSection h3"));
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> orderProoducts;
	
	// Boolean match = cart.stream().anyMatch(p -> p.getText().equalsIgnoreCase(name));
	// Assert.assertTrue(match);
	
	public Boolean verifyOrderDisplay(String name)
	{
		Boolean match = orderProoducts.stream().anyMatch(p -> p.getText().equalsIgnoreCase(name));
		return match;	
	}

	
	
	

	

	
	
	

}
