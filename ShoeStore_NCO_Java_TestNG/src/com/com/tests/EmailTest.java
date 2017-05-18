package com.com.tests;

import org.testng.annotations.Test;

import com.com.PageObjects.EmailCheck;
import com.com.Setup.SetUp;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

public class EmailTest extends SetUp {
	
private WebDriver dr;
	
	
	
	@BeforeClass
	public void setUp() {
		dr = getDr();
	}//end setUp
	
	@Test
	public void verPageTitle() {
		
		EmailCheck itemCheck = new EmailCheck(dr);
		Assert.assertTrue(itemCheck.verPageTitle(), "Page Title is not correct");
		System.out.println("Page Title is displayed");
		
	}// end verPageTitle
	
	@Test
	public void VfyEmail() {
		EmailCheck email = new EmailCheck(dr);
		
		dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Assert.assertTrue(email.VfyEmail(), "Email not present");
		System.out.println("Page Email is displayed");
		
	}//end VfyEmail

}
