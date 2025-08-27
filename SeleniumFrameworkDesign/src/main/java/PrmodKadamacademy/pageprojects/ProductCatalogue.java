package PrmodKadamacademy.pageprojects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import PramodKadamacademy.AbstractComponents.Abstractcomponents;

public class ProductCatalogue extends Abstractcomponents{
	
	// here we are moving all the locators of product  page in this class 
	WebDriver driver;
	// this constructor will execute before everything
	public ProductCatalogue(WebDriver driver)
	{
		super(driver); // every child should send the driver to the parent class
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	//List<WebElement> list = driver.findElements(By.cssSelector(".mb-3"));
	
	@FindBy(css=".mb-3")
	List<WebElement> list;
	
	By locator = By.cssSelector(".mb-3");
	By addtocart =By.cssSelector(".card-body button:last-of-type");
	By locator2 = By.id("toast-container");
	
	public List<WebElement> getproductlist()
	{
		waitforelementtoappear(locator);
		return list;
	}
	//WebElement prod = list.stream()
	//		.filter(product -> product.findElement(By.cssSelector("b")).getText().equals(name)).findFirst()
	//		.orElse(null);
	
	public WebElement getproductbyname(String name)
	{
		WebElement prod = getproductlist().stream()
		.filter(product -> product.findElement(By.cssSelector("b")).getText().equals(name)).findFirst()
				.orElse(null);
		return prod;
	}
	//prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
	//wait.until(ExpectedConditions.visibilityOfElementLocated()); // here it is loctor by
	//wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating")))); // it is webelement
	
	
	@FindBy(css=".ng-animating")
	WebElement animation;
	
	
	
	public void addProductToCart(String name) throws InterruptedException
	{
		WebElement prod = getproductbyname(name);
		prod.findElement(addtocart).click();
		Thread.sleep(2000);
		//waitforelementtoappear(locator2);
		//waitForElementToDisappear(animation);
		
	}
	
	
	

}
