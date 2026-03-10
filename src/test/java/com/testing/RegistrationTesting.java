package com.testing;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import base.CommonDataProvider;

public class RegistrationTesting extends BaseTest {

	Registration reg;

	@BeforeMethod
	public void setupPage() {
		reg = new Registration(driver);

	}

//	@DataProvider(name = "inputs")
//	Object[][] getinputs() {
//		return new Object[][] { { "jk", "raja", "raja@gmail01.com", "1234567", "1234567" } };
//	}

	@Test(dataProvider = "LoginData",dataProviderClass = CommonDataProvider.class)
	public void newreg(String firstname, String lastname, String mail, String password, String confirmpassword) {
		reg.newRegistration(firstname, lastname, mail, password, confirmpassword);
		String str = reg.successMsg.getText();
		Assert.assertEquals(str, mail);
		
	    TestData.email = mail;
	    TestData.password = password;
		
	}

	@DataProvider(name = "existinginputs")
	Object[][] getexistinginputs() {
		return new Object[][] { { "jk", "raja", "raja@gmail0q.com", "1234567", "1234567" },
				{ "j", "rathnam", "rathnam@gmailq.com", "qwerty", "qwerty" },
				{ "j", "rathnam", "rathnam@gmailw.com", "qwerty", "qwerty" },
				{ "raja", "rathnam", "rajarathname@gmail.com", "qwertyjkl", "qwertyjkl" } };
	}

	@Test(dataProvider = "existinginputs")
	public void existuser(String firstname2, String lastname2, String mail2, String password2,
			String confirmpassword2) {
		reg.existingUser(firstname2, lastname2, mail2, password2, confirmpassword2);
		String str2 = reg.errorMsg.getText();
		Assert.assertEquals(str2, "The specified email already exists");

	}

	@DataProvider(name = "wrong_mail_id")
	Object[][] getwrong_mail_id() {
		return new Object[][] { { "12345" }, { "rajakaka@gmail" }, { "raja.com" } };
	}

	@Test(dataProvider = "wrong_mail_id")
	public void wrongmail(String impropermail_id) {
		reg.impropermailid(impropermail_id);
		String str3 = reg.impropermail.getText();
		Assert.assertEquals(str3, "Wrong email");

	}
	
	@Test
	public void verifyMandatoryField() {
		
		String str4=reg.mandatoryfield("");
		Assert.assertEquals(str4, "First name is required.");
	}
	
	

}

//WebDriver driver ;

//
//@BeforeTest
//void getDriver() {
//	driver=new ChromeDriver();
//	driver.manage().window().maximize();
//	driver.get("https://demowebshop.tricentis.com/");
//	
//	
//}
//
//@AfterTest
//void teardown() {
//	driver.close();
//}
//

//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.get("https://demowebshop.tricentis.com/");
//
//		driver.findElement(By.xpath("//a[@class='ico-register']")).click();
//		String firstname = "Raja";
//		String lastname = "Rathnam";
//		String email = "rajarathnamjakkuala@2001.com";
//		String password = "R@j@1234";
//
//		driver.findElement(By.cssSelector("input[class='text-box single-line']")).sendKeys(firstname);
//		driver.findElement(By.xpath("//div [@class='inputs'][3]//input[@type='text']")).sendKeys(lastname);
//		driver.findElement(By.name("Email")).sendKeys(email);
//		driver.findElement(By.id("Password")).sendKeys(password);
//		driver.findElement(By.id("ConfirmPassword")).sendKeys(password);
////		Alert alert = driver.switchTo().alert();
////		alert.accept();
//		driver.findElement(By.id("register-button")).click();
