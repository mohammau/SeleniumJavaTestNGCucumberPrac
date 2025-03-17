package tests;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.CheckOutPage;
import pageObjects.LandingPage;
import pageObjects.PopUpMessages;
import pageObjects.ProductsPage;
import resources.Base;

public class AddProductsCart extends Base {
	
	WebDriver driver ;
	
	@BeforeMethod
	public void setUp() throws IOException {
		
		driver = initializeDriver();
		driver.get(prop.getProperty("URL"));
		
		PopUpMessages pop = new PopUpMessages(driver);
		pop.popUpMessage().click();
	}
	
	@Test
	public void addToCart() throws InterruptedException {
		
		LandingPage lp = new LandingPage(driver);
		Assert.assertTrue(lp.homePage().isDisplayed());
		
		lp.productsCTA().click();
		
		System.out.println(lp.productsCTA());
		
		ProductsPage pp = new ProductsPage(driver);
		Actions ac = new Actions(driver);
		ac.moveToElement(pp.fouthProductDetails()).perform();
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.elementToBeClickable(pp.firstProductDetails()));
		
		pp.firstProductAddToCart().click();		
		pp.AddedToCartContinueCTA().click();	
		pp.firstProductAddToCart().click();		
		pp.AddedToCartContinueCTA().click();	
		pp.secondProductAddToCart().click();
		pp.viewCartCTA().click();
		
		CheckOutPage cko = new CheckOutPage(driver);
		Assert.assertTrue(cko.productOneCheckout().isDisplayed());
		Assert.assertTrue(cko.productTwoCheckout().isDisplayed());
		
		
//		Thread.sleep(Duration.ofSeconds(3));
		
        double price1 = extractPrice(cko.getProductOnePrice().getText());
		int quantityProduct1 = Integer.parseInt(cko.getProductOneQuantity().getText());
        double totalPriceProduct1 = extractPrice(cko.productOneTotalPrice().getText());
        
        System.out.println(price1);
        System.out.println(quantityProduct1);
        System.out.println(totalPriceProduct1);
        
        Assert.assertEquals(totalPriceProduct1, price1*quantityProduct1);
        
        
		double price2 = extractPrice(cko.getProductTwoPrice().getText());
		int quantityProduct2 = Integer.parseInt(cko.getProductTwoQuantity().getText());
		double totalPriceProduct2 = extractPrice(cko.productTwoTotalPrice().getText());
		

        System.out.println(price2);
        System.out.println(quantityProduct2);
        System.out.println(totalPriceProduct2);
        
        Assert.assertEquals(totalPriceProduct2, price2*quantityProduct2);

	}
	
	public static double extractPrice(String text) {
        return Double.parseDouble(text.replace("Rs.", "").trim());
    }
	
	
	@AfterMethod
	public void tearDown() {
		
		driver.close();
		
	}
	

}
