package login.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Handler {

	private String url = "https://hris.qainfotech.com/login.php";

	// Create browser instance
	public WebDriver createInstance() {

		System.setProperty("webdriver.chrome.driver",
				"/home/qainfotech/Eclipse Workspace New Data And Version/testng/chromedriver");

		WebDriver driver = new ChromeDriver();

		driver.get(url);

		return driver;

	}

	// check for Success of the login attempt
	public boolean CredentialCheck (WebDriver driver ) {
		
		 return !(driver.getCurrentUrl().equalsIgnoreCase(url));
		
	}
	
	
	//Enter username
	public void EnterUsernme (WebDriver driver, String username) {
		
		WebElement data = driver.findElement(By.id("txtUserName"));

		data.sendKeys(username);
		
	}
	
	//Enter Password
	public void EnterPassword (WebDriver driver, String password) {
		
		WebElement data  = driver.findElement(By.id("txtPassword"));

		data.sendKeys(password);

	}
	
	// Click Sign button
	public void ClickSignIn (WebDriver driver) {
		
		WebElement data = driver.findElement(By.name("Submit"));

		data.click();
		
	}
	
	// CHeck the current focus in the page
	public boolean FocusTest(WebDriver driver, WebElement data) throws Exception {
		
		Thread.sleep(2000);

		return data.equals(driver.switchTo().activeElement());
		
	}

	//Close Instance
	public void CloseInstance(WebDriver driver) {
		driver.quit();
//		driver.close();

	}

}