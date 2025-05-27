import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class testing_prop_excel {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		FileInputStream fis=new FileInputStream("file path");
		
		Properties prop=new Properties();
		
	    prop.load(fis);
	    
	    prop.getProperty("key");
	    
	    String browser = prop.getProperty("key");
	    WebDriver driver=null;
	    
	    if (browser.equalsIgnoreCase("chrome")) {
		driver=new ChromeDriver();
	    }else if(browser.equalsIgnoreCase("firefox")) {
	    	driver=new FirefoxDriver();
	    }else if(browser.equalsIgnoreCase("edge")) {
	    	driver=new EdgeDriver();
	    }
	    else {
	    	driver=new ChromeDriver();
	    }

	    Workbook wb = WorkbookFactory.create(fis);
	   Sheet sh = wb.getSheet("sheetname");
	    Row r1 = sh.getRow(0);
	    Cell c1 = r1.createCell(0);
	    c1.setCellType(CellType.STRING);
	    c1.setCellValue("Pass");
	    
	    FileOutputStream fos=new FileOutputStream("file path");
	    wb.write(fos);
	    wb.close();
	    
	}

	
}
