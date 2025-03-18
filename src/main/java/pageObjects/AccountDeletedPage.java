package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountDeletedPage {

WebDriver driver;
	
	public AccountDeletedPage(WebDriver driver) {
		
		this.driver = driver ;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath="//b[text()='Account Deleted!']")
	private WebElement accountDeletedText;
	
	@FindBy(xpath="//a[text()='Continue']")
	private WebElement continueCTA ;
	
	
	
	
	public WebElement accountDeletedText() {
		
		return accountDeletedText;
	}
	
	public WebElement continueCTA() {
		
		return continueCTA;
	}
	
}
