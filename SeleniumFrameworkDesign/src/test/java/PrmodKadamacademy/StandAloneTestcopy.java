package PrmodKadamacademy;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PrmodKadamacademy.TestComponents.BaseTest;
import PrmodKadamacademy.pageprojects.Cartpage;
import PrmodKadamacademy.pageprojects.Checkoutpage;
import PrmodKadamacademy.pageprojects.Landingpage;
import PrmodKadamacademy.pageprojects.ProductCatalogue;
import PrmodKadamacademy.pageprojects.confirmationPage;
import PrmodKadamacademy.pageprojects.orderPage;

public class StandAloneTestcopy extends BaseTest {

	    
	String name = "ZARA COAT 3";
	String countryName= "india";
		@Test (dataProvider ="getData",groups = {"purchase"})
		public void finaltest(String email, String pass, String name) throws IOException, InterruptedException
		{
			
		
		ProductCatalogue pc= lp.loginapp(email, pass);
		List<WebElement>list=pc.getproductlist();
		pc.addProductToCart(name);
		Cartpage cp = pc.goTOCart(); // child class has access to the parent class methods
		Boolean match = cp.toCheckAddedProducts(name);
		Assert.assertTrue(match); // validation should be in test cases not in action page
		Checkoutpage check= cp.goToCheckout();
		check.selectCountry(countryName);
		confirmationPage text= check.submitOrder();
		String result= text.getMessage();
		Assert.assertTrue(result.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		}
		
		// so here this test is depend on above test therefore we give the annotation
		// so first above test will perform and then below test will be execute
		
		@Test(dependsOnMethods= {"finaltest"})
		public void OrderHistoryTest()
		{
			
			ProductCatalogue pc= lp.loginapp("pramodkdm@gmail.com", "Pkdm@4528");
			orderPage op= pc.goToOrderpage();
			Boolean match =op.verifyOrderDisplay(name);
			Assert.assertTrue(match);
		}
		
		@DataProvider 
		public Object[][] getData()
		{
			return new Object[][] {{"pramodkdm@gmail.com", "Pkdm@4528","ZARA COAT 3" }, {"pramodabc@gmail.com","Pkdm@4528", "ADIDAS ORIGINAL"}};
		}

}
