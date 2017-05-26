package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataprovider 
{

	Properties pro;
	public ConfigDataprovider()
	{
		File src=new File("./Configuration/Config.properties");
		
		try {
			
			FileInputStream fis=new FileInputStream(src);
			
			pro=new Properties();
			
			pro.load(fis);
			
			
		} 
		catch (Exception e) 
		{
		
			System.out.println("The Exception is "+e.getMessage());
			
		}
			
	}	
	public String getApplicationurl()
	{
	
		String url=pro.getProperty("url");
		return url;
	}
	
	public String getchromepath()
	{
	
		String url=pro.getProperty("chromepath");
		return url;
	}
	
	public String getoperapath()
	{
	
		String url=pro.getProperty("operapath");
		return url;
	}
	public String getfirefoxpath()
	{
	
		String url=pro.getProperty("firefox");
		return url;
	}
	
}

