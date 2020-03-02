 package com.autodesk.com.genericlib;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.autodesk.com.pageobjects.HomePage;
import com.autodesk.com.pageobjects.LoginPage;

public class BaseLib {
	
	 public  WebDriver driver;
	 public FileLib flib=new FileLib();
	 public  WebDriverUtils wLib= new WebDriverUtils();
	 public HomePage hp;
	@BeforeSuite
	public void preData()
	{
		
	}
	@BeforeClass
	public void configBC() throws IOException
	{
		driver=BrowserFactory.launchBrowser(flib.propertyKeyValue("browser"));
		wLib.waitForElement(driver);
		hp=new HomePage(driver);
	}
   @BeforeMethod
   public void configBM() throws IOException
   {
	   wLib.waitForElement(driver);
	   driver.get(flib.propertyKeyValue("url"));
	   LoginPage lp=new LoginPage(driver);
	   lp.getUnTxBx().sendKeys(flib.propertyKeyValue("userName"));
	   lp.getPwdTxBx().sendKeys(flib.propertyKeyValue("password"));
	   lp.getLoginBtn().click();
	   
	   
   }
   @AfterMethod
   public void configAM() {
	 
	   hp.logout();
   }
   @AfterClass
   public void connfigAC()
   {
	   driver.close();
   }
   @AfterSuite
   public void configAS()
   {
	   
   }
}
