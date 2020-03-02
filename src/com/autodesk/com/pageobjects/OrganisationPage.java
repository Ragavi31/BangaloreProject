package com.autodesk.com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.autodesk.com.genericlib.WebDriverUtils;

public class OrganisationPage {

	@FindBy(xpath = "//img[@title='Export Organizations']")
	private WebElement exportOrganizationLink;
	@FindBy(xpath = "//td[text()='Export with search records']/parent::tr//input[@name='search_type']")
	private WebElement radioBtn1;
	@FindBy(xpath = "//td[text()='Export all data']/parent::tr//input[@name='export_data']")
	private WebElement radioBtn2;
	@FindBy(name = "Export")
	private WebElement export;

	@FindBy(xpath = "//td[@class='moduleName']//a")
	private WebElement organizationModuleToverify;
	@FindBy(xpath = "//table[@class='mailClient importLeadUI small']//tr/td[@class='mailClientBg  genHeaderSmall']")
	private WebElement organizationExportModuleToverify;
	@FindBy(xpath = "//div[@id='not_search']//b")
	private WebElement errorMsgToverify;

	WebDriver driver;
	WebDriverUtils wdu;

	public OrganisationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		wdu = new WebDriverUtils();
	}

	public WebElement getExportOrganizationLink() {
		return exportOrganizationLink;
	}

	public WebElement getRadioBtn1() {
		return radioBtn1;
	}

	public WebElement getRadioBtn2() {
		return radioBtn2;
	}

	public WebElement getExport() {
		return export;
	}

	public WebElement getOrganizationModuleToverify() {
		return organizationModuleToverify;
	}

	public WebElement getOrganizationExportModuleToverify() {
		return organizationExportModuleToverify;
	}

	public WebElement getErrorMsgToverify() {
		return errorMsgToverify;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebDriverUtils getWdu() {
		return wdu;
	}

	public void exportOrganisation() {
		verifyOrganizationPage();
		exportOrganizationLink.click();
		verifyOrganizationExportPage();
		wdu.isSelected(radioBtn1);
		wdu.isSelected(radioBtn2);
		export.click();
		//verifyErrorMessage();
	}

	public void verifyOrganizationPage() {

		Assert.assertTrue(driver.getTitle().contains("Organizations"));
		String actualModule = organizationModuleToverify.getText();
		Assert.assertEquals(actualModule, "Organizations");
		Reporter.log("OrganizationPage verified", true);

	}

	public void verifyOrganizationExportPage() {
		String actual = organizationExportModuleToverify.getText();
		Assert.assertEquals(actual, "Organizations >> Export");
		Reporter.log("OrganizationExportPage verified", true);
	}

	public void verifyErrorMessage() {
		Assert.assertEquals(errorMsgToverify.getText(),
				"You haven't used the search. All the records will be Exported from Organizations");
		Reporter.log("ErrorMessage verified", true);

	}
}
