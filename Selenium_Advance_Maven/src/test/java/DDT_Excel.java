import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DDT_Excel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		
		
		//Step 1: Get excelpath location & java object of the physical Excel file
		FileInputStream fis=new FileInputStream("C:\\Users\\anjal\\Desktop\\DDT_Excelfile1.xlsx");
        
		//Step 2: Open WorkBook in read mode   
         Workbook wb = WorkbookFactory.create(fis);
        
        //Step 3: Get the control of sheet
        Sheet sh = wb.getSheet("org");
        
        
        //Step 4: Get control of the first row
        Row r1 = sh.getRow(1);
        
        //Step 5:Get control of the second cell
        String cellval = r1.getCell(3).toString();
        System.out.println(cellval);
        
        //Step 6: Close the WorkBook
        wb.close();
        
        
        
        
        //Step 1: Get the java represenatation object of the physical file
        FileInputStream fis1=new FileInputStream("Physical path");
        
        //Step 2: Open the workbook in read mode
        Workbook wb1 = WorkbookFactory.create(fis);
        
        //Step 3: Get control of the sheet
        Sheet sh1 = wb1.getSheet("sheet1");
        
        //Step 4:Get control of row by numbber
        Row r01 = sh1.getRow(0);
       
       //Step 5: Get cell control
        Cell c01 = r01.getCell(2);
        
        //Step 6: Get required cell value
       LocalDateTime cellvalw = c01.getLocalDateTimeCellValue();
        
        
   
   
	
        
       
	
	}

}
