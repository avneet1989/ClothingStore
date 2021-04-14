package clothingstore.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage {
	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver=driver;
	}
	
	
	By AddToCart=By.xpath("//*[text()='Add to cart']");
	By ProceedToCheckout = By.linkText("Proceed to checkout");
	
	By ShoppingCartHeader = By.xpath("//*[@id='cart_title']");
	By ProccedCheckout = By.linkText("Proceed to checkout");
	
	By ProccedChkout = By.xpath("//*[@class='cart_navigation clearfix']//button");
	
	By TermChkbox =By.xpath("//*[@id='cgv']");
	By ProccedFourth = By.cssSelector("button.btn.btn-default.standard-checkout.button-medium");
	By payCheck =By.xpath("(//*[@class='payment_module'])[2]");
	By CheckPayment = By.cssSelector("page-subheading");
	By confirmOrder =By.xpath("//*[text()='I confirm my order']");
	By Status = By.cssSelector(".alert.alert-success");

	public String AddToCart() {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement product1=driver.findElement(By.xpath("//ul[@id='homefeatured']/li"));
		
		js.executeScript("arguments[0].scrollIntoView();", product1);
		Actions Ac = new Actions(driver);
		Ac.moveToElement(product1).perform();		
		driver.findElement(AddToCart).click();
		
		if(driver.findElement(ProceedToCheckout).isDisplayed()) {
		driver.findElement(ProceedToCheckout).click();
		}else {
			System.out.println("Procced To Chechkout not displayed");
		}
		System.out.println(driver.findElement(ShoppingCartHeader).getText());
		
		WebElement proceed2=driver.findElement(By.linkText("Proceed to checkout"));
		js.executeScript("arguments[0].scrollIntoView();", proceed2);
		driver.findElement(ProccedCheckout).click();
		
		
		WebElement proceed3=driver.findElement(By.xpath("//*[@class='cart_navigation clearfix']//button"));
		js.executeScript("arguments[0].scrollIntoView();", proceed3);
		driver.findElement(ProccedChkout).click();
		
		WebElement termbox=driver.findElement(By.xpath("//*[@id='cgv']"));
		js.executeScript("arguments[0].scrollIntoView();", termbox);
		driver.findElement(TermChkbox).click();
		driver.findElement(ProccedFourth).click();
		
		driver.findElement(payCheck).click();
				
		WebElement confirmButton=driver.findElement(By.xpath("//*[text()='I confirm my order']"));
		js.executeScript("arguments[0].scrollIntoView();", confirmButton);
		driver.findElement(confirmOrder).click();
		
		return driver.findElement(Status).getText();
		

		
	}
	
}
