package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@href='/' and contains(text(),'Home')]")
	private WebElement homePage ;
	
	@FindBy(xpath = "//a[@href='/login']")
	private WebElement loginCTA ;
	
	public WebElement homePage() {
		
		return homePage;
	}
	
	public WebElement loginCTA() {
		
		return loginCTA;
	}

}
