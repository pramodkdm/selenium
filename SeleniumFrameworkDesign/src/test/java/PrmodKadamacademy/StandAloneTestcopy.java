package PrmodKadamacademy;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
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
		@Test (dataProvider = "getData",groups = {"purchase"})
		public void finaltest(HashMap<String,String> input) throws IOException, InterruptedException
		{
			
		
		ProductCatalogue pc= lp.loginapp(input.get("email"), input.get("password"));
		List<WebElement>list=pc.getproductlist();
		pc.addProductToCart(input.get("product name"));
		Cartpage cp = pc.goTOCart(); // child class has access to the parent class methods
		Boolean match = cp.toCheckAddedProducts(input.get("product name"));
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
		
	
		
		// @DataProvider 
		//public Object[][] getData()
		// {
		// 	return new Object[][] {{"pramodkdm@gmail.com", "Pkdm@4528","ZARA COAT 3" }, {"pramodabc@gmail.com","Pkdm@4528", "ADIDAS ORIGINAL"}};
		// }
		
		// hashmap you can use this  for larger data
		// it is easy to understand the data and less code required.
		
		// @DataProvider
		// public Object[][] getData()
		// {
		//	HashMap<String,String> data = new HashMap<String,String>();
		//	data.put("email", "pramodkdm@gmail.com");
		//	data.put("password", "Pkdm@4528");
		//	data.put("product name", "ZARA COAT 3");
			
		//	HashMap<String,String> data1 = new HashMap<String,String>();
		//data1.put("email", "pramodabc@gmail.com");
		//	data1.put("password", "Pkdm@4528");
		//	data1.put("product name", "ADIDAS ORIGINAL");
			
		//	return new Object[][] {{data}, {data1}};
			
			
		// to get the data from json file
		@DataProvider
		public Object[][] getData() throws IOException
		{
			List<HashMap<String, String>> data = getjsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\PramodKadamacademy\\data\\data.json");
			return new Object[][] {{data.get(0)}, {data.get(1)}};
}
}
