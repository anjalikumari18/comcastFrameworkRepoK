package ObjRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import generic.webDriverUtility.WebDriverUtility;

//import WebDriverUtility.WebDriverUtility;

public class HomePage {
	
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	

	@FindBy(xpath="//span[text()='Create Campaign']")
	private WebElement createCampaignbtn;
	
	@FindAll({@FindBy(linkText="Lead"),@FindBy(xpath="//a[text()='Leads']")})
	private WebElement leadsbtn;
	
	@FindBy(xpath="//div[@role='alert']")
	private WebElement toastmsg;
	
	@FindBy(xpath="//div[text()='Logout ']")
	private WebElement logoutbtn;
	
	public WebElement getToastmsg() {
		return toastmsg;
	}


	@FindBy(xpath = "//*[name()='svg' and @data-icon='user']")
	private WebElement userIcon;
	
	
	
	public WebElement getUserIcon() {
		return userIcon;
	}


	public WebDriver getDriver() {
		return driver;
	}


	public WebElement getCreateCampaignbtn() {
		return createCampaignbtn;
	}


	public WebElement getLeadsbtn() {
		return leadsbtn;
	}


	public WebElement CreateCampaignbtn() {
		return createCampaignbtn;
	}


//	public void setCreateCampaignbtn(WebElement createCampaignbtn) {
//		this.createCampaignbtn = createCampaignbtn;
//	}
	
	public void clickonCampaignbtn() {
		createCampaignbtn.click();
		
	}
	
	public void clickOnLeadsbtn() {
		leadsbtn.click();
	}
	
	public void logout() {
		WebDriverUtility wutil= new WebDriverUtility();
		wutil.waitForElementPresent(driver,userIcon );
		Actions action = new Actions(driver);
		action.moveToElement(userIcon).click().perform();
		action.moveToElement(logoutbtn).click(logoutbtn).perform();
	}
	
		
	}


