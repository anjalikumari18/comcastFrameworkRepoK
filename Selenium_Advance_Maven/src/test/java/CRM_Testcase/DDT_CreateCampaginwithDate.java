package CRM_Testcase;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DDT_CreateCampaginwithDate {

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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		driver.get(url);
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("inputPassword")).sendKeys(password);
		driver.findElement(By.xpath("//button[contains(text(),'Sign In')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Create Campaign')]")).click();
		driver.findElement(By.name("campaignName")).sendKeys("Heelooo");
		WebElement t_size = driver.findElement(By.name("targetSize"));
		t_size.clear();
		t_size.sendKeys("400");
		driver.findElement(By.name("campaignStatus")).sendKeys("On Blast");
		driver.findElement(By.name("targetAudience")).sendKeys("POK");
		//calendar
		
		//capture the current system date
	    Date date=new Date();
	    SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
	    String currentdate=sdf.format(date);
	    System.out.println(currentdate);
		
		//capture the current system date 30 days after
        Calendar cal =sdf.getCalendar();
	    cal.add(Calendar.DAY_OF_MONTH,40); 
        String expectedDate1 = sdf.format(cal.getTime());
        System.out.println(expectedDate1);
    
	    WebElement calendar=driver.findElement(By.name("expectedCloseDate"));
	    calendar.sendKeys(expectedDate1);

	    driver.findElement(By.xpath("//button[contains(text(),'Create Campaign')]")).click();
	    
	    //Validation
	    WebElement toastMsg = driver.findElement(By.xpath("//div[@role='alert']"));
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOf(toastMsg));
	    String msg = toastMsg.getText();
	    if (msg.contains("Heelooo"))
	    System.out.println("Campaign Created");
	    else
	    System.out.println("Campaign Not Created");
	    driver.findElement(By.xpath("//button[@aria-label='close']")).click();
	    
	    // Logout
	    WebElement userIcon = driver.findElement(By.xpath("//div[@class='user-icon']"));
	    Actions action = new Actions(driver);
	    action.moveToElement(userIcon).perform();
	    WebElement logoutBtn = driver.findElement(By.xpath("//div[@class='dropdown-item logout']"));
	    action.moveToElement(logoutBtn).click().perform();

		
		
	}

}
