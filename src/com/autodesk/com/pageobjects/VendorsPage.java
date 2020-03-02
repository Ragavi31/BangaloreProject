package com.autodesk.com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.autodesk.com.genericlib.WebDriverUtils;

public class VendorsPage {
	
	@FindBy(xpath="//a[text()='Create Filter']")
	private WebElement createFilterLink;
	
	@FindBy(name="viewName")
	private WebElement viewNameTxtBx;
	@FindBy(xpath="//b[text()='Advanced Filters']")
	private WebElement advancedFilterLink;
	@FindBy(css="input[value='New Group']")
	private WebElement newGroupBtn;
	@FindBy(xpath="//select[@class='detailedViewTextBox']")
	private WebElement newGrpDrpDwn1;
	
	@FindBy(xpath="//select[@class='repBox']")
	private WebElement newGrpDrpDwn2;
	@FindBy(xpath="	//input[@class='repBox']")
	private WebElement newGrpTxBx;
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	WebDriverUtils wdu;
	
	public VendorsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		wdu=new WebDriverUtils();
		
	}

	public WebElement getCreateFilterLink() {
		return createFilterLink;
	}

	public WebElement getViewNameTxtBx() {
		return viewNameTxtBx;
	}

	public WebElement getAdvancedFilterLink() {
		return advancedFilterLink;
	}

	public WebElement getNewGroupBtn() {
		return newGroupBtn;
	}

	public WebElement getNewGrpDrpDwn1() {
		return newGrpDrpDwn1;
	}

	public WebElement getNewGrpDrpDwn2() {
		return newGrpDrpDwn2;
	}

	public WebElement getNewGrpTxBx() {
		return newGrpTxBx;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	public void creatingFilter(String name,String option1,String option2,String text)
	{
		createFilterLink.click();;
		viewNameTxtBx.sendKeys(name);
		advancedFilterLink.click();
		//newGroupBtn.click();
		newGrpDrpDwn1.click();
		wdu.select(newGrpDrpDwn1,option1);
		newGrpDrpDwn2.click();
		wdu.select(newGrpDrpDwn2, option2);
		newGrpTxBx.sendKeys(text);
		saveBtn.click();
	}
	
}
