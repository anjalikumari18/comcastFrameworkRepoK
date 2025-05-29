package TestNG;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import BaseClassPackage.BaseClassCRM;
import ObjRepo.CampaignPage;
import ObjRepo.HomePage;
import ObjRepo.LoginPage;
import generic.fileutility.ExcelUtility;
import generic.fileutility.PropertyFileutility;
import generic.webDriverUtility.JavaUtility;
import generic.webDriverUtility.WebDriverUtility;
//@Listeners(ListnerImplementationClass.class)
public class CreateCampaignwithDateTest extends BaseClassCRM{

	@Test(groups = "smoke")
	public void CreateCampaignDateTest() throws EncryptedDocumentException, IOException, InterruptedException {
		JavaUtility jutil=new JavaUtility();
		int r = jutil.getRandomNumber();
		
		ExcelUtility eutil=new ExcelUtility();
		String cname = eutil.getDataFromExcel("Sheet1", 1, 0);
		String targetsize = eutil.getDataFromExcel("Sheet1", 1, 1);
		System.out.println(targetsize+r);
		
		
	   //click on Campaign button
	   HomePage hp=new HomePage(driver);
	   hp.clickonCampaignbtn();

	   CampaignPage cp=new CampaignPage(driver);
	   cp.enterCmpname(cname+r);
	   cp.entertargetsize(targetsize);
	   
	   String reqdate = jutil.getRequiredDateYYYYDDMM(10);
	   
	  
	   cp.getCdate().sendKeys(reqdate);;
	   
	   cp.clickOnCreateCampaignBtn();
   Thread.sleep(5000);
}

	@Test(groups = {"smoke","regression"})
	public void CreateCampaign() throws EncryptedDocumentException, IOException, InterruptedException {
//	PropertyFileutility putil = new PropertyFileutility();
//	putil.getDataFromPropertiesFile(null)
//		
	JavaUtility jutil=new JavaUtility();
	int r = jutil.getRandomNumber();
	
	ExcelUtility eutil=new ExcelUtility();
	String cname = eutil.getDataFromExcel("Sheet1", 1, 0);
	String targetsize = eutil.getDataFromExcel("Sheet1", 1, 1);
	System.out.println(targetsize+r);
	
	
   //click on Campaign button
   HomePage hp=new HomePage(driver);
   hp.clickonCampaignbtn();

   CampaignPage cp=new CampaignPage(driver);
   cp.enterCmpname(cname+r);
   cp.entertargetsize(targetsize);
   
   String reqdate = jutil.getRequiredDateYYYYDDMM(10);
   
  
   cp.getCdate().sendKeys(reqdate);;
   
   cp.clickOnCreateCampaignBtn();
   Thread.sleep(5000);
}
	
	@Test(groups = "smoke")
		public void createCampaignWithMandatoryFieldsTest() throws IOException, InterruptedException {
		String expectedData="Anjali";
		String actualData= "Kumari";
		
		JavaUtility jutil=new JavaUtility();
		int r = jutil.getRandomNumber();
		
		ExcelUtility eutil=new ExcelUtility();
		String cname = eutil.getDataFromExcel("Sheet1", 1, 0);
		String targetsize = eutil.getDataFromExcel("Sheet1", 1, 1);
		System.out.println(targetsize+r);
		
		
	   //click on Campaign button
	   HomePage hp=new HomePage(driver);
	   hp.clickonCampaignbtn();

	   CampaignPage cp=new CampaignPage(driver);
	   cp.enterCmpname(cname+r);
	   cp.entertargetsize(targetsize);
	   
	   String reqdate = jutil.getRequiredDateYYYYDDMM(10);
	   
	  
	   cp.getCdate().sendKeys(reqdate);;
	   
	   cp.clickOnCreateCampaignBtn();
	   Thread.sleep(5000);
	   
	   org.testng.Assert.assertEquals(actualData, expectedData, "Failed");
	   }
	}

