package CRM_Testcase;
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

public class DDT_WriteintoExcel_NCRM {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		
		FileInputStream fis=new FileInputStream("C:\\Users\\anjal\\Desktop\\DDT Files\\CampaignDetails.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);
		
		Sheet sh = wb.getSheet("Sheet1");
		
		Row r = sh.getRow(1);
		
		Cell cell = r.createCell(5);
		
		cell.setCellType(CellType.STRING);
		cell.setCellValue("PASS");
		
		
		//Writing into excel
		FileOutputStream fos=new FileOutputStream("C:\\Users\\anjal\\Desktop\\DDT Files\\CampaignDetails.xlsx");
		wb.write(fos);
		wb.close();
		System.out.println("executed");
		
		

	}

}
