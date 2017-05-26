package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.Homepage;
import pages.Loginpage;
import utility.Helper;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import factory.Browserfactory;
import factory.Dataproviderfactory;

public class LoginpageReportsScreenshot 
{

	WebDriver driver;
	ExtentReports reports;
	ExtentTest logger;
	
	
	@BeforeMethod
	public void setUP()
	{
		reports=new ExtentReports("./Reports/loginrepot.html");		
		
		logger=reports.startTest("Verify the Test Login");
		
		driver=Browserfactory.getbrowser("firefox");

		driver.get(Dataproviderfactory.getconfig().getApplicationurl());
		
		logger.log(LogStatus.INFO,"Application is up on running");
		
	}
		
	@Test
	public void testhomepage()
	{
											
				Homepage home=PageFactory.initElements(driver, Homepage.class);
				
				String title=home.getapplicationtitle();
				
				Assert.assertTrue(title.contains("Demo Store"),"Title is Invalid");
				
				logger.log(LogStatus.PASS,"Home page loaded successfully");
				
				home.clicklogin();
				
				logger.log(LogStatus.INFO,"Login page present");
				
				Loginpage login=PageFactory.initElements(driver, Loginpage.class);
				
				login.loginapplication(Dataproviderfactory.getconfigexcel().getdata(0, 0, 0), Dataproviderfactory.getconfigexcel().getdata(0, 0, 1));
				
				logger.log(LogStatus.PASS, "Valid login crediential");
				
				login.verifysignout();
				
				logger.log(LogStatus.INFO,logger.addScreenCapture(Helper.capturescreenshot(driver, "validate 1")));
				
				logger.log(LogStatus.PASS,"Signout Successfully");
	}
	
	@AfterMethod
	public void teardown(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			
			String path=Helper.capturescreenshot(driver, result.getName());
			logger.log(LogStatus.FAIL, logger.addScreenCapture(path));
			
		}
			
		Browserfactory.closebrowser();
		
		reports.endTest(null);
		
		reports.flush();
		
	}
	
}

