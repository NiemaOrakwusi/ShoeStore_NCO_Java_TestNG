package com.com.PageObjects;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class EmailCheck {
	
protected WebDriver dr;
protected By emailTxBx	= By.id("remind_email_input");
protected By errMsTxt = By.xpath("//html//body//div[4]//div");
protected By sendEm = By.xpath("//input[contains(@id,'remind_email_input')]");
protected By sendbtn = By.xpath("//input[contains(@type,'submit')]");
protected By mes = By.xpath("//div[contains(@class,'flash notice')]");

	public EmailCheck(WebDriver dr) {
		this.dr = dr;
	}//end EmailCheck
	
	public String getTitle () {
		String title = dr.getTitle();
		return title;
	}//end getTitle
	
	public boolean verPageTitle() {
		String titles = "Shoe Store: Welcome to the Shoe Store";
		return getTitle().contains(titles);
	}//end verPageTitle
	
	public void emailEntry(String emailAddress) {
		
		WebElement enterEmail = dr.findElement(emailTxBx);
		
		if (enterEmail.isDisplayed())
			enterEmail.sendKeys(emailAddress);	
		
	}//end emailEntry
	
	public boolean VfyEmail() {
		emailEntry("emailaddress@yahoo.com");
		emSen();
		dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return getMesg().contains("emailaddress@yahoo.com");
		
		
	}//end VfyEmail
	
	public void SenEmail() {
		WebElement sen = dr.findElement(sendEm);
		if (sen.isDisplayed())
			sen.click();
	}//end SenEmail
	
	public void emSen() {
		WebElement sebtn = dr.findElement(sendbtn);
		if (sebtn.isDisplayed())
			sebtn.click();
	}// end emSen
	
	public String getMesg() {
		String msg = null;
		WebElement ms = dr.findElement(mes);
		if (ms.isDisplayed() && ms.isEnabled())
			msg = ms.getText();
		
		return msg;
		
	}//end getMesg
	
}

		