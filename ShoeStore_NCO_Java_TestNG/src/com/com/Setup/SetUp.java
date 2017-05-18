package com.com.Setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class SetUp {

	private WebDriver dr;
	
	static String driverPath = "C:\\chromeDriver\";";
	
		 
public WebDriver getDr() {
		return dr;
	}
	
	private void setDr(String brwType, String apURL) {
		switch (brwType) {
		
		case "chrome" :
			dr = initChrDr(apURL);
			break;
		case "firefox":
			dr = initFireDr(apURL);
			break;
			
		default:
			
			System.out.println("Default browser is FireFox");
			dr = initFireDr(apURL);
		}
	}
	
	private static WebDriver initChrDr(String apURL) {
		System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe" );
		WebDriver dr = new ChromeDriver();
		dr.manage().window().maximize();
		dr.navigate().to(apURL);
		return dr;
	}
	
	private static WebDriver initFireDr(String apURL) {
		WebDriver dr = new FirefoxDriver();
		dr.manage().window().maximize();
		dr.navigate().to(apURL);
		return dr;
	}
	
	@Parameters({"brwType", "apURL"})
	@BeforeClass
	
	public void initSetup (String brwType, String apURL) {
	
		try {
				setDr(brwType, apURL);
		} catch (Exception e) {
			System.out.println("Error" + e.getStackTrace());
		}
	}
	
	@AfterClass
	public void End() {
		dr.close();
	}
}
