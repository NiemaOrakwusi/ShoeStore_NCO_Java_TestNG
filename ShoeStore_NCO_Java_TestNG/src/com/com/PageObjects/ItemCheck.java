package com.com.PageObjects;


import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ItemCheck {
	
	protected WebDriver dr;
	protected By displ	= By.linkText("All Shoes");
	protected By prices = By.className("shoe_price");
	protected By descr = By.className("shoe_description");
	protected By itm = By.xpath("//table/tbody/tr[6]/td[1]");
	
	public ItemCheck(WebDriver dr) {
		this.dr = dr;
	}//end ItemCheck
	
	public String getTitle () {
		String title = dr.getTitle();
		return title;
	}//end getTitle
	
	public boolean verPageTitle() {
		String titles = "Shoe Store: Welcome to the Shoe Store";
		
		return getTitle().contains(titles);
	}//end verPageTitle
	
		
	public boolean verDesp() {
		String isd = dr.findElements(descr).toString();
		return getDesc().contains(isd);
	}//end verPageTitle
	
	public boolean verPrice() {
		String isp = dr.findElements(prices).toString();
		return getPrice().contains(isp);
	}//end verPagePrice
	
	public boolean verImages() {
		String isI = dr.findElements(itm).toString();
		return getImages().contains(isI);
	}//end verPagePrice
	
	
	public void displayTxt() {
		WebElement dsTxt = dr.findElement(displ);
		if (dsTxt.isDisplayed())
			dsTxt.click();
	}//end displayTxt
	
	
	public String getDesc() {
		
		displayTxt();
		List<WebElement> dk = dr.findElements(descr);
		
		return dk.toString();

	}//end getDesp
	
	public String getPrice() {
		
		displayTxt();
		List<WebElement> price = dr.findElements(prices);
		
		return price.toString();
	}// end getPrice
	
	public String getImages() {
		
		displayTxt();
		List<WebElement> ImageFile = dr.findElements(itm);
		
		return ImageFile.toString();
	}// end getImages
	
}// end of Class
