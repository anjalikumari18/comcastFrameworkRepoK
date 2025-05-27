package TestNG;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Report;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import BaseClassPackage.BaseClassCRM;
import generic.webDriverUtility.UtilityClassObject;

public class ListnerImplementationClass implements ITestListener, ISuiteListener {
	public static ExtentSparkReporter spark;
	public static ExtentTest test;
	public static ExtentReports report;


	@Override
	public void onStart(ISuite suite) {
	Reporter.log("Report config");
	String time=new Date().toString().replace(" ", "_").replace(":", "_");

	
	ExtentSparkReporter spark=new ExtentSparkReporter("./AdvanceReports/report_"+time+".html");
	spark.config().setDocumentTitle("CRM Test Suite Results");
	spark.config().setReportName("CRM Report");
	spark.config().setTheme(Theme.DARK);
	
	//add environment info & create test
	report=new ExtentReports();
	report.attachReporter(spark);
	report.setSystemInfo("OS", "Windows-10");
	report.setSystemInfo("BROWSER", "CHROME");

	}

	@Override
	public void onFinish(ISuite suite) {
	Reporter.log("Report backed up");
	report.flush();
	}

	@Override
	//this is goibg to be executed before executing each @test
	public void onTestStart(ITestResult result) {
		String testCseName = result.getMethod().getMethodName();
		Reporter.log(testCseName+ "Test case started");	
		ExtentTest test=report.createTest(testCseName);
		test.log(Status.INFO, result.getMethod().getMethodName()+"==>STARTED<==");
	    //helps in executing parallel implementation
		UtilityClassObject.setTest(test); //can use UCOBJ in real test case to access as it has been set
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		Reporter.log("Testcase executed");	
		test.log(Status.PASS, result.getMethod().getMethodName()+"==>COMPLETED<==");

	}
	

	@Override
	public void onTestFailure(ITestResult result) {
		String testCseName = result.getMethod().getMethodName();
		Reporter.log("Testcase failed");	
		/*TakesScreenshot ts= (TakesScreenshot)BaseClassCRM.sdriver;
		File temp = ts.getScreenshotAs(OutputType.FILE);*/
		
		TakesScreenshot ts=(TakesScreenshot)BaseClassCRM.sdriver;
		String filepath = ts.getScreenshotAs(OutputType.BASE64);//cause extent report supports base64 & returns string

		String time=new Date().toString().replace(" ", "_").replace(":", "_");
		File dest=new File("./Errorshots/"+testCseName+".png");
		test.addScreenCaptureFromBase64String(filepath, testCseName+"_"+time);

		/*try {
			FileHandler.copy(temp, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();*/
		}
		

	@Override
	public void onTestSkipped(ITestResult result) {
		Reporter.log("Testcase skipped");	

	}

	
	
	
}

