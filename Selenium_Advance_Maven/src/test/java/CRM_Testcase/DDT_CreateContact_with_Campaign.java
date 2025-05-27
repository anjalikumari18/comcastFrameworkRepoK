package CRM_Testcase;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class DDT_CreateContact_with_Campaign {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
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
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
			driver.get(url);
			driver.findElement(By.id("username")).sendKeys(username);
			driver.findElement(By.id("inputPassword")).sendKeys(password);
			driver.findElement(By.xpath("//button[contains(text(),'Sign In')]")).click();
			driver.findElement(By.linkText("Contacts")).click();
			
			driver.findElement(By.xpath("//span[contains(text(),'Create Contact')]")).click();
			driver.findElement(By.xpath("(//button[@type=\"button\"])[2]")).click();
			
			driver.findElement(By.name("organizationName")).sendKeys("GSP");
			driver.findElement(By.name("title")).sendKeys("Change you need");
			driver.findElement(By.name("contactName")).sendKeys("Gi");
			driver.findElement(By.name("mobile")).sendKeys("7782934802");
			
			String parentid = driver.getWindowHandle();
			Set<String> allwindowid = driver.getWindowHandles();
			allwindowid.remove(parentid);
			
			for(String id:allwindowid) {
				driver.switchTo().window(id);
				break;
			}
			
			driver.findElement(By.xpath("(//button[@class=\"select-btn\"])[2]")).click();
			
			driver.switchTo().window(parentid);

			Actions as=new Actions(driver);
			
			WebElement createc=driver.findElement(By.xpath("//button[contains(text(),'Create Contact')]"));
			as.moveToElement(createc).click().perform();

	}

}
