package com.testing;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoriesPage {
	WebDriver driver;

	public CategoriesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "ul.list")
	List<WebElement> categories;

	public void clickAllCategories() {
		System.out.println(categories.size());
		for (int i = 0; i < categories.size(); i++) {

			String categoryName = categories.get(i).getText();
			System.out.println("Clicking: " + categoryName);

			categories.get(i).click();
			driver.navigate().back();
		}
	}

	public void clickCategory(String categoryName) {

		for (WebElement category : categories) {

			if (category.getText().equalsIgnoreCase(categoryName)) {
				category.click();
				
				break;
			}
		}

	}

}

//    public void clickAllCategories() throws InterruptedException {
//        for (WebElement category : categories) {
//            System.out.println("Clicking: " + category.getText());
//            category.click();
//            Thread.sleep(2000);
//            driver.navigate().back();
//        }
//    }
