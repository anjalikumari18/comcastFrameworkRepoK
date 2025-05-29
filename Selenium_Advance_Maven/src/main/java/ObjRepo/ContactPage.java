package ObjRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	 
		WebDriver driver;
		
		public ContactPage(WebDriver driver) {
	    this.driver=driver;
	    PageFactory.initElements(driver, this);
	}
		@FindBy(name="organizationName")
		private WebElement contactOrganizationName;
		
		@FindBy(name="title")
		private WebElement contactTitle;
		
		@FindBy(name="contactName")
		private WebElement contactTitleName;
		
		@FindBy(name="mobile")
		private WebElement contactMobile;
		@FindBy(xpath="(//button[@type='button'])[2]")  
		private WebElement contactcampaignbutton;
		@FindBy(xpath="(//button[@class=\"select-btn\"])[3]")
		private WebElement contactselectButton;
		@FindBy(xpath="//span[@type='submit']")
		private WebElement contactCreateButton;

		public WebElement getContactCreateButton() {
			return contactCreateButton;
		}

		public WebElement getContactselectButton() {
			return contactselectButton;
		}

		public WebElement getContactOrganizationName() {
			return contactOrganizationName;
		}

		public WebElement getContactcampaignbutton() {
			return contactcampaignbutton;
		}

		public WebElement getContactTitle() {
			return contactTitle;
		}

		public WebElement getContactTitleName() {
			return contactTitleName;
		}

		public WebElement getContactMobile() {
			return contactMobile;
		}
		
		public void ContactDetails(String organizationname, String title, String titlename, String mobile)
		{
			contactOrganizationName.sendKeys(organizationname);
			contactTitle.sendKeys(title);
			contactTitleName.sendKeys(titlename);
			contactMobile.sendKeys(mobile);
			
			
		}

	} 

