package PramodKadamacademy.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PrmodKadamacademy.pageprojects.Cartpage;
import PrmodKadamacademy.pageprojects.orderPage;

public class Abstractcomponents  {
	// all repeated code we write here so this is the parent class which is use by all other classes
	WebDriver driver;
	public Abstractcomponents(WebDriver driver) {
		this.driver=driver;
	}

	public void waitforelementtoappear(By findby)
	{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfElementLocated(findby));
	}
	
	
	public void waitForElementToDisappear(WebElement ele)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(ele));
		
	}
	
	// driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
	
		@FindBy(xpath="//button[@routerlink='/dashboard/cart']")
		WebElement opencart;
		
		@FindBy(xpath="//button[contains(@routerlink,'myorders')]")
		WebElement orderheader;
		
		
		public Cartpage goTOCart()
		{
			opencart.click();
			Cartpage cp = new Cartpage(driver);
			return cp;
		}
		
		public  orderPage goToOrderpage()
		{
			orderheader.click();
			orderPage op = new orderPage(driver);
			return op;
			
		}
		
		public void waitforWebElementToAppear(WebElement elem)
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOf(elem));
			
		}
		
}
