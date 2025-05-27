package TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class screenshot_eventfiringwebdriver {
	
	@Test
	public void flipkartss() {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.flipkart.com/");
	}
	
	//Step 1: Create an object of EventFiring Webdriver

}
