package com.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import base.CommonDataProvider;

public class LoginTesting extends BaseTest {

	Login log;

	@BeforeMethod
	void pageSetup() {
		log = new Login(driver);

	}

	@Test(dataProvider = "LoginData", dataProviderClass = CommonDataProvider.class)
	public void Successlogin(String mail, String password) {

		log.Login(mail, password);
		String regmail_id = log.successMsg.getText();
		Assert.assertEquals(regmail_id, mail);

	}
	
	@Test(dataProvider="InvalidCredentialsData", dataProviderClass=CommonDataProvider.class)
	
	public void InvalidLogin(String mail,String password) {
		log.Login(mail, password);
		String MisMatchMsg =log.credentialsMisMatch.getText();
		Assert.assertEquals(MisMatchMsg, "The credentials provided are incorrect");
	}
	
	@Test(dataProvider="wrong_mail_id",dataProviderClass=CommonDataProvider.class)
	
	public void InvalidMail_id(String mail) {
		log.InvalidMail_id(mail);
		String WrongmailMsg =log.InvalidUsermail.getText();
		Assert.assertEquals(WrongmailMsg, "Please enter a valid email address.");
	}

}
//		String email = "rajarathnamjakkuala@2001.com";
//String password = "R@j@1234";
//driver = new ChromeDriver();
//driver.manage().window().maximize();
//driver.get("https://demowebshop.tricentis.com/");
//
//driver.findElement(By.xpath("//a[@class='ico-login']")).click();
//driver.findElement(By.id("Email")).sendKeys(email);
//driver.findElement(By.name("Password")).sendKeys(password);
//driver.findElement(By.cssSelector("input[type='checkbox']")).click();
//driver.findElement(By.xpath("//input[@class='button-1 login-button']")).click();
