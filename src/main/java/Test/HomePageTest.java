package Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import clothingstore.pageObject.CreateAccount;
import clothingstore.pageObject.HomePage;

public class HomePageTest {
	private WebDriver driver;
	private CreateAccount createAccount ;
	private HomePage homePage ;
	
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\14387\\OneDrive\\Documents\\TESTING\\all drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://automationpractice.com/index.php");		
		createAccount = new CreateAccount(driver);
		createAccount.signUp("ratim@email.com");
		homePage=createAccount.NavigateToHomePage();
		
		
	
		
	}
	@Test(priority=1)
	public void AddToCartTest() {
		
		
		String mssg=homePage.AddToCart();
		System.out.println(mssg);
		String expectedMssg="Your order on My Store is complete.";
		Assert.assertEquals(mssg, expectedMssg);
	}
	
	@AfterClass
	public void SignOut() {
		String title=createAccount.signOut();
		System.out.println(title);
		driver.close();
	}

}
