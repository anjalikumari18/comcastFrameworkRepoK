package generic.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
	public String getDataFromExcel(String sheet, int row, int cell) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis=new FileInputStream("./ConfigApp/CampaignDetails.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
	    String data = wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
	    return data;
	}
	
	public int getRowcount (String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./ConfigApp/CampaignDetails.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int rowCount = wb.getSheet(sheetName).getLastRowNum();
		return rowCount;
		
	}
	
	public void setDataIntoExcel(String sheetName,int rowNum, int celNum, String data) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis=new FileInputStream("./ConfigApp/CampaignDetails.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(rowNum).createCell(celNum).setCellValue(data);                                                                                                                                                                                                                                                                                                                                                                                                         	
		
		FileOutputStream fos=new FileOutputStream("./ConfigApp/CampaignDetails.xlsx");
		wb.write(fos);
		wb.close();
	}

}
