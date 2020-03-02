package com.autodesk.com.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InvoicePage {
	@FindBy(xpath="//img[@title='Last Viewed']")
	private WebElement lastViewedLink;
	
	
	@FindBy(xpath="(//a[text()='Organizations'])[1]")
	private WebElement organizationLink;
	@FindBy(linkText="Contacts")
	private WebElement contactslink;
	@FindBy(css = "td[onmouseover*='ragavivenkatt@gmail.com']")
	private WebElement accIcon;
	@FindBy(linkText = "Sign Out")
	private WebElement signoutlink;
	
	

}
