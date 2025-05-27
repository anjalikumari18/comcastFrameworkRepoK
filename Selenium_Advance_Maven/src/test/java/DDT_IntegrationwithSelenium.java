import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class DDT_IntegrationwithSelenium {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//Precondition: Keep common data and test script data inside same folder, 
		//change data in excel to run this file
		
		//Read common data from properties file
		
		//Step:1 Get the java representation object of the physical file
		FileInputStream fis=new FileInputStream("C:\\Users\\anjal\\OneDrive\\Desktop\\Framewo\\seleniumintegrationdata\\DDT_Propertiesfile.properties");
				
		//Step:2 Using Properties class, load all the key
		Properties pObj=new Properties();
		pObj.load(fis);
		
		//Step:3 Get value based on key
		String browser = pObj.getProperty("browser");
		String url = pObj.getProperty("url");
		String user = pObj.getProperty("username");
		String pass = pObj.getProperty("password");
		String orgname = pObj.getProperty("orgname");
		
		//generate the random number
		Random randominteger=new Random();
		int random = randominteger.nextInt(1000);
		
		//read test script data from excel file
	    FileInputStream fis2=new FileInputStream("C:\\Users\\anjal\\OneDrive\\Desktop\\Framewo\\seleniumintegrationdata\\DDT_Excelfile1.xlsx");
        
		//Open WorkBook in read mode   
         Workbook wb = WorkbookFactory.create(fis2);
        
        //SGet the control of sheet
        Sheet sh = wb.getSheet("org");
        
        
        // Get control of the first row
        Row r1 = sh.getRow(1);
        
        //Get control of the second cell
        String cellval = r1.getCell(2).toString()+random;
        System.out.println(cellval);
		
		
		
		WebDriver driver=null;
		if(browser.equals("chrome")) {
			driver=new ChromeDriver();
		}else if(browser.equals("firefox")){
			driver=new FirefoxDriver();
		}
		else if(browser.equals("firefox")){
		    driver=new EdgeDriver();
		}
		else {
			driver=new ChromeDriver();

		}
		
		//Step 1: Login to app
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(user);
		driver.findElement(By.name("user_password")).sendKeys(pass);
		driver.findElement(By.id("submitButton")).click();
		
		//Step 2: Navigate to Organization module
		driver.findElement(By.linkText("Organizations")).click();
		
		//Step 3: Click on 'Create Organization' button
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		//Step 4: Enter all details and create organisation
		//reading by properties file
		//driver.findElement(By.name("accountname")).sendKeys(orgname);
		
		//reading by excel
		driver.findElement(By.name("accountname")).sendKeys(cellval);

		
		
		//Step 5: Click on Save button
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")).click();
		
		//Step 6: Logout
		WebElement admin=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act=new Actions(driver);
		act.moveToElement(admin).perform();
		driver.findElement(By.partialLinkText("Sign Out")).click();
		

	}

}
