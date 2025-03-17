package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageObjects.LandingPage;
import pageObjects.LoggedInUser;
import pageObjects.LoginSignUpPage;
import pageObjects.PopUpMessages;
import resources.Base;

public class logout extends Base {
	
	WebDriver driver ;
	LandingPage lp;
	LoginSignUpPage lsp;
	LoggedInUser lu;
	
	@Given("^Launch browser$")
	public void Launch_browser() throws IOException {
		
	    driver = initializeDriver();
	}
	
	@And("^Navigate to url 'http://automationexercise.com'$")
	public void Navigate_to_url() {

	driver.get(prop.getProperty("URL"));
	PopUpMessages pop = new PopUpMessages(driver);
	pop.popUpMessage().click();
	
	}
	
	@Then("^Verify that home page is visible successfully$")
	public void Verify_that_home_page_is_visible_successfully() {
		
		lp = new LandingPage(driver);
		
		AssertJUnit.assertTrue(lp.homePage().isDisplayed());
		
	}
	
	@And("^Click on 'Signup / Login' button$")
	public void Click_on_Signup_Login_button() {
		
		lp.loginCTA().click();
		
	}
	
	@Then("^Verify 'Login to your account' is visible$")
	public void Verify_Login_to_your_account_is_visible() {
		
		lsp = new LoginSignUpPage(driver);
		AssertJUnit.assertTrue(lsp.textHeaderLogin().isDisplayed());
	}
	
	@And("^Enter correct email address and password$")
	public void Enter_correct_email_address_and_password() {
		
		lsp.loginEmailField().sendKeys(prop.getProperty("email"));
		lsp.loginPasswordField().sendKeys(prop.getProperty("password"));	
	}
	
	@And("^Click 'login' button$")
	public void Click_login_button() {
		
		lsp.loginButton().click();

		
	}
	
	@Then("^Verify that 'Logged in as username' is visible$")
	public void Verify_that_Logged_in_as_username_is_visible() {
		
		lu = new LoggedInUser(driver);
		AssertJUnit.assertTrue(lu.LoggedInUserText().isDisplayed());
		
	}
	
	@And("^Click 'Logout' button$")
	public void Click_Logout_button() {
		
		lu.logoutButton().click();

		
	}
	
	@Then("^Verify that user is navigated to login page$")
	public void Verify_that_user_is_navigated_to_login_page() {
		
		AssertJUnit.assertTrue(lsp.textHeaderLogin().isDisplayed());

	}
}
