package PrmodKadamacademy;

import org.testng.Assert;
import org.testng.annotations.Test;

import PrmodKadamacademy.TestComponents.BaseTest;

public class ErrorValidation extends BaseTest {

	    
		
		@Test
		public void loginValidation()
		{
			String name = "QWERTY";
			String countryName= "india";
		
			lp.loginapp("pramodkdm@gmail.com", "Pkdm@452j");
		   String text= lp.getErrorMessage();
		    Assert.assertEquals(text, "Incorrect email or password.");
	
   
	}

}
