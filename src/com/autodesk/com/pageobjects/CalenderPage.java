package com.autodesk.com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.autodesk.com.genericlib.WebDriverUtils;

public class CalenderPage {
	@FindBy(name="subject")
	private WebElement eventNmTxBx;
	
	@FindBy(id="startfmt")
	private WebElement timeFormat;
	
	@FindBy(xpath="(//input[@value='  Save  '])[1]")
	private WebElement saveBtn;
	
	@FindBy(xpath="//a[text()='X']")
	private WebElement activityCloseBtn;
	WebDriverUtils wdu;
	public CalenderPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		wdu=new WebDriverUtils();
	}

	public void scheduleActivity()
	{
		eventNmTxBx.sendKeys("email");
		wdu.select(timeFormat, "PM");
		saveBtn.click();
		activityCloseBtn.click();
	}
}
