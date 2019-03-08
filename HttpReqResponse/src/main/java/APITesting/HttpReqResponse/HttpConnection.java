package APITesting.HttpReqResponse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

import org.json.JSONObject;


public class HttpConnection {
	
	private WebDriver driver;
	
	public void SeleniumSetup () {
		String url= "https://www.bing.com/translator";
		System.setProperty("webdriver.chrome.driver",
				"/home/qainfotech/Eclipse Workspace New Data And Version/testng/chromedriver");
		driver= new ChromeDriver();
		driver.get(url);
		
	}
	
	public void ConvertLanguageFrom (String from) {
		Select languageFrom = new Select (driver.findElement(By.id("t_sl")));
		languageFrom.selectByVisibleText(from);
	}

	public void ConvertLanguageTo (String to) {
		Select languageTo = new Select(driver.findElement(By.id("t_tl")));
		languageTo.selectByVisibleText(to);
	}
	
	public void EnterWord (String words) {
		WebElement textarea = driver.findElement(By.id("t_sv"));
		textarea.sendKeys(words);
		
	}
	
	public String getConvertedOutput () {
		WebElement textarea = driver.findElement(By.id("t_tv"));
		System.out.println(textarea);
		String text= textarea.getAttribute("value");
		return text;
	}
	
	public void CloseConnection () {
		driver.close();
	}
	
	public void getJsonOutput () {
		
	}
	
	

}
