package com.testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Registration {

	WebDriver driver;
	@FindBy(xpath = "//a[@class='ico-register']")
	WebElement registrationlink;

	@FindBy(css = "input[class='text-box single-line']")
	WebElement firstname;

	@FindBy(xpath = "//div [@class='inputs'][3]//input[@type='text']")
	WebElement lastname;

	@FindBy(name = "Email")
	WebElement mailid;

	@FindBy(id = "Password")
	WebElement password;

	@FindBy(id = "ConfirmPassword")
	WebElement ConfirmPassword;

	@FindBy(id = "register-button")
	WebElement button;

	@FindBy(xpath = "//li//a")
	WebElement successMsg;

	@FindBy(xpath = "//div[@class='validation-summary-errors']//li")
	WebElement errorMsg;
	
	@FindBy(xpath="//span[@for='Email']")
	WebElement impropermail;
	
	@FindBy(xpath="//span[@for='FirstName']")
	WebElement mandatorymsg;
	
	

	public Registration(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	String newRegistration(String firstname, String lastname, String mail, String password, String confirmpassword) {

		registrationlink.click();
		this.firstname.sendKeys(firstname);
		this.lastname.sendKeys(lastname);
		this.mailid.sendKeys(mail);
		this.password.sendKeys(password);
		this.ConfirmPassword.sendKeys(confirmpassword);
		button.click();
		return successMsg.getText();

	}

	String existingUser(String firstname2, String lastname2, String mail, String password2, String confirmpassword2) {
		registrationlink.click();
		this.firstname.sendKeys(firstname2);
		this.lastname.sendKeys(lastname2);
		this.mailid.sendKeys(mail);
		this.password.sendKeys(password2);
		this.ConfirmPassword.sendKeys(confirmpassword2);
		button.click();
		return errorMsg.getText();

	}
	String impropermailid(String impropermail_id) {
		registrationlink.click();
		this.mailid.sendKeys(impropermail_id);
		button.click();
		return impropermail.getText();
		
	}
	
	public String mandatoryfield (String blank) {
		registrationlink.click();
		this.firstname.clear();
		this.firstname.sendKeys(blank);
		button.click();
		
		return mandatorymsg.getText();
		
	}

}
