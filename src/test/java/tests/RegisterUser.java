package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.Select;


import pageObjects.AccountDeletedPage;
import pageObjects.LandingPage;
import pageObjects.LoginSignUpPage;
import pageObjects.PopUpMessages;
import pageObjects.RegisteredUserPage;
import pageObjects.RegistrationPage;
import resources.Base;

public class RegisterUser extends Base {
	
	Logger log ;
	
	@BeforeMethod
	public void setUp() throws IOException {
		
		log = LogManager.getLogger(RegisteredUserPage.class.getName());
		
		
		driver = initializeDriver();
		
		driver.get(prop.getProperty("URL"));
		log.debug("Website launched");
		
	}
	
	@Test
	public void userRegister() {
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		PopUpMessages pum = new PopUpMessages(driver);
		
		pum.popUpMessage().click();
		log.debug("Pop up message clicked");
		
		LandingPage lp = new LandingPage(driver);
		
		lp.loginCTA().click();
		log.debug("Sign Up option clicked");

		
		LoginSignUpPage rp = new LoginSignUpPage(driver);
		
		AssertJUnit.assertTrue(rp.textHeaderSignUp().isDisplayed());
		log.debug("Registration header is displayed");

		rp.SignUpName().sendKeys(prop.getProperty("SignUpName"));
		log.debug("Name entered");

		rp.SignUpEmail().sendKeys(prop.getProperty("SignUpEmail"));
		log.debug("email entered");

		rp.signupButton().click();
		log.debug("Sign up CTA clicked");

		
		RegistrationPage rp1 = new RegistrationPage(driver);
		AssertJUnit.assertTrue(rp1.registrationPageHeader().isDisplayed());
		log.debug("Registration page header is displayed");

		rp1.titleRegister().click();
		log.debug("Title entered");

		rp1.passwordRegister().sendKeys(prop.getProperty("RegisterPwd"));
		log.debug("Password entered");

		Select select = new Select(rp1.daysDOB());
		select.selectByValue(prop.getProperty("DayDOB"));
		log.debug("Day selected");

		Select select1 = new Select(rp1.monthsDOB());
		select1.selectByIndex(10);
		log.debug("Month Selected");

		
		Select select2 = new Select(rp1.yearsDOB());
		select2.selectByVisibleText(prop.getProperty("YearDOB"));
		log.debug("Year Selected");

		rp1.newsletterCheckUncheck().click();
		log.debug("Newsletter selected");

		rp1.offersCheckUncheck().click();
		log.debug("Offers selected");

		rp1.firstNameAddress().sendKeys("abc");
		log.debug("First name of the company entered");

		rp1.lastNameAddress().sendKeys("xyz");
		log.debug("Last name of the company entered");
		
		rp1.companyAddress().sendKeys("abcXYZ");
		log.debug("Company name entered");
		
		rp1.address1Address().sendKeys("24");
		log.debug("House number entered");
		
		rp1.address2Address().sendKeys("The Boulevard");
		log.debug("Address line 2 entered");

		
		Select select3 = new Select(rp1.countryAddress());
		select3.selectByValue("Canada");
		log.debug("Country selected");

		
		rp1.stateAddress().sendKeys(prop.getProperty("State"));
		log.debug("State entered");

		rp1.cityAddress().sendKeys(prop.getProperty("City"));
		log.debug("City entered");

		rp1.zipcodeAddress().sendKeys(prop.getProperty("ZipCode"));
		log.debug("Zipcode entered");

		rp1.mobileNumberAddress().sendKeys(prop.getProperty("MobileNumber"));
		log.debug("Mobile number entered");

		rp1.createAccountCTA().click();
		log.debug("Create account cta clicked");

		
		AssertJUnit.assertTrue(rp1.accountCreated().isDisplayed());
		log.debug("Account created text is displayed");

		rp1.continueCreated().click();
		log.debug("Clicked on continue");

		RegisteredUserPage rup = new RegisteredUserPage(driver);
		
		String expectedText = rup.registeredUserText().getText();
		
		System.out.println(expectedText);
		
		if(expectedText.contains("Logged in as Mohammad Ummar")) {
			
			System.out.println("Registration successful");
		}
			else { System.out.println("Registration failed");
		}
		
		AssertJUnit.assertEquals(expectedText, "Logged in as Mohammad Ummar");
		log.debug("Logged in as Mohammad ummar");

		rup.deleteAccountCTA().click();
		log.debug("Account Deleted");

		
		AccountDeletedPage adp = new AccountDeletedPage(driver);
		AssertJUnit.assertTrue(adp.accountDeletedText().isDisplayed());
		
		adp.continueCTA().click();
		log.debug("Closed the account delete page");	
	}

	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
		log.debug("Session ended");

	}
	
	


}
