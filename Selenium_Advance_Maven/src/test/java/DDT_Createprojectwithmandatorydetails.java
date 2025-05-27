import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class DDT_Createprojectwithmandatorydetails {

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
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Add Product')]")).click();
		driver.findElement(By.name("productName")).sendKeys("Iphone");
		
		WebElement categorydropdown=driver.findElement(By.name("productCategory"));
		Select drop1=new Select(categorydropdown);
		drop1.selectByValue("Electricals");
		WebElement quantity=driver.findElement(By.name("quantity"));
		quantity.clear();
		quantity.sendKeys("7");
		
		WebElement price=driver.findElement(By.name("price"));
		quantity.clear();
		price.sendKeys("89000");
		
		WebElement vendordropdown=driver.findElement(By.name("vendorId"));
		Select drop2=new Select(vendordropdown);
		drop2.selectByValue("VID_007");
		driver.findElement(By.xpath("//button[contains(text(),'Add')]")).click();
		 
		
	
	

	}

}
