package PrmodKadamacademy.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import PrmodKadamacademy.pageprojects.Landingpage;

public class BaseTest {
	
	public WebDriver driver;
	public Landingpage lp;
	
	public WebDriver intializeDriver() throws IOException
	{
		Properties prop = new Properties();
		// need to convert the file into input stream object to laod it  in properties class
		// to minimize and not hardcodeing the path of the file we use get property 
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\PramodKadamacademy\\resources\\GlobalData.properties");
		prop.load(fis);
		String browsername= prop.getProperty("browser");;
		
		if (browsername.equalsIgnoreCase("chrome"))
		{
		 driver = new ChromeDriver();
		
		}
		else if (browsername.equalsIgnoreCase("firefox"))
		{
			// firefox code
			
		}
		else if (browsername.equalsIgnoreCase("edge"))
		{
			 driver = new EdgeDriver();
			
			}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}
	
	public List<HashMap<String, String>> getjsonDataToMap(String filepath) throws IOException 
	{
		// Read json file to string
		String jsonContent= FileUtils.readFileToString(new File(filepath),StandardCharsets.UTF_8);
		// convert this string to hashmap (jackson databind)
		
		ObjectMapper mapper=new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>() {});
		return data;
		// {map, map1}
	}
	
	// to launch the website which is applicable for all test cases
	@BeforeMethod (alwaysRun=true)
	public Landingpage launchApp() throws IOException
	{
		WebDriver driver = intializeDriver();
		 lp=new Landingpage(driver);
		lp.Goto();
		return lp;
	}
	
	@AfterMethod (alwaysRun=true)
	public void teardowm()
	{
		driver.quit();
	}
	
	
	
	
	

}
