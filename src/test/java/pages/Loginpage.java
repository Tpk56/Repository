package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Loginpage 
{

	WebDriver driver;
	
	public Loginpage(WebDriver ldriver)
	{
		
		this.driver=ldriver;
		
	}
	
	@FindBy(id="account_sign_in_form_email_id")WebElement username;
	@FindBy(id="account_sign_in_form_passwd_id")WebElement password;
	@FindBy(xpath="//input[@value='Log In']")WebElement siginbutton;
	
	By signout=By.xpath("//a[text()='Sign Out']");
	
	
	public void loginapplication(String uname,String pass)
	{
		username.sendKeys(uname);
		password.sendKeys(pass);
		siginbutton.click();
		
	}
	
	public void verifysignout()
	{
		WebDriverWait wait=new WebDriverWait(driver, 20);
		
		WebElement ele=wait.until(ExpectedConditions.presenceOfElementLocated(signout));
		
		String title=ele.getText();
		
		Assert.assertEquals(title, "Sign Out","Thsi is Invalid Title"); 
		
		
	}
}
