package Pac1;

import org.testng.annotations.Test;

public class ContactTest {
	
	@Test(groups="smoke")
	public void createContactTest() {
		System.out.println("execute createContactTest");
	}
	
	@Test(groups = "regression")
	public void modifyContactTest() {
		System.out.println("execute modifyContactTest");
	}

	@Test(groups = "regression")
	public void DeleteContactTest() {
		System.out.println("execute DeleteContactTest");
	}
}
