package com.testing;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;

public class CategoriesPageTesting extends BaseTest{
	
	CategoriesPage cat;
	
	@BeforeMethod
	void pageSetup() {
		cat=new CategoriesPage(driver);
		
	}
	
	 @Test
	    public void verifyProductCategories() {
		 
		

	       cat.clickAllCategories();
	        
	    }
	 
	 @Test
	 public void verifySelectedCategory() {

	     cat.clickCategory("Books");

	     String currentUrl = driver.getCurrentUrl();
	     System.out.println(currentUrl);

	     Assert.assertTrue(currentUrl.contains("books"));
	 }
	}

//	 @Test
//	    public void verifyProductCategories() throws InterruptedException {
//
//	        CategoriesPage page = new CategoriesPage(driver);
//	        page.clickAllCategories();
//	    }


