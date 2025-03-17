package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage {
	
	WebDriver driver;
	
	public CheckOutPage(WebDriver driver) {
		
		this.driver = driver ;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "product-1")
	private WebElement productOneCheckout;
	
	@FindBy(id = "product-2")
	private WebElement productTwoCheckout;
	
	@FindBy(xpath="//tr[@id='product-1']//td[@class='cart_price']/p")
	private WebElement getProductOnePrice;
	
	@FindBy(xpath="//tr[@id='product-2']//td[@class='cart_price']/p")
	private WebElement getProductTwoPrice;
	
	@FindBy(xpath="//tr[@id='product-1']//button")
	private WebElement getProductOneQuantity;
	
	@FindBy(xpath="//tr[@id='product-2']//button")
	private WebElement getProductTwoQuantity;
	
	@FindBy(xpath="//tr[@id='product-1'] //td[@class='cart_total']/p")
	private WebElement productOneTotalPrice;
	
	@FindBy(xpath="//tr[@id='product-2'] //td[@class='cart_total']/p")
	private WebElement productTwoTotalPrice;
	
	
	
	public WebElement productOneCheckout() {
		
		return productOneCheckout ;
	}
	
	public WebElement productTwoCheckout() {
		
		return productTwoCheckout ;
	}
	
	public WebElement getProductOnePrice() {
		
		return getProductOnePrice ;
	}
	
	public WebElement getProductTwoPrice() {
		
		return getProductTwoPrice ;
	}
	
	public WebElement getProductOneQuantity() {
		
		return getProductOneQuantity ;
	}
	
	public WebElement getProductTwoQuantity() {
		
		return getProductTwoQuantity ;
	}
	
	public WebElement productOneTotalPrice() {
		
		return productOneTotalPrice ;
	}
	
	public WebElement productTwoTotalPrice() {
		
		return productTwoTotalPrice ;
	}

}
