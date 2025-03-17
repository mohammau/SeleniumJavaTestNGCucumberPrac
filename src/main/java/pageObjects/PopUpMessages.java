package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PopUpMessages {
	
	WebDriver driver;
	public PopUpMessages(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[contains(@class,'fc-cta-consent')]")
	private WebElement popUpMessage ;
	
	
	public WebElement popUpMessage() {
		
		return popUpMessage ;
	}

}
