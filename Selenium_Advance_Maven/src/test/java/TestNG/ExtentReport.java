package TestNG;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {

	public ExtentReports report;
	@BeforeSuite
	public void configBS() {
		//Spark report config
		ExtentSparkReporter spark=new ExtentSparkReporter("./AdvanceReports/report.html");
		spark.config().setDocumentTitle("CRM Test Suite Results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		
		//add environment info & create test
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-10");
		report.setSystemInfo("BROWSER", "CHROME");
	}
	
	@AfterSuite
	public void configAS() {
		report.flush();
	}
	
	@Test
	public void CreateContactTest() {
		ExtentTest test = report.createTest("CreateContactTest");
		
		test.log(Status.INFO, "Login to app");
		test.log(Status.INFO, "Navigate to contact page");
		test.log(Status.INFO, "create contact");
		if("HDFC".equals("HDFC")) {
			test.log(Status.PASS,"contact is created");
		}else {
			test.log(Status.FAIL,"contact not created" );
		}
		test.log(Status.INFO, "Logged in to app");
	}
	
	

	@Test
	public void CreateLeadTest() {
		ExtentTest test = report.createTest("CreateLeadTest");
		
		test.log(Status.INFO, "Login to app");
		test.log(Status.INFO, "Navigate to contact page");
		test.log(Status.INFO, "create contact");
		if("HDFC".equals("HDFC")) {
			test.log(Status.PASS,"Lead is created");
		}else {
			test.log(Status.FAIL,"Lead not created" );
		}
		test.log(Status.INFO, "Logged in to app");
	}
	

	@Test
	public void CreateOrgTest() {
		ExtentTest test = report.createTest("CreateOrgTest");
		
		test.log(Status.INFO, "Login to app");
		test.log(Status.INFO, "Navigate to contact page");
		test.log(Status.INFO, "create contact");
		if("HDFC".equals("HDF")) {
			test.log(Status.PASS,"org is created");
		}else {
			test.log(Status.FAIL,"org not created" );
		}
		test.log(Status.INFO, "Logged in to app");
	}
	
}
