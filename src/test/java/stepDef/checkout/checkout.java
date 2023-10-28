package stepDef.checkout;

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


public class checkout {
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
	
	@And ("User click cart icon")
	public void userClickCartButton() {
		driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();
	}
	
	@Then ("User in cart page")
	public void userInCartPage() {
		String yourCart = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
		
		Assert.assertEquals(yourCart, "Your Cart");
	}
	
	@And ("User click checkout button")
	public void userClickCheckoutButton() {
		driver.findElement(By.xpath("//*[@id=\"checkout\"]")).click();
	}
	
	@Then ("User in checkout page")
	public void userInCheckoutPage() {
		String info = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
		
		Assert.assertEquals(info, "Checkout: Your Information");
	}
	
	@When ("Input firstname")
	public void inputFirstUsername() {		
		driver.findElement(By.id("first-name")).sendKeys("Affandy");
	}
	
	@And ("Input lastname")
	public void inputLastname() {		
		driver.findElement(By.id("last-name")).sendKeys("Murad");
	}
	
	@And ("Input Postal Code")
	public void inputZipCode() {		
		driver.findElement(By.id("postal-code")).sendKeys("17411");
	}
	
	@And ("User click continue button")
	public void userClickContinueButton() {
		driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
	}
	
	@Then ("User in overview page")
	public void userInOverviewPage() {
		String titleLabel = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
		
		Assert.assertEquals(titleLabel, "Checkout: Overview");

	}
	
	@Then ("User get error prompt")
	public void userGetErrorMessage() {
		String errorLabel = driver.findElement(By.xpath("//*[@id=\"checkout_info_container\"]/div/form/div[1]/div[4]/h3")).getText();
		
		Assert.assertEquals(errorLabel, "Error: First Name is required");

	}
}
