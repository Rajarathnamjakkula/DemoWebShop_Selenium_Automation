package com.testing;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AddToCart {

	WebDriver driver;
	WebDriverWait wait;

	public AddToCart(WebDriver driver) {

		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='page-title']//h1")
	WebElement ProductCategory;

	@FindBy(xpath = "//div[@class='item-box']")
	List<WebElement> Products;

	@FindBy(xpath = "//div[@class='item-box']//div[@class='buttons']")
	List<WebElement> AddToCartButton;

	@FindBy(xpath = "//div[@id='bar-notification']")
	WebElement successMessage;

	@FindBy(id = "small-searchterms")
	WebElement SearchBar;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement SearhButton;

	@FindBy(xpath = "//input[@value='Add to cart']")
	List<WebElement> CartButton;

	@FindBy(xpath = "//strong[@class='result']")
	WebElement ErrorMsg;

	public String SelectedCategory() {

		return ProductCategory.getText();

	}

	public void ProductList() {

		System.out.println(Products.size());
		for (int i = 0; i < Products.size(); i++) {

			String ProductName = Products.get(i).getText();
			System.out.println(ProductName);

			Products.get(i).click();
			driver.navigate().back();
		}

	}

	public void addAllProductsToCart() {

		for (int i = 0; i < Products.size(); i++) {

			try {

				WebElement product = Products.get(i);

				String productName = product.findElement(By.xpath(".//h2[@class='product-title']")).getText();

				List<WebElement> button = product.findElements(By.xpath(".//input[@value='Add to cart']"));

				if (button.size() > 0) {

					wait.until(ExpectedConditions.elementToBeClickable(button.get(0)));
					button.get(0).click();

					wait.until(ExpectedConditions.visibilityOf(successMessage));

					System.out.println(productName + " added to cart");

				} else {

					System.out.println(productName + " button not available");

				}

			} catch (StaleElementReferenceException e) {

				System.out.println("Element refreshed, retrying...");

			}
		}

	}

	public void AddToCartButtonFromSearchBox(String inputData) {

		SearchBar.clear();
		SearchBar.sendKeys(inputData);
		SearhButton.click();
		if (CartButton.size() > 0) {

			CartButton.get(0).click();

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

			String msg1 = wait.until(ExpectedConditions.visibilityOf(successMessage)).getText();
			System.out.println(msg1);
			Assert.assertTrue(msg1.contains("The product has been added "));

		} else {

			System.out.println("Product not found: " + ErrorMsg.getText());

		}

	}

}
