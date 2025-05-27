import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DDT_PropertiesFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		//Step:1 Get the java representation object of the physical file
		FileInputStream fis=new FileInputStream("C:\\Users\\anjal\\OneDrive\\Desktop\\Framewo\\DDT_Propertiesfile.properties");
				
		//Step:2 Using Properties class, load all the key
		Properties pObj=new Properties();
		pObj.load(fis);
		
		//Step:3 Get value based on key
		String browser = pObj.getProperty("browser");
		String url = pObj.getProperty("url");
		String user = pObj.getProperty("username");
		String pass = pObj.getProperty("password");
		String orgname = pObj.getProperty("orgname");
		
		//to get data from runtime but remove it due to manual intervention
//		Scanner s=new Scanner(System.in);
//		System.out.println("Enter the browser");
//		String browser1=s.next();
		
		WebDriver driver=null;
		if(browser.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}else if(browser.equalsIgnoreCase("firefox")){
			driver=new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("edge")){
		    driver=new EdgeDriver();
		}
		else {
			driver=new ChromeDriver();

		}
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(user);
		driver.findElement(By.name("user_password")).sendKeys(pass);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgname);
		
		

	}

}
