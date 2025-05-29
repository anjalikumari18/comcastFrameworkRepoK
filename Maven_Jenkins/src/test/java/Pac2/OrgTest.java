package Pac2;

import org.testng.annotations.Test;

public class OrgTest {
	
	@Test(groups = "smoke")
	public void createOrgTest() {
		String URL = System.getProperty("url");
		String BROWSER = System.getProperty("browser");
		String USERNAME = System.getProperty("username");
		String PASSWORD = System.getProperty("password");
		
		System.out.println(URL);
		System.out.println(BROWSER);
		System.out.println(USERNAME);
		System.out.println(PASSWORD);
		
		System.out.println("createOrgTest");

		

		


	}
	
	@Test(groups = "regression")
	public void modifyOrgTest() {
		System.out.println("execute modifyOrgTest");
	}
	
	@Test(groups = "regression")
	public void DeleteOrgTest() {
		System.out.println("execute DeleteOrgTest");
	}
	

}
