package base;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import factory.DriverFactory;
import utils.ConfigReader;      

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setup() {

        driver = DriverFactory.initDriver();
    	//driver=new ChromeDriver();
    	

        driver.manage().window().maximize();
        driver.manage().timeouts()
              .implicitlyWait(java.time.Duration.ofSeconds(ConfigReader.getImplicitWait()));

        driver.get("https://demowebshop.tricentis.com/");
       // driver.get(ConfigReader BaseUrl());
    }

    @AfterMethod
    public void tearDown() {
    	//if(driver!= null) {
        driver.quit();
   // }
}
}

