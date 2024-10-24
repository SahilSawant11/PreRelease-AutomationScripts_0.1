package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dataForAllproperty {

	
	public static Object[][] getExcelData(String sheetName, String file_name) throws EncryptedDocumentException, IOException
	{
		ArrayList<String> list = new ArrayList<String>();
		int rowNo=0;
		int cellNo = 0;
		String data = "";
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\InputData\\"+file_name+".xlsx");
		
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet s = workbook.getSheet(sheetName);
		
		rowNo = s.getLastRowNum()+1;
		for(int i=1;i<rowNo;i++)
		{
			XSSFRow r = s.getRow(i);
			cellNo = r.getLastCellNum();
			for(int j=0;j<cellNo;j++)
			{

					XSSFCell c = r.getCell(j);
					if(c == null)
					{
						data="";
					}
					else
					{
						c.setCellType(CellType.STRING);
						data = c.getStringCellValue();
					}
					
					list.add(data);
			}
		}
		
		Iterator<String> it = list.iterator();
		
		Object obj[][] = new Object[rowNo-1][cellNo];
		
		for(int i=0;i<rowNo-1;i++)
		{
			for(int j=0;j<cellNo;j++)
			{
				obj[i][j] = it.next();
			}
		}//p
		return obj;
	}
	
}
