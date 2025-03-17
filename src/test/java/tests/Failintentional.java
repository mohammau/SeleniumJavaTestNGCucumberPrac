package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import resources.Base;

import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;

import java.io.IOException;



public class Failintentional extends Base {
	
	
	public WebDriver driver ;
	@Test
	public void failedTest() throws IOException {
		
		driver = initializeDriver();
		
		driver.get(prop.getProperty("URL"));
		
		AssertJUnit.assertTrue(false);
	}
	

	
	@AfterMethod
	public void tearDown() {
		
		driver.close();

}}
