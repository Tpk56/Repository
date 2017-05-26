package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.Homepage;
import pages.Loginpage;
import factory.Browserfactory;
import factory.Dataproviderfactory;

public class VerifyLoginpage 
{

	WebDriver driver;
	
	@BeforeMethod
	public void setUP()
	{
		driver=Browserfactory.getbrowser("firefox");

		driver.get(Dataproviderfactory.getconfig().getApplicationurl());
		
	}
		
	@Test
	public void testhomepage()
	{
											
				Homepage home=PageFactory.initElements(driver, Homepage.class);
				
				String title=home.getapplicationtitle();
				
				Assert.assertTrue(title.contains("Demo Store"),"Title is Invalid");
				
				home.clicklogin();
				
				Loginpage login=PageFactory.initElements(driver, Loginpage.class);
				
				login.loginapplication(Dataproviderfactory.getconfigexcel().getdata(0, 0, 0), Dataproviderfactory.getconfigexcel().getdata(0, 0, 1));
				
				login.verifysignout();
				
	}
	
	@AfterMethod
	public void teardown()
	{
		Browserfactory.closebrowser();
		
	}
	
}

