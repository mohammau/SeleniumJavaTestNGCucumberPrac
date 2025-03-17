package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageObjects.CheckOutPage;
import pageObjects.LandingPage;
import pageObjects.ProductsPage;
import resources.Base;

public class AddProductsCart extends Base {
	
	public ProductsPage pp ;
	public CheckOutPage cko ;
	LandingPage lp ;
	
	@And("Click 'Products' button")
	public void Click_Products_button() throws IOException {
	//	driver = initializeDriver(); // Ensure WebDriver is initialized
		lp = new LandingPage(driver);
		lp.productsCTA().click();
	}

	@Then("Hover over first product and click 'Add to cart'")
	public void Hover_over_first_product_and_click_Add_to_cart() {
		
		pp = new ProductsPage(driver);
		Actions ac = new Actions(driver);
		ac.moveToElement(pp.fouthProductDetails()).perform();
		pp.firstProductAddToCart().click();	
		
	}
	
	@And("Click 'Continue Shopping' button")
	public void Click_Continue_Shopping_button() {
		
		pp.AddedToCartContinueCTA().click();
		pp.firstProductAddToCart().click();		
		pp.AddedToCartContinueCTA().click();	
	}
	
	@And("Hover over second product and click 'Add to cart'")
	public void Hover_over_second_product_and_click_Add_to_cart() {
	
		pp.secondProductAddToCart().click();
	}
	
	@And("Click 'View Cart' button")
	public void Click_View_Cart_button() {
		
		pp.viewCartCTA().click();

		
	}
	
	@Then("Verify both products are added to Cart")
	public void Verify_both_products_are_added_to_Cart() {
		
		 cko = new CheckOutPage(driver);
		Assert.assertTrue(cko.productOneCheckout().isDisplayed());
		Assert.assertTrue(cko.productTwoCheckout().isDisplayed());
		
		
	}
	
	@And("Verify their prices, quantity and total price")
	public void Verify_their_prices_quantity_and_total_price() {
		
			double price1 = extractPrice(cko.getProductOnePrice().getText());
			int quantityProduct1 = Integer.parseInt(cko.getProductOneQuantity().getText());
	        double totalPriceProduct1 = extractPrice(cko.productOneTotalPrice().getText());
	        
	        System.out.println(price1);
	        System.out.println(quantityProduct1);
	        System.out.println(totalPriceProduct1);
	        
	        Assert.assertEquals(totalPriceProduct1, price1*quantityProduct1);
	        
	        
			double price2 = AddProductsCart.extractPrice(cko.getProductTwoPrice().getText());
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
	
	

}
