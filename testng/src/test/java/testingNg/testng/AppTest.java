package testingNg.testng;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Test;


public class AppTest 
{	
	private WebDriver driver;
	private String query;
	private String result;
	
	// Create Instance of web driver
	@BeforeTest
	public void createInstance () {
	
		System.setProperty("webdriver.chrome.driver", "/home/qainfotech/Eclipse Workspace New Data And Version/selenium/chromedriver");
		  
        driver = new ChromeDriver();
        
        driver.get("https://www.google.com");
        
	}
	
	// INsert Query on the search box and search start
	@Test
	public void queryInsertion () {
		
		WebElement  searchbox = driver.findElement(By.name("q"));
        
		Scanner sc=new Scanner(System.in);
        System.out.println("Enter the query");
        
        query =sc.nextLine();
        
        searchbox.sendKeys(query);
        searchbox.submit();
	}
	
	// evaluate the search results
	@Test
	public void validateResult () {
		
		 WebElement data=driver.findElement(By.className("st"));
	     
		 result=data.getText().toLowerCase();
	     
		 data=driver.findElement(By.className("LC20lb"));
	     
		 result+=data.getText().toLowerCase();
	     
	     Assert.assertEquals(result.contains(query.toLowerCase()), true);
	        
	}
	
	// Web driver close
	@AfterSuite
	public void closeConnection () {
		
		driver.close();
	}
}
