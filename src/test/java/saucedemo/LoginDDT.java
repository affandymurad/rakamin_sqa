package saucedemo;

import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class LoginDDT {
	@Test
	public void login_ddt(){
		WebDriver driver;
		String baseUrl = "https://www.saucedemo.com/";
		
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions opt = new ChromeOptions();
		opt.setHeadless(false);
		
		String csvDir = System.getProperty("user.dir")+"/src/test/data/test-data.csv";
		
		try(CSVReader reader = new CSVReader(new FileReader(csvDir))){
			String[] nextLine;
			while ((nextLine = reader.readNext()) != null) {
				String email = nextLine[0];
				String password = nextLine[1];
				String status = nextLine[2];
				
				driver = new ChromeDriver(opt);
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				driver.get(baseUrl);
				
				driver.findElement(By.id("user-name")).sendKeys(email);
				driver.findElement(By.id("password")).sendKeys(password);
				driver.findElement(By.xpath("//input[@type='submit']")).click();
				
				if (status.equals("success")) {
					String products = driver.findElement(By.xpath("//span[contains(text(),'Products')]")).getText();
					
					Assert.assertEquals(products, "Products");
				} else {
					String errorLabel = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
					
					Assert.assertEquals(errorLabel, "Epic sadface: Username and password do not match any user in this service");
				}
				
				driver.close();
			}
		} catch(IOException e) {
			throw new RuntimeException(e);
		} catch(CsvValidationException e) {
			throw new RuntimeException(e);
		}
	}
}
