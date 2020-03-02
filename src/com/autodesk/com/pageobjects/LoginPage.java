package com.autodesk.com.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class LoginPage {

	@FindBy(name = "user_name")
	private WebElement unTxBx;
	@FindBy(name = "user_password")
	private WebElement pwdTxBx;
	@FindBy(id = "submitButton")
	private WebElement loginBtn;
	
	@FindBy(xpath = "//div[@class='inputs']/div[@class='label']")
	private List<WebElement> userNameandPwdLabel;
	
    WebDriver driver;
    
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}

	public WebElement getUnTxBx() {
		return unTxBx;
	}

	public WebElement getPwdTxBx() {
		return pwdTxBx;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	public void login(String userName, String password) {
		unTxBx.sendKeys(userName);
		pwdTxBx.sendKeys(password);
		loginBtn.click();
	}
	
	public void verifyloginPage()
	{
		
		Assert.assertEquals(userNameandPwdLabel.get(0).getText(), "User Name");
		Assert.assertEquals(userNameandPwdLabel.get(1).getText(), "Password");
		Reporter.log("loginpage verified", true);

	}

}
