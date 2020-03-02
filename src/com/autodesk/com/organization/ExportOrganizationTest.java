package com.autodesk.com.organization;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.autodesk.com.genericlib.BrowserFactory;
import com.autodesk.com.genericlib.FileLib;
import com.autodesk.com.genericlib.WebDriverUtils;

public class ExportOrganizationTest {
	WebDriver driver;
	WebDriverUtils wdu;
	@Test
	public void organization() throws IOException {
		FileLib fl = new FileLib();
		 wdu= new WebDriverUtils();
	    driver = BrowserFactory.launchBrowser(fl.propertyKeyValue("browser"));
		wdu.waitForElement(driver);
		driver.get(fl.propertyKeyValue("url"));
		verifyLoginPage();
		driver.findElement(By.name("user_name")).sendKeys(fl.propertyKeyValue("userName"));
		driver.findElement(By.name("user_password")).sendKeys(fl.propertyKeyValue("password"));
		driver.findElement(By.id("submitButton")).click();
		verifyHomePage();
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		verifyOrganizationPage();
		driver.findElement(By.xpath("//img[@title='Export Organizations']")).click();
		verifyOrganizationExportPage();
		WebElement ele = driver.findElement(By.xpath("//td[text()='Export with search records']/parent::tr//input[@name='search_type']"));
		wdu.isSelected(ele);
		WebElement ele1 = driver.findElement(By.xpath("//td[text()='Export all data']/parent::tr//input[@name='export_data']"));
		wdu.isSelected(ele1);
		driver.findElement(By.name("Export")).click();
		verifyErrorMessage();
		driver.quit();
	}


	public void verifyLoginPage()
	{
		List<WebElement> labels = driver.findElements(By.xpath("//div[@class='inputs']/div[@class='label']"));
		Assert.assertEquals(labels.get(0).getText(), "User Name");
		Assert.assertEquals(labels.get(1).getText(), "Password");
		Reporter.log("loginpage verified",true);
	
	}

	public void verifyHomePage()
	{
		Assert.assertTrue(driver.getTitle().contains("Home"));		
		Assert.assertEquals(driver.findElement(By.xpath("//span[@class='userName']")).getText(), "Administrator");
		Reporter.log("homepage verified",true);
	} 

	public void verifyOrganizationPage()
	{
		
	   Assert.assertTrue(driver.getTitle().contains("Organizations"));
	   String actualModule = driver.findElement(By.xpath("//td[@class='moduleName']//a")).getText();
	   Assert.assertEquals(actualModule, "Organizations");
	   Reporter.log("OrganizationPage verified",true);
		
		
	}
	public void verifyOrganizationExportPage()
	{
	   String actual = driver.findElement(By.xpath("//table[@class='mailClient importLeadUI small']//tr/td[@class='mailClientBg  genHeaderSmall']")).getText();
	   Assert.assertEquals(actual, "Organizations >> Export");
	   Reporter.log("OrganizationExportPage verified",true);
	}
	public void verifyErrorMessage()
	{
	    WebElement ele = driver.findElement(By.xpath("//div[@id='not_search']//b"));
		Assert.assertEquals(ele.getText(), "You haven't used the search. All the records will be Exported from Organizations");
		Reporter.log("ErrorMessage verified",true);
		
		}
}
