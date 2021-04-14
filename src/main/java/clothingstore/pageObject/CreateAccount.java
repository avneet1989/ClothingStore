package clothingstore.pageObject;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CreateAccount {
	private WebDriver driver;
	
		public CreateAccount(WebDriver driver) {
			this.driver = driver;
		}	
		
			By signUpButton = By.xpath("//a[contains(text(),'Sign in')]");
			By email =By.xpath("//input[@id='email_create']");
			By createAccountButton = By.xpath("//button[@id=\"SubmitCreate\"]");
			By gender=By.id("uniform-id_gender1");
			By firstName=By.id("customer_firstname");
			By lastName=By.id("customer_lastname");
			
			By password=By.id("passwd");
			By days=By.id("days");
			By months=By.id("months");
			By year=By.id("years");
		
			By company=By.id("company");
			By address=By.id("address1");
			By city=By.id("city");
			By state=By.id("id_state");
			By postalcode=By.id("postcode");
			
			
			By phoneNumber=By.id("phone_mobile");
			By Register=By.id("submitAccount");
			
			By welcomeText=By.xpath("//p[contains(text(), \"Welcome to your account.\")]");
			By HomeButton=By.xpath("//*[@class='footer_links clearfix']/li");
			
			By logout = By.xpath("//header/div[2]/div[1]/div[1]/nav[1]/div[2]/a[1]");
			
			
			public void signUp(String ToCreateEmail)  {
				
				driver.findElement(signUpButton).click();
				driver.findElement(email).sendKeys(ToCreateEmail);
				driver.findElement(createAccountButton).click();
				driver.findElement(gender).click();
				driver.findElement(firstName).sendKeys("K");
				driver.findElement(lastName).sendKeys("kk");
				driver.findElement(password).sendKeys("12345");
				Select sl=new Select(driver.findElement(days));
				sl.selectByValue("1");
				Select sl1=new Select(driver.findElement(months));
				sl1.selectByValue("2");
				Select sl2=new Select(driver.findElement(year));
				sl2.selectByValue("1980");;
				driver.findElement(company).sendKeys("xyz");
				driver.findElement(address).sendKeys("12 rue de reims");
				driver.findElement(city).sendKeys("colombus");
				Select sl3=new Select(driver.findElement(state));
				sl3.selectByVisibleText("Indiana");;
				driver.findElement(postalcode).sendKeys("27036");
				
				driver.findElement(phoneNumber).sendKeys("1123456789");
				
				driver.findElement(Register).click();
				System.out.println(driver.findElement(welcomeText).getText());
				
				

			}
			public String signOut() {
				driver.findElement(logout).click();
				return driver.getTitle();
			}
			public HomePage NavigateToHomePage() {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				WebElement HomePageButton =driver.findElement(By.xpath("//*[@class='footer_links clearfix']/li"));
				js.executeScript("arguments[0].scrollIntoView();", HomePageButton);
				
				driver.findElement(HomeButton).click();
				System.out.println(driver.getTitle());
				return new HomePage(driver);
			}
			
			
			

		}