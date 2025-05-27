import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DDT_CreateLeadwithCampaign {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		FileInputStream fis=new FileInputStream("C:\\Users\\anjal\\Desktop\\DDT Files\\ninzacrm.properties.txt");

		//Create an object of properties class
		Properties prop=new Properties();
		
		//load all the keys in properties file
		prop.load(fis);
		
		//Extract the value using key name
		String browser = prop.getProperty("browser");
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		
		System.out.println(url);
		
		//cross browser testing
		WebDriver driver=null;
		if(browser.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
		else {
			driver=new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(url);
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("inputPassword")).sendKeys(password);
		driver.findElement(By.xpath("//button[contains(text(),'Sign In')]")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Create Lead')]")).click();
		
		
		
		//tapping on plus button
		driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
		String parentid = driver.getWindowHandle();

		Set<String> allids = driver.getWindowHandles();
		allids.remove(parentid);
		for (String window : allids) {
		    driver.switchTo().window(window);
		    }
		System.out.println("control given to child window");

		driver.findElement(By.xpath("(//button[@class='select-btn'])[1]")).click();
		}		
	}


