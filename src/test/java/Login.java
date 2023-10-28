import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {
	@Test
	public void open_browser() {
		WebDriver driver;
		String baseUrl = "https://www.saucedemo.com/";
		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(baseUrl);
		
		String title = driver.getTitle();
		System.out.println(title);
		
		driver.close();
	}
	
	@Test
	public void get_title() {
		WebDriver driver;
		String baseUrl = "https://www.saucedemo.com/";
		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(baseUrl);
		
		String title = driver.getTitle();
		System.out.println(title);
		
		WebElement elm1 = driver.findElement(By.id("user-name"));
		elm1.click();
		elm1.sendKeys("standard_user");
		elm1.getText();
		
		WebElement elm2 = driver.findElement(By.className("submit-button"));
		elm2.isDisplayed();
		elm2.click();

		driver.close();
	}
}
