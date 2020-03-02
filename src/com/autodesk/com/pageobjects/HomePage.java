package com.autodesk.com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class HomePage {

	@FindBy(xpath="//td[@class='tabUnSelected']//a[text()='Leads']")
	private WebElement leads;
	@FindBy(xpath="(//a[text()='Organizations'])[1]")
	private WebElement organizationLink;
	@FindBy(linkText="Contacts")
	private WebElement contactslink;
	@FindBy(css = "td[onmouseover*='ragavivenkatt@gmail.com']")
	private WebElement accIcon;
	@FindBy(linkText = "Sign Out")
	private WebElement signoutlink;
	@FindBy(xpath="//a[text()='More']")
	private WebElement moreDrpDwn;
	@FindBy(xpath="//a[text()='Vendors']")
	private WebElement vendorsLink;
	@FindBy(xpath="//span[@class='userName']")
	private WebElement homePageEleToVerify;
	
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

	public WebElement getLeads() {
		return leads;
	}
	
	public WebElement getOrganizationLink() {
		return organizationLink;
	}

	public WebElement getContactslink() {
		return contactslink;
	}

	public WebElement getAccIcon() {
		return accIcon;
	}

	public WebElement getSignoutlink() {
		return signoutlink;
	}

	public WebElement getMoreDrpDwn() {
		return moreDrpDwn;
	}

	public WebElement getVendorsLink() {
		return vendorsLink;
	}

	public WebElement getHomePageEleToVerify() {
		return homePageEleToVerify;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void clickLead()
	{
		leads.click();
	}
	public void clickOrganization()
	{
		organizationLink.click();
	}
	public void clickContacts()
	{
		contactslink.click();
	}
	public void clickMoreDrpDwn()
	{
		moreDrpDwn.click();
	}
	public void clickVendors()
	{
		vendorsLink.click();
	}
	public void logout() {
		accIcon.click();
		signoutlink.click();
	}
	public void verifyHomePage() {
		Assert.assertTrue(driver.getTitle().contains("Home"));
		Assert.assertEquals(homePageEleToVerify.getText(), "Administrator");
		Reporter.log("homepage verified", true);
	}

}
