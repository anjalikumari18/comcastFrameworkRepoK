package BaseClassPackage;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

//import GenericUtility.PropertyFileUtiltiy;
import ObjRepo.HomePage;
import ObjRepo.LoginPage;
import generic.fileutility.PropertyFileutility;
import generic.webDriverUtility.UtilityClassObject;
import generic.webDriverUtility.WebDriverUtility;

public class BaseClassCRM {
	
	public PropertyFileutility putil=new PropertyFileutility();
	public WebDriver driver=null;
	public static WebDriver sdriver= null;
	public WebDriverUtility wutil=new WebDriverUtility();
	public ExtentSparkReporter spark;
	public ExtentTest test;
	public ExtentReports report;
	
	
	@BeforeSuite
	public void configBS() {
		Reporter.log("Establish DB connection", true);
		//Spark report config
		ExtentSparkReporter spark=new ExtentSparkReporter("./AdvanceReports/report.html");
		spark.config().setDocumentTitle("CRM Test Suite Results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		
		//add environment info & create test
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-10");
		report.setSystemInfo("BROWSER", "CHROME");

	}
	
	@AfterSuite
	public void configAS() {
		Reporter.log("Disconnect DB connection", true);
		report.flush();//to create backup
	}
	
	@BeforeTest
	public void configBT() {
		Reporter.log("Pre-condition");
	}
	
	@AfterTest
	public void configAT() {
		Reporter.log("Post-condition");
	}
	
	//@Parameters("browser")
	@BeforeClass
	public void configBC(/*String Brows*/) throws IOException {
		Reporter.log("Launching a browser", true);

		//CROSS BROWSER TESTING 
		String BROWSER = putil.getDataFromPropertiesFile("browser");
		String URL = putil.getDataFromPropertiesFile("url");

		//String BROWSER =Brows;
		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}else if (BROWSER.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}else {
			driver=new ChromeDriver();
		}
		
		sdriver=driver;//Both drivers are pointing towards same driver
		UtilityClassObject.setDriver(driver); //anyone want to use driver anywhere can access
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(URL);
	}
	
	@AfterClass
	public void configAC() {
		Reporter.log("Browser is closed");
		driver.close();
		
	}
	
	@BeforeMethod
	public void configBM() throws IOException {
		String USERNAME = putil.getDataFromPropertiesFile("username");
		String PASSWORD = putil.getDataFromPropertiesFile("password");
		LoginPage lp=new LoginPage(driver);
		lp.logintoNCRM(USERNAME, PASSWORD);
		Reporter.log("Login successful");
	}
	
	@AfterMethod
	public void configAM() {
		HomePage hp=new HomePage(driver);
		hp.logout();
		Reporter.log("Logged out successfully");
	}


}
