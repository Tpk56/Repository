package utility;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;



public class Helper 
{

	
	
	public static String capturescreenshot(WebDriver driver,String screenshotName)
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		
		File src=ts.getScreenshotAs(OutputType.FILE);
		
		String designation="C:\\Users\\ELCOT\\Desktop\\Eclipse Luna\\Com.HybrideFramework.com\\Screenshot"+screenshotName+System.currentTimeMillis() +".png";
		
		try {
			
			FileUtils.copyFile(src, new File(designation));
		} 
		catch (Exception e)
		{
			System.out.println("The Message is "+e.getMessage());
		}
		
		return designation;
	}
	
}
