package TestNG;

import org.testng.annotations.Test;

public class DataProvider {

	@Test(dataProvider="getData")
		
		public void createContactTest(String firstName, String lastName, int age) {
			System.out.println("Firstname:"+firstName+"Lastname:"+lastName);
		}
		
	
	
	@org.testng.annotations.DataProvider
	public Object[][] getData(){
		Object[][] objArr=new Object[3][3];
		objArr[0][0]="anjali";
		objArr[0][1]="Test Engineer";
		objArr[0][2]=12;

		
		objArr[1][0]="sam";
		objArr[1][1]="Samsung";
		objArr[1][2]=22;

		
		objArr[2][0]="John";
		objArr[2][1]="Smith";
		objArr[2][2]=32;

		
		return objArr;
	
}
}
