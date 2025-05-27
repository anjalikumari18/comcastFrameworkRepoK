package GenericUtility;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import generic.fileutility.ExcelUtility;
import generic.fileutility.JsonUtility;
import generic.fileutility.PropertyFileutility;
import generic.webDriverUtility.JavaUtility;
import generic.webDriverUtility.WebDriverUtility;

public class GU_implementation_CreateCampaign {

	public static void main(String[] args) throws IOException, ParseException {
		// TODO Auto-generated method stub
		
		//Test case 01-Navigate to Ninza CRM>> Create Campaign with mandatory field.
			
		        PropertyFileutility pfu=new PropertyFileutility();
		       
				String browser =  pfu.getDataFromPropertiesFile("browser");
				String url = pfu.getDataFromPropertiesFile("url");
				
				JsonUtility ju=new JsonUtility();
				
				String username = ju.getDataFromJsonFile("username");
			    String password = ju.getDataFromJsonFile("password");
			    

		        //cross-browser testing
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
				WebDriverUtility wbu=new WebDriverUtility();
				wbu.waitForPageToLoad(driver);
				//Passing the url as key
				driver.get(url);
				
				//Input the username
				driver.findElement(By.id("username")).sendKeys(username);
				//input the password
				driver.findElement(By.id("inputPassword")).sendKeys(password);
				//click on sign in button
				driver.findElement(By.xpath("//button[contains(text(),'Sign In')]")).click();
				driver.findElement(By.xpath("//span[text()='Create Campaign']")).click();
				
				JavaUtility javau=new JavaUtility();
				int rn = javau.getRandomNumber();

				
				//excel utility
				ExcelUtility eu=new ExcelUtility();
				String cname = eu.getDataFromExcel("Sheet1", 1, 0);
				String tsize = eu.getDataFromExcel("Sheet1", 1, 1);
				
				
				//enter the campaign name
				driver.findElement(By.name("campaignName")).sendKeys(cname+rn);
				
				//enter the target size
				WebElement targettextfield = driver.findElement(By.name("targetSize"));
				targettextfield.clear();
				targettextfield.sendKeys(tsize+rn);
				
				//click on create campaign button
				driver.findElement(By.xpath("//button[text()='Create Campaign']")).click();
				
				eu.setDataIntoExcel("Sheet1", 1, 2,"Passed");

				
				//driver.close();

	
	
	
}}