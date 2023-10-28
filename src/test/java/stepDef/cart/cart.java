package stepDef.cart;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class cart {
	WebDriver driver;
	String baseUrl = "https://www.saucedemo.com/";	
	
	@Given("Halaman login Sauce Demo")
	public void halaman_login_sauce_demo() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get(baseUrl);
		
		String loginPageAssert = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]")).getText();
		Assert.assertEquals(loginPageAssert, "Swag Labs");
	}
	
	@When("Input standard username")
	public void inputStandardUsername() {		
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
	}

	@And ("Input password")
	public void inputVisualPassword() {
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
	}
	
	@And ("click login button")
	public void clickVisualLoginButton() {
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}
	
	@Then ("User in dasboard page")
	public void userInDashboardPage() {
		String products = driver.findElement(By.xpath("//span[contains(text(),'Products')]")).getText();
		
		Assert.assertEquals(products, "Products");
	}
	
	@And ("User click cart button of first product")
	public void userClickFirstCartButton() {
		driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();
	}
	
	@And ("User click remove button of first product")
	public void userClickFirstRemoveCartButton() {
		driver.findElement(By.xpath("//*[@id=\"remove-sauce-labs-backpack\"]")).click();
	}
	
	@And ("User check cart number is increasing")
	public void userCheckCartIncreasing() {
		String count = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).getText();
		
		Assert.assertEquals(count, "1");
	}
	
	@And ("User check cart number is decreasing")
	public void userCheckCartDecreasing() {
		String count = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).getText();
		
		Assert.assertEquals(count, "");
	}
	
}
