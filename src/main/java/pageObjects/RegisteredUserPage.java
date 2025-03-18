package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisteredUserPage {
	
	WebDriver driver;
	
	public RegisteredUserPage(WebDriver driver) {
		
		this.driver = driver ;
		PageFactory.initElements(driver, this);
		
	}

	
	@FindBy(xpath="//li/a[contains(text(),'Logged in as')]")
	private WebElement registeredUserText;
	
	@FindBy(xpath="//a[text()=' Delete Account']")
	private WebElement deleteAccountCTA;
	
	public WebElement registeredUserText() {
		
		return registeredUserText;
	}
	
	public WebElement deleteAccountCTA() {
		
		return deleteAccountCTA;
	}
	
}
