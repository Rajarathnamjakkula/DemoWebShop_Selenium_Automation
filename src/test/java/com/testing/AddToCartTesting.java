package com.testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import base.CommonDataProvider;

public class AddToCartTesting extends BaseTest {
	WebDriver driver;
	AddToCart cart;

	@BeforeMethod
	void pageSetup() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/books");

		cart = new AddToCart(driver);

	}

	@Test
	public void verifySelectedCategory() {

		cart.SelectedCategory();

		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);

		String SelectedCategorypage = cart.ProductCategory.getText();
		System.out.println(SelectedCategorypage);
		Assert.assertTrue(currentUrl.toLowerCase().contains(SelectedCategorypage.toLowerCase()));
	}

	@Test
	public void VerifingProductList() {
		cart.ProductList();

	}

	@Test
	public void verifyAddToCartProducts() {

		cart.addAllProductsToCart();
	}

	@Test(dataProvider = "SearchData", dataProviderClass = CommonDataProvider.class)
	public void VerifyAddToCartButtonFromSearchBox(String inputData) {

		cart.AddToCartButtonFromSearchBox(inputData);

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}

}
