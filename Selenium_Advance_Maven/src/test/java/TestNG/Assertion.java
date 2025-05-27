package TestNG;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assertion {
	
	@Test
	public void homepageTest(Method mtd) {
		System.out.println(mtd.getName()+"Test Start");
		SoftAssert assertObj= new SoftAssert();
		System.out.println("Step-1");
		System.out.println("Step-2");
		Assert.assertEquals("Home", "Home");
		System.out.println("Step-3");
		assertObj.assertEquals("Title", "Title");
		System.out.println("Step-4");
		assertObj.assertAll();
		System.out.println(mtd.getName()+"Test end");
	}

}
