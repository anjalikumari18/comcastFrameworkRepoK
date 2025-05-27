package GenericUtility;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import generic.fileutility.ExcelUtility;
import generic.fileutility.JsonUtility;
import generic.fileutility.PropertyFileutility;
import generic.webDriverUtility.WebDriverUtility;

public class GU_Createcontactwithcampaign {

	public static void main(String[] args) throws IOException, ParseException, InterruptedException {
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

		
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("inputPassword")).sendKeys(password);
		driver.findElement(By.xpath("//button[contains(text(),'Sign In')]")).click();
		driver.findElement(By.linkText("Contacts")).click();
		
		driver.findElement(By.xpath("//span[contains(text(),'Create Contact')]")).click();
		driver.findElement(By.xpath("(//button[@type=\"button\"])[2]")).click();
		
		ExcelUtility eutil=new ExcelUtility();
		String orgname = eutil.getDataFromExcel("Contact", 1, 0);
		String title = eutil.getDataFromExcel("Contact", 1, 1);
		String contactname = eutil.getDataFromExcel("Contact", 1, 2);
		String mobile = eutil.getDataFromExcel("Contact", 1, 3).toString();
		driver.findElement(By.name("organizationName")).sendKeys(orgname);
		driver.findElement(By.name("title")).sendKeys(title);
		driver.findElement(By.name("contactName")).sendKeys(contactname);
		driver.findElement(By.name("mobile")).sendKeys(mobile);
		
//		WebDriverUtility wdu=new WebDriverUtility();
//		wbu.switchToTab(driver);
//		
//		String parentid = driver.getWindowHandle();
//		Set<String> allwindowid = driver.getWindowHandles();
//		allwindowid.remove(parentid);
//		
//		for(String id:allwindowid) {
//			driver.switchTo().window(id);
//			break;
//		}
		
		wbu.switchNewBrowserTab(driver);
		Thread.sleep(3000);

		driver.findElement(By.xpath("(//button[@class=\"select-btn\"])[2]")).click();
		Thread.sleep(2000);
		
		wbu.switchToParent(driver);
		
	    //Actions as=new Actions(driver);

		WebElement createc=driver.findElement(By.xpath("//button[contains(text(),'Create Contact')]"));
	    //as.moveToElement(createc).click().perform();


		wbu.mouseMoveOnElement(driver,createc );
		
		
		
		
		
	}

}
