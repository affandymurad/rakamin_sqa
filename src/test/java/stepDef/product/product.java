package stepDef.product;

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

/*

 */

public class product {
	WebDriver driver;
	String baseUrl = "https://www.saucedemo.com/";
	String thumbnailUrl = "";
	
	
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
	
	@When("Input visual username")
	public void inputVisualUsername() {		
		driver.findElement(By.id("user-name")).sendKeys("visual_user");
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
	
	
	@And ("User check first product thumbnail")
	public void userCheckFirstThumbnail() {
		thumbnailUrl = driver.findElement(By.xpath("//*[@id=\"item_4_img_link\"]/img")).getAttribute("src");
	}
	
	@And ("User check second product thumbnail")
	public void userCheckSecondThumbnail() {
		thumbnailUrl = driver.findElement(By.xpath("//*[@id=\"item_0_img_link\"]/img")).getAttribute("src");
	}
	
	@Then ("User click first product")
	public void userClickFirstProductPage() {
		driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div")).click();
	}
		
	@Then ("User click second product")
	public void userClickSecondProductPage() {
		driver.findElement(By.xpath("//*[@id=\"item_0_title_link\"]/div")).click();
	}
	
	@And ("User check product thumbnail is different")
	public void userCheckDifferentProduct() {
		String productThumbnail = driver.findElement(By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div[1]/img")).getAttribute("src");
		
		Assert.assertNotSame(thumbnailUrl, productThumbnail);
		
	}
	
	@And ("User check product thumbnail is same")
	public void userCheckSameProduct() {
		String productThumbnail = driver.findElement(By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div[1]/img")).getAttribute("src");
		
		Assert.assertEquals(thumbnailUrl, productThumbnail);
		
	}
}
