package PrmodKadamacademy.pageprojects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import PramodKadamacademy.AbstractComponents.Abstractcomponents;

public class confirmationPage extends Abstractcomponents {
	WebDriver driver;
	public confirmationPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

	
	// Boolean result = driver.findElement(By.cssSelector(".hero-primary")).getText()
			// 		.equals("THANKYOU FOR THE ORDER.");
	
	@FindBy(css=".hero-primary")
	WebElement text;
	
	
	public String getMessage() throws InterruptedException
	{
		
		return text.getText();
		
	}

}
