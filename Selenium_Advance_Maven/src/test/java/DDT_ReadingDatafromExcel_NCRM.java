import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

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

public class DDT_ReadingDatafromExcel_NCRM {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//Create a java representation object of physical file
				FileInputStream fis=new FileInputStream("C:\\Users\\anjal\\Desktop\\DDT Files\\ninzacrm.properties.txt");

				//Create an object of properties class
				Properties prop=new Properties();
				
				//load all the keys in properties file
				prop.load(fis);
				
				//Extract the value using key name
				String browser = prop.getProperty("browser");
				String url = prop.getProperty("url");
				String username = prop.getProperty("username");
				String password = prop.getProperty("password");
				
				System.out.println(url);
				
				//cross browser testing
				WebDriver driver=null;
				if(browser.equalsIgnoreCase("chrome")) {
					driver=new ChromeDriver();
				}
				else if(browser.equalsIgnoreCase("edge")) {
					driver=new EdgeDriver();
				}
				else if(browser.equalsIgnoreCase("firefox")) {
					driver=new FirefoxDriver();
				}
				else {
					driver=new ChromeDriver();
				}
				
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
				driver.get(url);
				driver.findElement(By.id("username")).sendKeys(username);
				driver.findElement(By.id("inputPassword")).sendKeys(password);
				driver.findElement(By.xpath("//button[contains(text(),'Sign In')]")).click();
				//driver.close();
				
				driver.findElement(By.xpath("//span[contains(text(),'Create Campaign')]")).click();
				//Reading from excel
				
				//Create the java representation object of the physical file
				FileInputStream fis2=new FileInputStream("C:\\Users\\anjal\\Desktop\\DDT Files\\CampaignDetails.xlsx");
				
				//Open the workbook in read mode
				Workbook wb = WorkbookFactory.create(fis2);
				
				//Get control of the sheet
				
				Sheet sh = wb.getSheet("Sheet1");
				
				//get the control of entire row
				
				Row r = sh.getRow(1);
				
				//get the cell value
				
				String campaignname = r.getCell(0).toString();
				  String targetsize = r.getCell(1).getStringCellValue();
				String cpnstatus = r.getCell(2).toString();
				String targetaudience = r.getCell(3).toString();
				//String description = r.getCell(4).toString();
				
				Random random=new Random();
				int randomint = random.nextInt(1000);
				
				
				
				System.out.println(campaignname);
				System.out.println(targetsize);
				
				driver.findElement(By.name("campaignName")).sendKeys(campaignname+randomint);
				WebElement t_size = driver.findElement(By.name("targetSize"));
				t_size.clear();
				t_size.sendKeys(targetsize);
				driver.findElement(By.name("campaignStatus")).sendKeys(cpnstatus);
				driver.findElement(By.name("targetAudience")).sendKeys(targetaudience);
				//WebElement des=driver.findElement(By.name("description"));
				//des.click();
				//des.sendKeys(description);
				driver.findElement(By.xpath("//button[contains(text(),'Create Campaign')]")).click();
				
				
				
				//validation
				

				
	}

}
