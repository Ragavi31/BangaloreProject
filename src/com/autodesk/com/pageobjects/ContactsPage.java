package com.autodesk.com.pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.autodesk.com.genericlib.WebDriverUtils;

public class ContactsPage 
{

	@FindBy(css="img[title*='Create Contact']")
	private WebElement createContactBtn;
	@FindBy(name="firstname")
	private WebElement contactFirstNm;
	@FindBy(name="lastname")
	private WebElement contactLastNm;
	@FindBy(xpath="(//input[@value='  Save  '])[1]")
	private WebElement saveBtn;
	@FindBy(linkText="Contacts")
	private WebElement contactLink;
	@FindBy(id="selectCurrentPageRec")
	private WebElement masterSelectChxBx;
	@FindBy(xpath="//table[@class='small']//td//input[@value='Delete']")
	private WebElement deleteBtn;
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement contactcreatedconfirmationMsgToVerify;
	@FindBy(xpath="//td[@class='dvtSelectedCell']")
	private WebElement contactinfoPageToVerify;
	
	WebDriverUtils wdu;
	WebDriver driver;

	public ContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
		wdu=new WebDriverUtils();
	}
	
	
	public WebElement getLeads() {
		return createContactBtn;
	}
	public WebElement getContactFirstNm() {
		return contactFirstNm;
	}
	public WebElement getContactLastNm() {
		return contactLastNm;
	}
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	public WebElement getContactLink() {
		return contactLink;
	}
	public WebElement getMasterSelectChxBx() {
		return masterSelectChxBx;
	}
	public WebElement getDeleteBtn() {
		return deleteBtn;
	}
	public void createContact(String firstName,String lastNm)
	{
		verifyContactsPage();
		createContactBtn.click();
		contactFirstNm.sendKeys(firstName);
		contactLastNm.sendKeys(lastNm);
		saveBtn.click();
		verifyCustomerCreation(firstName);
	}
	
	public void contacts()
	{
		
		contactLink.click(); 
		wdu.isSelected(masterSelectChxBx);
		deleteBtn.click();
		Alert alt = driver.switchTo().alert();
		verifyAlert(alt.getText());
		alt.dismiss();
	}
	
	public void verifyContactsPage() {
		Assert.assertTrue(driver.getTitle().contains("Contacts "));
		Reporter.log("ContactsPage has been verifies,true");
	}
 
	public void verifyCustomerCreation(String firstNmae)  {

		String actual = contactcreatedconfirmationMsgToVerify.getText();
		Assert.assertTrue(actual.contains(firstNmae));
		Reporter.log(firstNmae+" customer has been created", true);
		
	}
	
	public void verifyContactInformationPage() {
		Assert.assertEquals(contactinfoPageToVerify.getText(),
				"Contact Information");
		Reporter.log("ContactsPage has been verifies,true");
	}
	
	public void verifyAlert(String actual) {
		Assert.assertTrue(actual.contains("Are you sure you want to delete the selected"));
		Reporter.log("alert msg verified", true);
	}
}
 