package PrmodKadamacademy;

import java.time.Duration;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String name = "QWERTY";
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client");
		
		
		driver.findElement(By.id("userEmail")).sendKeys("pramodkdm@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Pkdm@4528");
		driver.findElement(By.id("login"));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		
		
		List<WebElement> list = driver.findElements(By.cssSelector(".mb-3"));
		
		list.stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals(name)).findFirst().get()
				.findElement(By.cssSelector(".card-body button:last-of-type")).click();

		// here we wait till the text appear
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
		// here we wait for disable the loading animation
		// wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
		// below method is fast
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
		List<WebElement> cart = driver.findElements(By.cssSelector(".cartSection h3"));
		// here we use filter but it returns the value so with anymatch its only check
		Boolean match = cart.stream().anyMatch(p -> p.getText().equalsIgnoreCase(name));
		Assert.assertTrue(match);
		driver.findElement(By.xpath("//div/ul/li/button")).click();
		driver.findElement(By.cssSelector("[placeholder='Select Country']")).sendKeys("ind");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-item")));
		List<WebElement> country = driver.findElements(By.cssSelector(".ta-item"));
		country.stream().filter(c -> c.getText().equalsIgnoreCase("India")).findFirst().get().click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,600)");
		driver.findElement(By.cssSelector(".action__submit")).click();
		Boolean result = driver.findElement(By.cssSelector(".hero-primary")).getText()
				.equals("THANKYOU FOR THE ORDER.");
		Assert.assertTrue(result);
		driver.quit(); 
		
   
	}

}
