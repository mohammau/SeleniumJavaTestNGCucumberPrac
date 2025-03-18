package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
	
	WebDriver driver;
	
	public RegistrationPage(WebDriver driver) {
		
		this.driver = driver ;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath="//b[text()='Enter Account Information']")
	private WebElement registrationPageHeader;
	
	@FindBy(id="id_gender1")
	private WebElement titleRegister;
	
	@FindBy(id="password")
	private WebElement passwordRegister;
	
	@FindBy(id="days")
	private WebElement daysDOB;
	
	@FindBy(id="months")
	private WebElement monthsDOB;
	
	@FindBy(id="years")
	private WebElement yearsDOB;
	
	@FindBy(id="newsletter")
	private WebElement newsletterCheckUncheck;
	
	@FindBy(id="optin")
	private WebElement offersCheckUncheck;
	
	@FindBy(id="first_name")
	private WebElement firstNameAddress;
	
	@FindBy(id="last_name")
	private WebElement lastNameAddress;
	
	@FindBy(id="company")
	private WebElement companyAddress;
	
	@FindBy(id="address1")
	private WebElement address1Address;
	
	@FindBy(id="address2")
	private WebElement address2Address;
	
	@FindBy(name="country")
	private WebElement countryAddress;
	
	@FindBy(id="state")
	private WebElement stateAddress;
	
	@FindBy(id="city")
	private WebElement cityAddress;
	
	@FindBy(id="zipcode")
	private WebElement zipcodeAddress;
	
	@FindBy(id="mobile_number")
	private WebElement mobileNumberAddress;
	
	@FindBy(xpath="//button[text()='Create Account']")
	private WebElement createAccountCTA;
	
	@FindBy(xpath="//b[text()='Account Created!']")
	private WebElement accountCreated;
	
	@FindBy(xpath="//a[text()='Continue']")
	private WebElement continueCreated;
	
	public WebElement registrationPageHeader() {
			
			return registrationPageHeader ;
		}
	
	public WebElement titleRegister() {
		
		return titleRegister;
	}
	
	public WebElement passwordRegister() {
			
			return passwordRegister;
		}
	
	public WebElement daysDOB() {
		
		return daysDOB;
		
	}
	
	public WebElement monthsDOB() {
		
		return monthsDOB;
	}
	
	public WebElement yearsDOB() {
		
		return yearsDOB;
	}
	
	public WebElement newsletterCheckUncheck() {
		
		return newsletterCheckUncheck;
	}
	
	public WebElement offersCheckUncheck() {
			
			return offersCheckUncheck;
		}
	
	public WebElement firstNameAddress() {
		
		return firstNameAddress;
	}
	
	public WebElement lastNameAddress() {
			
			return lastNameAddress;
		}
	
	public WebElement companyAddress() {
		
		return companyAddress;
	}
	
	public WebElement address1Address() {
		
		return address1Address;
	}
	
	public WebElement address2Address() {
		
		return address2Address;
	}
	
	public WebElement countryAddress() {
		
		return countryAddress;
	}
	
	public WebElement cityAddress() {
			
			return cityAddress;
		}
	
	public WebElement stateAddress() {
		
		return stateAddress;
	}
	
	public WebElement zipcodeAddress() {
			
			return zipcodeAddress;
		}
	
	public WebElement mobileNumberAddress() {
		
		return mobileNumberAddress;
	}
	
	public WebElement createAccountCTA() {
		
		return createAccountCTA;
	}
	
	public WebElement accountCreated() {
			
			return accountCreated;
		}
	
	public WebElement continueCreated() {
		
		return continueCreated;
	}
}
