package Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import clothingstore.pageObject.CreateAccount;


public class CreateAccountTest {

	private WebDriver driver;
	private CreateAccount createAccount ;
	
	
	
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\14387\\OneDrive\\Documents\\TESTING\\all drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		createAccount = new CreateAccount(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://automationpractice.com/index.php");		
		
	}
	
	@Test(priority=1)
	public void SignUpTest() {
		createAccount.signUp("Email_10Email@Email.com");
	}

	
	
	@AfterClass
	public void SignOut() {
		String title=createAccount.signOut();
		System.out.println(title);
		driver.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
