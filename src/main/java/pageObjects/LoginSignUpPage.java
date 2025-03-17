package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginSignUpPage {
	
	WebDriver driver;
	
	public LoginSignUpPage(WebDriver driver) {
		
		this.driver = driver ;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//h2[text()='Login to your account']")
	private WebElement textHeaderLogin;
	
	@FindBy(xpath = "//h2[text()='New User Signup!']")
	private WebElement textHeaderSignUp;
	
	@FindBy(xpath = "//input[@data-qa = 'login-email']")
	private WebElement loginEmailField;
	
	@FindBy(xpath = "//input[@data-qa = 'login-password']")
	private WebElement loginPasswordField;
	
	@FindBy(xpath = "//button[@data-qa = 'login-button']")
	private WebElement loginButton;
	
	@FindBy(xpath = "//button[@data-qa = 'signup-button']")
	private WebElement signupButton;
	
	@FindBy(xpath = "//input[@data-qa = 'signup-name']")
	private WebElement SignUpName;
	
	@FindBy(xpath = "//input[@data-qa = 'signup-email']")
	private WebElement SignUpEmail;
	
	@FindBy(xpath = "//p[text()='Email Address already exist!']")
	private WebElement emailExistText;

	
	public WebElement textHeaderLogin() {
		
		return textHeaderLogin;
	}
	
	public WebElement loginEmailField() {
		
		return loginEmailField ;
	}
	
	public WebElement loginPasswordField() {
		
		return loginPasswordField ;
	}
	
	public WebElement loginButton() {
		
		return loginButton ;
	}
	
	public WebElement textHeaderSignUp() {
		
		return textHeaderSignUp ;
	}
	
	
	public WebElement SignUpName() {
		
		return SignUpName ;
	}
	
	public WebElement SignUpEmail() {
		
		return SignUpEmail ;
	}
	public WebElement signupButton() {
		
		return signupButton ;
	}
	
	public WebElement emailExistText() {
		
		return emailExistText;
	}
}
