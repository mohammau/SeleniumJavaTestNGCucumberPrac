package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AccountDeletedPage;
import pageObjects.LandingPage;
import pageObjects.PopUpMessages;
import pageObjects.RegisteredUserPage;
import pageObjects.RegistrationPage;
import pageObjects.LoginSignUpPage;
import resources.Base;

public class RegisterUserr extends Base {
	
	LoginSignUpPage rp ;
	RegistrationPage rp1 ;
	RegisteredUserPage rup;
	
//	@Given("^Launch browser$")
//	public void Launch_browser() throws IOException {
//		
//	driver = initializeDriver();
//		
//	}
	
//	@When("^Navigate to url$")
//	public void Navigate_to_url() throws IOException {
//		
//		driver = initializeDriver();
//		driver.get(prop.getProperty("URL"));
//		PopUpMessages pum = new PopUpMessages(driver);
//		
//		pum.popUpMessage().click();
//
//	}
	
//	@Then("^Verify that home page is visible successfully$")
//	public void Verify_that_home_page_is_visible_successfully() {
//		
//		
//		
//	}
	
	@And("^Click on 'Signup / Login' button$")
	public void  Click_on_Signup_Login_button() {
		
		LandingPage lp = new LandingPage(driver);
		
		lp.loginCTA().click();
	}
	
	@Then("^Verify 'New User Signup!' is visible$")
	public void Verify_New_User_Signup_is_visible() {
		
		rp = new LoginSignUpPage(driver);
		
		AssertJUnit.assertTrue(rp.textHeaderSignUp().isDisplayed());
		
	}
	
	@And("^Enter name and email address$")
	public void Enter_name_and_email_address() {
		
		rp.SignUpName().sendKeys(prop.getProperty("SignUpName"));
		

		rp.SignUpEmail().sendKeys(prop.getProperty("SignUpEmail"));
		
		
	}
	
	@And("^Click 'Signup' button$")
	public void Click_Signup_button() {
		
		rp.signupButton().click();
		
	}
	
	@Then("^Verify that 'ENTER ACCOUNT INFORMATION' is visible$")
	public void Verify_that_ENTER_ACCOUNT_INFORMATION_is_visible() {
		
		rp1 = new RegistrationPage(driver);
		AssertJUnit.assertTrue(rp1.registrationPageHeader().isDisplayed());
		
	}
	
	@And("^Fill details: Title, Name, Email, Password, Date of birth$")
	public void Fill_details_Title_Name_Email_Password_Date_of_birth() {
		
		rp1.titleRegister().click();
		

		rp1.passwordRegister().sendKeys(prop.getProperty("RegisterPwd"));
		

		Select select = new Select(rp1.daysDOB());
		select.selectByValue(prop.getProperty("DayDOB"));
		
		Select select1 = new Select(rp1.monthsDOB());
		select1.selectByIndex(10);
		
		Select select2 = new Select(rp1.yearsDOB());
		select2.selectByVisibleText(prop.getProperty("YearDOB"));
		
	}
	
	@And("^Select checkbox 'Sign up for our newsletter!'$")
	public void Select_checkbox_Sign_up_for_our_newsletter() {
		
		rp1.newsletterCheckUncheck().click();
		
	}
	
	@And("^Select checkbox 'Receive special offers from our partners!'$")
	public void Select_checkbox_Receive_special_offers_from_our_partners() {
		
		rp1.offersCheckUncheck().click();
		
	}
	
	@And("^Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number$")
	public void Fill_details_First_name_Last_name_Company_Address_Address2_Country_State_City_Zipcode_Mobile_Number() {
		
		rp1.firstNameAddress().sendKeys("abc");
		
		rp1.lastNameAddress().sendKeys("xyz");
		
		rp1.companyAddress().sendKeys("abcXYZ");
		
		rp1.address1Address().sendKeys("24");
		
		rp1.address2Address().sendKeys("The Boulevard");
		
		Select select3 = new Select(rp1.countryAddress());
		select3.selectByValue("Canada");
		
		rp1.stateAddress().sendKeys(prop.getProperty("State"));

		rp1.cityAddress().sendKeys(prop.getProperty("City"));

		rp1.zipcodeAddress().sendKeys(prop.getProperty("ZipCode"));

		rp1.mobileNumberAddress().sendKeys(prop.getProperty("MobileNumber"));
		
	}
	
	@And("^Click 'Create Account button'$")
	public void Click_Create_Account_button() {
		
		rp1.createAccountCTA().click();
		
	}
	
	@Then("^Verify that 'ACCOUNT CREATED!' is visible")
	public void Verify_that_ACCOUNT_CREATED_is_visible() {
		
		AssertJUnit.assertTrue(rp1.accountCreated().isDisplayed());
		
	}
	
	@And("^Click 'Continue' button$")
	public void Click_Continue_button() {
		
		rp1.continueCreated().click();

		
	}
	
//	@Then("^Verify that 'Logged in as username' is visible$")
//	public void Verify_that_Logged_in_as_username_is_visible() {
//		
//		rup = new RegisteredUserPage(driver);
//		
//		String expectedText = rup.registeredUserText().getText();
//		
//		System.out.println(expectedText);
//
//		
//		AssertJUnit.assertEquals(expectedText, "Logged in as Mohammad Ummar");
//
//		
//	}
//	
	@And("^Click 'Delete Account' button$")
	public void Click_Delete_Account_button() {
		
		RegisteredUserPage rup = new RegisteredUserPage(driver);
		rup.deleteAccountCTA().click();

		
	}
	
	@Then("^Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button$")
	public void Verify_that_ACCOUNT_DELETED_is_visible_and_click_Continue_button() {
		
		AccountDeletedPage adp = new AccountDeletedPage(driver);
		AssertJUnit.assertTrue(adp.accountDeletedText().isDisplayed());
		
		adp.continueCTA().click();
		
	}
	
}
