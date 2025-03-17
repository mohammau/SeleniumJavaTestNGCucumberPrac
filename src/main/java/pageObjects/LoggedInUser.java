package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoggedInUser {
	
	WebDriver driver ;
	
	public LoggedInUser(WebDriver driver) {
		
		this.driver = driver ;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//li/a[contains(text(),'Logged in as')]")
	private WebElement LoggedInUserText ;
	
	@FindBy(xpath = "//a[@href = '/logout']")
	private WebElement logoutButton;

	public WebElement LoggedInUserText() {
		
		return LoggedInUserText ;
}
	
	public WebElement logoutButton() {
		
		return logoutButton ;
}
}