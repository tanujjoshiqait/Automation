package login.testing;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class AppTest {

	private WebDriver driver;
	private String url = "https://hris.qainfotech.com/login.php";
	private Handler handle = new Handler();

	@BeforeMethod
	public void setup() {

		driver = handle.createInstance();

	}

	@Test
	public void CorrectCredentialLogin() throws Exception {

		String username = "Tanuj";
		
		String password = "dfdsfs";

		handle.EnterUsernme(driver, password);

		handle.EnterPassword(driver, "adasffsdf");

		handle.ClickSignIn(driver);

		AssertJUnit.assertEquals(handle.CredentialCheck(driver), false);

	}

	@Test
	public void InCorrectCredentialLogin() throws Exception {

		String username = "sdfdf";
		
		String password = "dfdsfs";

		handle.EnterUsernme(driver, password);

		handle.EnterPassword(driver, "adasffsdf");

		handle.ClickSignIn(driver);

		AssertJUnit.assertEquals(handle.CredentialCheck(driver), false);

	}

	@Test
	public void EmptyCredentialLogin() throws Exception {

		String username = "";
		
		String password = "";

		handle.EnterUsernme(driver, password);

		handle.EnterPassword(driver, "adasffsdf");

		handle.ClickSignIn(driver);

		AssertJUnit.assertEquals(handle.CredentialCheck(driver), false);

	}

	@Test
	public void CurrentFocus() throws Exception {

		WebElement data = driver.findElement(By.id("txtUserName"));

		AssertJUnit.assertEquals(handle.FocusTest(driver, data), true);

	}
	// Username Field
	@Test
	public void InputUsernameType () {
		
		WebElement data = driver.findElement(By.name("txtUserName"));
		String type= data.getAttribute("type");
		Assert.assertEquals(type, "text");

	}
	
	@Test
	public void InputUsernameClickable() {
		
		WebElement data = driver.findElement(By.name("txtUserName"));
		Assert.assertEquals(data.isEnabled(), true);

	}

	@Test
	public void InputUsernameDisplay() {
		
		WebElement data = driver.findElement(By.name("txtUserName"));
		Assert.assertEquals(data.isDisplayed(), true);

	}
	
	// Password Field
	
	@Test
	public void InputPasswordType () {
		
		WebElement data = driver.findElement(By.name("txtPassword"));
		String type= data.getAttribute("type");
		Assert.assertEquals(type, "password");

	}

	
	@Test
	public void InputPasswordClickable() {
		
		WebElement data = driver.findElement(By.name("txtPassword"));
		Assert.assertEquals(data.isEnabled(), true);

	}

	@Test
	public void InputPasswordDisplay() {
		
		WebElement data = driver.findElement(By.name("txtPassword"));
		Assert.assertEquals(data.isDisplayed(), true);

	}


	
	@Test
	public void SignInClickable() {
		
		WebElement data = driver.findElement(By.name("Submit"));
		Assert.assertEquals(data.isEnabled(), true);

	}

	@Test
	public void SignInDisplay() {
		
		WebElement data = driver.findElement(By.name("Submit"));
		Assert.assertEquals(data.isDisplayed(), true);

	}
	
	@Test
	public void CheckboxChecked() {
		WebElement data = driver.findElement(By.id("txtSsi"));
		Assert.assertEquals(data.isSelected(), false);
	}
	
	@Test
	public void CheckboxDisplay() {
		WebElement data = driver.findElement(By.id("txtSsi"));
		Assert.assertEquals(data.isDisplayed(), true);
	}
	
	@Test
	public void CheckboxClickable() {
		WebElement data = driver.findElement(By.id("txtSsi"));
		Assert.assertEquals(data.isEnabled(), true);
	}
	
	@Test
	public void PayRollOnlineNewTab() {
		
		List <String> tabsBefore = new ArrayList<String>(driver.getWindowHandles());
		WebElement data = driver.findElement(By.linkText("Access Payroll Online"));
		data.click();
		List <String> tabsAfter = new ArrayList<String>(driver.getWindowHandles());
		WebDriver tabDriver=driver;
//		tabDriver.switchTo().window(tabsAfter .get(0));
//		tabDriver.close();
		Assert.assertEquals(tabsAfter.size()-tabsBefore.size(), 1);
	}

	
	
	@AfterMethod
	public void CloseInstance() {

		handle.CloseInstance(driver);
	}

}
