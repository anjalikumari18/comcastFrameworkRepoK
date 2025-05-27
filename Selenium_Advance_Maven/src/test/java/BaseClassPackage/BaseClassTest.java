package BaseClassPackage;

import org.junit.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClassTest {
	
	@BeforeSuite
	public void configBS() {
		System.out.println("====execute BS====");
	}
	
	@AfterSuite
	public void configAS() {
		System.out.println("====execute AS====");
	}
	
	@BeforeClass
	public void configBC() {
		System.out.println("execute BC");
	}
	
	@BeforeMethod
	public void configBM() {
		System.out.println("execute BM");
	}
	

	@AfterClass
	public void configAC() {
		System.out.println("execute AC");
	}
	
	@AfterMethod
	public void configAM() {
		System.out.println("execute AM");

}}
