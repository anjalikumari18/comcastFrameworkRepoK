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

public class DDT_Excel_writingdata {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		
		//To input value in cell 
		FileInputStream fis=new FileInputStream("C:\\Users\\anjal\\OneDrive\\Desktop\\Framewo\\DDT_Excel_datainputintoexcel.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
		Row row = sh.getRow(1);
		Cell cell = row.createCell(4);
		cell.setCellType(CellType.STRING);
		cell.setCellValue("PASSED");
		//if excel file is open it will throw FileNotFoundException
		//To open excel in write mode
		
		FileOutputStream fos=new FileOutputStream("C:\\Users\\anjal\\OneDrive\\Desktop\\Framewo\\DDT_Excel_datainputintoexcel.xlsx");
		wb.write(fos);
		wb.close();
		System.out.println("========Executed========");

	}

}
