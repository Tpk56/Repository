package factory;

import dataProvider.ConfigDataprovider;
import dataProvider.ExcelDataprovider;

public class Dataproviderfactory 
{

	public static ConfigDataprovider getconfig()
	{
		ConfigDataprovider config=new ConfigDataprovider();
		return config;
		
	}
	
	public static ExcelDataprovider getconfigexcel()
	{
		ExcelDataprovider config=new ExcelDataprovider();
		return config;
		
	}
}
