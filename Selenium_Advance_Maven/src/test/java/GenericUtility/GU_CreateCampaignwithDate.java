package GenericUtility;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import generic.fileutility.ExcelUtility;
import generic.fileutility.JsonUtility;
import generic.fileutility.PropertyFileutility;
import generic.webDriverUtility.JavaUtility;
import generic.webDriverUtility.WebDriverUtility;

public class GU_CreateCampaignwithDate {

	public static void main(String[] args) throws IOException, ParseException {
		// TODO Auto-generated method stub
		

		PropertyFileutility pfu=new PropertyFileutility();
		
		//Extract the value using key name
		String browser = pfu.getDataFromPropertiesFile("browser");
		String url = pfu.getDataFromPropertiesFile("url");
		
		JsonUtility ju=new JsonUtility();
		
		String username = ju.getDataFromJsonFile("username");
		String password = ju.getDataFromJsonFile("password");

		
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
		//Waiting for webdriver to load using WebDriver utility
		WebDriverUtility wbu=new WebDriverUtility();
		wbu.waitForPageToLoad(driver);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		driver.get(url);
	    JavaUtility javau=new JavaUtility();

	    int randomno = javau.getRandomNumber();
		
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("inputPassword")).sendKeys(password);


		//excel utility
		ExcelUtility eu=new ExcelUtility();
		String cname = eu.getDataFromExcel("Sheet1", 1, 0);
		String tsize = eu.getDataFromExcel("Sheet1", 1, 1);
		
		driver.findElement(By.xpath("//button[contains(text(),'Sign In')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Create Campaign')]")).click();

		
		//enter the campaign name
		driver.findElement(By.name("campaignName")).sendKeys(cname+randomno);
		
		//enter the target size
		WebElement targettextfield = driver.findElement(By.name("targetSize"));
		targettextfield.clear();
		targettextfield.sendKeys(tsize+randomno);
		

		//calendar using javautility
		
		System.out.println(javau.getSystemDate());
		
		//capture the current system date
	    String expecteddate1 = javau.getRequiredDateYYYYDDMM(10);
        System.out.println(expecteddate1);
	    WebElement calendar=driver.findElement(By.name("expectedCloseDate"));
	    calendar.sendKeys(expecteddate1);

		
		//click on create campaign button
		//driver.findElement(By.xpath("//button[text()='Create Campaign']")).click();
		
		eu.setDataIntoExcel("Sheet1", 1, 2,"Passed");
		
	    driver.findElement(By.xpath("//button[contains(text(),'Create Campaign')]")).click();

	  //Validation
	    WebElement toastMsg = driver.findElement(By.xpath("//div[@role='alert']"));
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOf(toastMsg));
	    String msg = toastMsg.getText();
	    if (msg.contains(cname))
	    System.out.println("Campaign Created");
	    else
	    System.out.println("Campaign Not Created");
	    driver.findElement(By.xpath("//button[@aria-label='close']")).click();
	    
	    // Logout
	    WebElement userIcon = driver.findElement(By.xpath("//div[@class='user-icon']"));
	    Actions action = new Actions(driver);
	    action.moveToElement(userIcon).perform();
	    WebElement logoutBtn = driver.findElement(By.xpath("//div[@class='dropdown-item logout']"));
	    action.moveToElement(logoutBtn).click().perform();


	}

}
