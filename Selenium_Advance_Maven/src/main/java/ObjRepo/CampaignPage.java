package ObjRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignPage {
	
	WebDriver driver;
	public CampaignPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getUserIcon() {
		return userIcon;
	}

	@FindBy(name="campaignName")
	private WebElement cnametf;

	@FindBy(name="targetSize")
	private WebElement tsizetf;
	
	@FindBy(name="expectedCloseDate")
	private WebElement cdate;
	
	@FindBy(xpath="//button[text()='Create Campaign']")
	private WebElement createcpnbtn;
	
	@FindBy(xpath="//div[@class='user-icon']")
	private WebElement userIcon;
	

	@FindBy(xpath="//button[text()='Sign In']")
	private WebElement loginbtn;
	

	@FindBy(xpath="//div[@class='dropdown-item logout']")
	private WebElement logoutbtn;
	

	public WebElement getLoginbtn() {
		return loginbtn;
	}

	public WebElement getLogoutbtn() {
		return logoutbtn;
	}

	public WebElement getCnametf() {
		return cnametf;
	}

	public WebElement getTsizetf() {
		return tsizetf;
	}
	
	public WebElement getCreatecpnbtn() {
		return createcpnbtn;
	}
	
	public void enterCmpname(String cname) {
		cnametf.sendKeys(cname);
	}
	
	
	
	public void entertargetsize(String targetnum) {
		tsizetf.clear();
		tsizetf.sendKeys(targetnum);
	}
	
	
	public WebElement getCdate() {
		return cdate;
	}
	
	public void clickOnCreateCampaignBtn() {
		createcpnbtn.click();
		
	}
	
	
	public void logout() {
		Actions action = new Actions(driver);
		action.moveToElement(userIcon).click().perform();
		action.moveToElement(logoutbtn).click(logoutbtn).perform();
	}
}
