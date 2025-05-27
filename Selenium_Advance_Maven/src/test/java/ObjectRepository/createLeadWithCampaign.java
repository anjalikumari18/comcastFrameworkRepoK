package ObjectRepository;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import ObjRepo.HomePage;
import ObjRepo.LeadPage;
import ObjRepo.LoginPage;
import generic.fileutility.ExcelUtility;
import generic.fileutility.PropertyFileutility;
import generic.webDriverUtility.JavaUtility;
import generic.webDriverUtility.WebDriverUtility;

public class createLeadWithCampaign {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
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
       

		HomePage hp=new HomePage(driver);
		hp.clickOnLeadsbtn();
		
		LeadPage ldp=new LeadPage(driver);
		ldp.clickOnCreateLeadBtn();
		
		String leadname = eutil.getDataFromExcel("Lead", 1, 0);
		String company = eutil.getDataFromExcel("Lead", 1, 1);
		String leadsource = eutil.getDataFromExcel("Lead", 1, 2);
		String industry = eutil.getDataFromExcel("Lead", 1, 3);
		String leadstatus = eutil.getDataFromExcel("Lead", 1, 4);
		String phoneno=eutil.getDataFromExcel("Lead", 1, 5);
		String rating=eutil.getDataFromExcel("Lead", 1, 6);

		
		ldp.getLeadNametf().sendKeys(leadname+r);
		ldp.getLeadSourcetf().sendKeys(leadsource+r);
		ldp.getCompanytf().sendKeys(company+r);
		ldp.getIndustrytf().sendKeys(industry+r);
		ldp.getLeadStatustf().sendKeys(leadstatus+r);
		ldp.getPhonetf().sendKeys(phoneno+r);
		ldp.getRating().sendKeys(rating+r);
		ldp.getAddCpgnBtn().click();
        wutil.switchNewBrowserTab(driver);	
        ldp.getSelectbtn().click();
        wutil.switchToParent(driver);
        
        ldp.getCreateLeadSubmitButton().click();
		
	}

}
