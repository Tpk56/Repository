package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataprovider 
{

	XSSFWorkbook work;
	
	public ExcelDataprovider()
	{
		File src=new File("./ApplicationData/appdata.xlsx");
		
		try {
		
			FileInputStream fis=new FileInputStream(src);
			
			work=new XSSFWorkbook(fis);
		} 
		catch (Exception e) 
		{
			
			System.out.println("The Exception is :"+e.getMessage());
		}
		
	}
	
	public String getdata(int sheetnumber,int row,int column)
	{
		
		String data=work.getSheetAt(sheetnumber).getRow(row).getCell(column).getStringCellValue();
		return data;
	}
	
	public String getdata(String sheetName,int row,int column)
	{
		
		String data=work.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
		return data;
	}
	
	
}
