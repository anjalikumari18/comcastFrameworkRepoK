package TestNG;
import org.testng.annotations.Test;

public class dependsOnMethods {

	@Test
	public void CreateCampaignTest() {
		System.out.println("Execute CreateCampaignTest==>123");
		String str=null;
		System.out.println(str.equals("123"));
	}
	
	@Test (dependsOnMethods="CreateCampaignTest")
	public void CreateContactTest() {
		System.out.println("Execute CreateContactTest");
	}

}
