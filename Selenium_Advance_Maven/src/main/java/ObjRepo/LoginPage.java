package ObjRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver; //this indicates pointing towards updated address

     PageFactory.initElements(driver,this);
		
	}
	
	
	@FindBy(id="username")
	private WebElement usernametf;
	
	@FindBy(id="inputPassword")
	private WebElement passwordtf;
	
	@FindBy(xpath="//button[text()='Sign In']")
	private WebElement loginbtn;

	public WebElement getUsername() {
		return usernametf;
	}

	public WebElement getPassword() {
		return passwordtf;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}
	
	public void logintoNCRM(String username, String password) {
		usernametf.sendKeys(username);
		passwordtf.sendKeys(password);
		loginbtn.click();
	}
	
	
	//Rule 1 create a seperate java class
		//Rule-2 Object creation: find elements using @FindBy annotation
		//Rule 3: Initialisation: Should be done in test scripts
		
	
	
	
	
	
}



