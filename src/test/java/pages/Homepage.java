package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage 
{

	WebDriver driver;
	
	public Homepage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
	@FindBy(xpath="//div[@class='topheadrow']/ul/li[5]") WebElement login;
	@FindBy(xpath="//div[@class='topheadrow']/ul/li[2]") WebElement myaccount;
	@FindBy(xpath="//div[@class='topheadrow']/ul/li[3]") WebElement mycart;
	@FindBy(xpath="//div[@class='topheadrow']/ul/li[1]") WebElement homepage;
	
	public void clicklogin()
	{
		login.click();
		
	}

	public void clickmyaccount()
	{
		myaccount.click();
		
	}
	
	public void clickmycart()
	{
		mycart.click();
		
	}
	public void clickhomepage()
	{
		homepage.click();
		
	}
	
	public String getapplicationtitle()
	{
		return driver.getTitle();
		
	}
	
}

