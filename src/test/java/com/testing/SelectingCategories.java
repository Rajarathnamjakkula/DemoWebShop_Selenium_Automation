package com.testing;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SelectingCategories {
	

	WebDriver driver;
	
	@Test
	void selectCategories() {
		String []categories= {"Books","Computers","Electronics","Apparel & Shoes","Digital downloads","Jewelry","Gift Cards"};
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
		WebElement category = driver.findElement(By.xpath("//ul[@class='list']//li[4]//a"));
		category.getText();
		if(category.getText().equalsIgnoreCase(categories[0])) {
			category.click();
		}
		
//		List<WebElement> categories = driver.findElements(By.xpath("//div[@class='header-menu']//ul//li//a"));
//		System.out.println(categories.size());
		
	}

	

}
