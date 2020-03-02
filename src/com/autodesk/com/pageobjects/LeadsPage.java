package com.autodesk.com.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.autodesk.com.genericlib.WebDriverUtils;

public class LeadsPage {

	@FindBy(css = "img[title*='Create Lead']")
	private WebElement createLeadBtn;
	@FindBy(name = "firstname")
	private WebElement leadFirstNmTxBx;
	@FindBy(name = "lastname")
	private WebElement leadLastnmTxBx;
	@FindBy(name = "company")
	private WebElement leadCompanyTxtBx;
	@FindBy(xpath = "(//input[@value='  Save  '])[1]")
	private WebElement saveBtn;
	@FindBy(xpath = "//td[@class='moduleName']//a[text()='Leads']")
	private WebElement leadslink;
	@FindBy(xpath = "//table[@class='lvt small']//tr//td[3]/a")
	private List<WebElement> existingLeadsLink;
	@FindBy(xpath = "(//a[text()='More Information'])[1]")
	private WebElement leadsMoreInfoLink;
	@FindBy(xpath = "//a[text()='Activity History']")
	private WebElement activityHistoryLink;
	@FindBy(css = "input[value='Add Event']")
	private WebElement addEventBtn;
	@FindBy(xpath = "(//a[contains(@href,'Activities')])[1]")
	private WebElement activities;
	@FindBy(xpath = "//td[@class='moduleName']//a")
	private WebElement leadsLinkToVerify;
	@FindBy(xpath = "Lead Information")
	private WebElement leadsInfoLinkToVerify;
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement leadcreatedconfirmationMsgToVerify;
	@FindBy(xpath="(//div[@id='tbl_Leads_ActivityHistory']/table)[2]")
	private WebElement activityHistoryTable;

	WebDriverUtils wdu;
	WebDriver driver;

	public LeadsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		wdu = new WebDriverUtils();
	}

	public WebElement getCreateLeadBtn() {
		return createLeadBtn;
	}

	public WebElement getLeadFirstNmTxBx() {
		return leadFirstNmTxBx;
	}

	public WebElement getLeadLastnmTxBx() {
		return leadLastnmTxBx;
	}

	public WebElement getLeadCompanyTxtBx() {
		return leadCompanyTxtBx;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getLeadslink() {
		return leadslink;
	}

	public List<WebElement> getExistingLeadsLink() {
		return existingLeadsLink;
	}

	public WebElement getLeadsMoreInfoLink() {
		return leadsMoreInfoLink;
	}

	public WebElement getActivityHistoryLink() {
		return activityHistoryLink;
	}

	
	public WebElement getAddEventBtn() {
		return addEventBtn;
	}

	public WebElement getActivities() {
		return activities;
	}

	public WebElement getLeadsLinkToVerify() {
		return leadsLinkToVerify;
	}

	public WebElement getLeadsInfoLinkToVerify() {
		return leadsInfoLinkToVerify;
	}

	public WebElement getLeadcreatedconfirmationMsgToVerify() {
		return leadcreatedconfirmationMsgToVerify;
	}

	public WebElement getActivityHistoryTable() {
		return activityHistoryTable;
	}

	public WebDriverUtils getWdu() {
		return wdu;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void createlead(String firstName, String lastName, String companyNm) {
		createLeadBtn.click();
		verifyLeadsInfoPage();
		leadFirstNmTxBx.sendKeys(firstName);
		leadLastnmTxBx.sendKeys(lastName);
		leadCompanyTxtBx.sendKeys(companyNm);
		saveBtn.click();
		verifyleadsCreation(firstName);
		leadslink.click();
		existingLeadsLink.get(1).click();
		verifyLeadsInfoPage(); 
		wdu.moveToElement(driver, leadsMoreInfoLink);
		activityHistoryLink.click();
		activities.click();
		addEventBtn.click();
	}

	public void verifyLeadsPage() {
		Assert.assertTrue(driver.getTitle().contains("Leads"));
		Assert.assertEquals(leadsLinkToVerify.getText(), "Leads");
		Reporter.log("leads page verified", true);
	}
	public void verifyLeadsInfoPage() {
		Assert.assertTrue(driver.getTitle().contains("Leads"));
		Assert.assertEquals(leadsInfoLinkToVerify.getText(), "Lead Information");
		Reporter.log("leadsinfo page verified", true);
	}
	public void verifyleadsCreation(String firstNmae)  {

		String actual = leadcreatedconfirmationMsgToVerify.getText();
		Assert.assertTrue(actual.contains(firstNmae));
		Reporter.log(firstNmae+" lead has been created", true);
		
	}
}
