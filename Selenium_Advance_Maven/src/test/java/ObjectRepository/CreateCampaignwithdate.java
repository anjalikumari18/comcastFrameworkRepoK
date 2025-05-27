package ObjectRepository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import ObjRepo.CampaignPage;
import ObjRepo.HomePage;
import ObjRepo.LoginPage;
import generic.fileutility.ExcelUtility;
import generic.fileutility.PropertyFileutility;
import generic.webDriverUtility.JavaUtility;
import generic.webDriverUtility.WebDriverUtility;

public class CreateCampaignwithdate {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		PropertyFileutility putil=new PropertyFileutility();
		String BROWSER = putil.getDataFromPropertiesFile("browser");
		String URL=putil.getDataFromPropertiesFile("url");
		String USERNAME=putil.getDataFromPropertiesFile("username");
		String PASSWORD=putil.getDataFromPropertiesFile("password");
		
		//CROSS BROWSER TESTING 
		
		WebDriver driver= null;
		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}else if (BROWSER.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}else {
			driver=new ChromeDriver();
		}
		
		JavaUtility jutil=new JavaUtility();
		int r=jutil.getRandomNumber();
		
		ExcelUtility eutil=new ExcelUtility();
		String cname = eutil.getDataFromExcel("Sheet1", 1, 0);
		String targetsize = eutil.getDataFromExcel("Sheet1", 1, 1);
		System.out.println(targetsize+r);
		
		
		//Launching the url
		WebDriverUtility wutil=new WebDriverUtility();
		driver.manage().window().maximize();
		wutil.waitForPageToLoad(driver);
		driver.get(URL);
		

       LoginPage lp=new LoginPage(driver);
       lp.logintoNCRM(USERNAME, PASSWORD);
       
       //click on Campaign button
       HomePage hp=new HomePage(driver);
       hp.clickonCampaignbtn();

       CampaignPage cp=new CampaignPage(driver);
       cp.enterCmpname(cname+r);
       cp.entertargetsize(targetsize);
       
       String reqdate = jutil.getRequiredDateYYYYDDMM(10);
       
      
       cp.getCdate().sendKeys(reqdate);;
       
       cp.clickOnCreateCampaignBtn();
       
       cp.logout();
	}

}
