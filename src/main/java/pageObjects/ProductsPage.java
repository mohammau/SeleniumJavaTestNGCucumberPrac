package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
	
	WebDriver driver;
	
	public ProductsPage(WebDriver driver) {
		
		this.driver = driver ;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//a[@href = '/product_details/4']")
	private WebElement fouthProductDetails;
			
	
	@FindBy(xpath="//a[@data-product-id='1']")
	private WebElement firstProductAddToCart;
	
	@FindBy(xpath="//a[@data-product-id='2']")
	private WebElement secondProductAddToCart;
	
	@FindBy(xpath="//button[text()='Continue Shopping']")
	private WebElement AddedToCartContinueCTA ;
	
	@FindBy(xpath="//u[text()='View Cart']")
	private WebElement viewCartCTA ;
	
	
	
	
	public WebElement firstProductAddToCart() {
		
		return firstProductAddToCart ;
	}
	
	public WebElement fouthProductDetails() {
		
		return fouthProductDetails ;
	}
	
	public WebElement AddedToCartContinueCTA() {
		
		return AddedToCartContinueCTA ;
	}
	
	public WebElement secondProductAddToCart() {
		
		return secondProductAddToCart ;
	}
	
	public WebElement viewCartCTA() {
		
		return viewCartCTA ;
	}
	
}
