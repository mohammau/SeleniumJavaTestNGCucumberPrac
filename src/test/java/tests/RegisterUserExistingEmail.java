package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;


import pageObjects.LandingPage;
import pageObjects.LoginSignUpPage;
import pageObjects.PopUpMessages;
import resources.Base;

public class RegisterUserExistingEmail extends Base {
	
	WebDriver driver;
	Logger log ;
	
	
	
	@BeforeMethod
	public void setUp() throws IOException {
		
		
		log = LogManager.getLogger(RegisterUserExistingEmail.class.getName());
		
		driver = initializeDriver();
		log.debug("Browser Launched");
		
		driver.get(prop.getProperty("URL"));
		log.debug("Website Opened");
		
		PopUpMessages pop = new PopUpMessages(driver);
		pop.popUpMessage().click();
		log.debug("Pop Up Message Clicked");
	}
	
	@Test
	public void existingEmailRegister() {
						
		LandingPage lp = new LandingPage(driver);
		AssertJUnit.assertTrue(lp.homePage().isDisplayed());
		log.debug("Home Page is displayed");
		
		lp.loginCTA().click();
		log.debug("Login Clicked");

		LoginSignUpPage lsp = new LoginSignUpPage(driver);
		AssertJUnit.assertTrue(lsp.textHeaderSignUp().isDisplayed());
		log.debug("SignUpHeaderTextDisplayed");
		
		lsp.SignUpName().sendKeys(prop.getProperty("Name"));
		log.debug("Name Entered");
		
		lsp.SignUpEmail().sendKeys(prop.getProperty("email"));
		log.debug("Email Entered");
		
		lsp.signupButton().click();
		log.debug("SignUp button clicked");
		
		AssertJUnit.assertTrue(lsp.emailExistText().isDisplayed());
		log.debug("Email exits message seen");
		
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		
		driver.close();
		log.debug("Browser Closed");
	}

}
