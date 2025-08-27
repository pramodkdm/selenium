package PrmodKadamacademy.pageprojects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import PramodKadamacademy.AbstractComponents.Abstractcomponents;

/**
 * 
 */
public class Checkoutpage extends Abstractcomponents{
	
	WebDriver driver;
	// this constructor will execute before everything
	public Checkoutpage(WebDriver driver)
	{
		super(driver); // every child should send the driver to the parent class
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	/*
	 * driver.findElement(By.cssSelector("[placeholder='Select Country']")).sendKeys
	 * ("ind");
	 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
	 * ".ta-item"))); List<WebElement> country =
	 * driver.findElements(By.cssSelector(".ta-item")); country.stream().filter(c ->
	 * c.getText().equalsIgnoreCase("India")).findFirst().get().click();
	 * Thread.sleep(2000); JavascriptExecutor js = (JavascriptExecutor) driver;
	 * js.executeScript("window.scrollBy(0,600)");
	 * driver.findElement(By.cssSelector(".action__submit")).click();
	 */
	
	
	
	@FindBy(css="[placeholder='Select Country']")
	WebElement country;
	
	By ind= By.cssSelector(".ta-item");
	
	@FindBy(css=".ta-item")
	List<WebElement> selectcountry;
	
	@FindBy(css=".action__submit")
	WebElement order;
	
	
	
	public void selectCountry(String countryName)
	{
		country.sendKeys(countryName);
		waitforelementtoappear(ind);
		selectcountry.stream().filter(c ->c.getText().equalsIgnoreCase("India")).findFirst().get().click();
	}
	
	public confirmationPage submitOrder() throws InterruptedException
	{
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,100)");
		order.click();
		return new confirmationPage(driver);
		
		
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
