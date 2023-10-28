package stepDef.login;

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

public class login {
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

	@When("Input username")
	public void inputUsername() {		
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
	}
	
	@And ("Input password")
	public void inputPassword() {
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
	}
	
	@And ("click login button")
	public void clickLoginButton() {
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}
	
	@Then ("User in dasboard page")
	public void userInDashboardPage() {
		String products = driver.findElement(By.xpath("//span[contains(text(),'Products')]")).getText();
		
		Assert.assertEquals(products, "Products");
	}
	
	@And ("Input invalid password")
	public void inputInvalidPassword() {
		driver.findElement(By.id("password")).sendKeys("sauce_secret");
	}
	
	@Then ("User get error message")
	public void userGetErrorMessage() {
		String errorLabel = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")).getText();
		
		Assert.assertEquals(errorLabel, "Epic sadface: Username and password do not match any user in this service");

	}
	
	@When("I input (.*) as username$")
	public void user_input_tdd_selenium_as_username(String username) {		
		driver.findElement(By.id("user-name")).sendKeys(username);
	}
	
	@And("I input (.*) as password$")
	public void user_input_tdd_selenium_as_password(String password) {		
		driver.findElement(By.id("password")).sendKeys(password);
	}
	
	@Then ("user verify (.*) login result$")
	public void user_verify_login_status(String status) {
		if (status.equals("success")) {
			String products = driver.findElement(By.xpath("//span[contains(text(),'Products')]")).getText();
			
			Assert.assertEquals(products, "Products");
		} else {
			String errorLabel = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
			
			Assert.assertEquals(errorLabel, "Epic sadface: Username and password do not match any user in this service");
		}
		driver.close();
	}
}
