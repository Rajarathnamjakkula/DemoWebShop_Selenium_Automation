package com.testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	WebDriver driver;

	@FindBy(xpath = "//a[@class='ico-login']")
	WebElement LoginButton;

	@FindBy(id = "Email")
	WebElement usermail;

	@FindBy(name = "Password")
	WebElement pwd;

	@FindBy(css = "input[type='checkbox']")
	WebElement checkbox;

	@FindBy(xpath = "//input[@class='button-1 login-button']")
	WebElement submitButton;
	
	@FindBy(xpath = "//li//a")
	WebElement successMsg;
	
	@FindBy(xpath = "//div[@class='validation-summary-errors']//ul//li")
	WebElement credentialsMisMatch;
	
	@FindBy(xpath = "//span[@for='Email']")
	WebElement InvalidUsermail;
	
	
	public Login(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	String Login (String mail,String password) {
		LoginButton.click();
		this.usermail.sendKeys(mail);
		this.pwd.sendKeys(password);
		checkbox.click();
		submitButton.click();
		return successMsg.getText();
	}
		
		String InvalidCredentialsLogin(String mail,String password) {
			LoginButton.click();
			this.usermail.sendKeys(mail);
			this.pwd.sendKeys(password);
			checkbox.click();
			submitButton.click();
			return credentialsMisMatch.getText();
		}
		
		
		String InvalidMail_id(String mail_id) {
			LoginButton.click();
			this.usermail.clear();
			this.usermail.sendKeys(mail_id);
			this.pwd.click();
			return InvalidUsermail.getText();
			
		}
		
		
		
	}


