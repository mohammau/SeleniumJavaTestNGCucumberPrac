package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoggedInUser;
import pageObjects.LoginSignUpPage;
import pageObjects.PopUpMessages;
import resources.Base;

public class LogoutUser extends Base {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() throws IOException {
		
		driver = initializeDriver();
		driver.get(prop.getProperty("URL"));
		PopUpMessages pop = new PopUpMessages(driver);
		pop.popUpMessage().click();
		
	}
	
	@Test
	public void logout() {
		
		
		LandingPage lp = new LandingPage(driver);
		
		AssertJUnit.assertTrue(lp.homePage().isDisplayed());
		lp.loginCTA().click();
		
		LoginSignUpPage lsp = new LoginSignUpPage(driver);
		AssertJUnit.assertTrue(lsp.textHeaderLogin().isDisplayed());
		
		lsp.loginEmailField().sendKeys(prop.getProperty("email"));
		lsp.loginPasswordField().sendKeys(prop.getProperty("password"));
		lsp.loginButton().click();
		
		LoggedInUser lu = new LoggedInUser(driver);
		AssertJUnit.assertTrue(lu.LoggedInUserText().isDisplayed());
		lu.logoutButton().click();
		
		AssertJUnit.assertTrue(lsp.textHeaderLogin().isDisplayed());
		

		}
	
	
	
	@AfterMethod
	public void tearDown() {
		
		driver.close();
		
	}
}
	
	
	


