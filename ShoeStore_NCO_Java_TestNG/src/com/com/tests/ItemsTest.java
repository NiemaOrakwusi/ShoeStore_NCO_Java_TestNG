package com.com.tests;

import org.testng.annotations.Test;
import com.com.PageObjects.ItemCheck;
import com.com.Setup.SetUp;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;


public class ItemsTest extends SetUp {
	
	private WebDriver dr;
	
	@BeforeClass
	public void setUp() {
		dr = getDr();
	}// end setUp
	
	@Test
	public void verPageItems() {
		
		ItemCheck itemCheck = new ItemCheck(dr);
		Assert.assertTrue(itemCheck.verPageTitle(), "Page Title is not correct");
		System.out.println("Page Title is displayed");
		
	}//end verPageItems
	
	@Test
	public void verDesp() {
		ItemCheck itemCheck = new ItemCheck(dr);
		Assert.assertTrue(itemCheck.verDesp(), "Page Desc is not available");
		System.out.println("Page Description is displayed");
	}//end verDesp
	
	@Test
	public void verPrice() {
		ItemCheck itemCheck = new ItemCheck(dr);
		Assert.assertTrue(itemCheck.verPrice(), "Page Price is not available");
		System.out.println("Page Price is displayed");
	}//end verPrice
	
	@Test
	public void verImages() {
		ItemCheck itemCheck = new ItemCheck(dr);
		Assert.assertTrue(itemCheck.verImages(), "Page Image is not available");
		System.out.println("Page Image is displayed");
	}//end verImages
	
}
