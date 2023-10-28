package saucedemo;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class Login {
	@Test
	public void success_login_case() {
		WebDriver driver;
		String baseUrl = "https://www.saucedemo.com/";
		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(baseUrl);
		
		String loginPageAssert = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]")).getText();
		Assert.assertEquals(loginPageAssert, "Swag Labs");
		
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		String products = driver.findElement(By.xpath("//span[contains(text(),'Products')]")).getText();
		
		Assert.assertEquals(products, "Products");
		
		driver.close();
	}
	
	@Test
	public void failed_login_case() {
		WebDriver driver;
		String baseUrl = "https://www.saucedemo.com/";
		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get(baseUrl);
		
		String loginPageAssert = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]")).getText();
		Assert.assertEquals(loginPageAssert, "Swag Labs");
		
		driver.findElement(By.id("user-name")).sendKeys("priority_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		String errorLabel = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
		
		Assert.assertEquals(errorLabel, "Epic sadface: Username and password do not match any user in this service");
		
		driver.close();
	}
}
