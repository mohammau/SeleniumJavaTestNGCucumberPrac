package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;



public class Base {
	
	public WebDriver driver ;
	public Properties prop ;
	
	
	public WebDriver initializeDriver() throws IOException {				
				
		prop = new Properties();
		
	
		String propPath = System.getProperty("user.dir") + "//src//main//java//resources//data.properties";
		FileInputStream FIS = new FileInputStream(propPath);
		
		prop.load(FIS);
		
		String Browser = prop.getProperty("Browser");
		
		if(Browser == null) {
			
			throw new RuntimeException("BROWSER property is not set in data.properties");
		}
		
		switch(Browser.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break ;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		default:
			throw new IllegalArgumentException("Invalid browser name = " + Browser);
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;

	}
	
	public String screenshotCapture(String testName, WebDriver driver) throws IOException {
		
	File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	String destinationFilePath = System.getProperty("user.dir") + "//screenshots//"+testName+".png";
	FileUtils.copyFile(source, new File(destinationFilePath));
	
	return destinationFilePath ;
	
	}
	
	
	

}
