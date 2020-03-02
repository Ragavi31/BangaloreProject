package com.autodesk.com.organization;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.autodesk.com.genericlib.BrowserFactory;
import com.autodesk.com.genericlib.FileLib;
import com.autodesk.com.genericlib.WebDriverUtils;

public class LeadsTest {
	WebDriver driver;
	WebDriverUtils wdu;
	FileLib fl;

	@Test
	public void addingActivitHistoryitoCreatedLead() throws IOException {

		fl = new FileLib();
		wdu = new WebDriverUtils();
		driver = BrowserFactory.launchBrowser(fl.propertyKeyValue("browser"));
		wdu.waitForElement(driver);
		driver.get(fl.propertyKeyValue("url"));
		verifyLoginPage();
		driver.findElement(By.name("user_name")).sendKeys(fl.propertyKeyValue("userName"));
		driver.findElement(By.name("user_password")).sendKeys(fl.propertyKeyValue("password"));
		driver.findElement(By.id("submitButton")).click();
		verifyHomePage();
		driver.findElement(By.xpath("//td[@class='tabUnSelected']//a[text()='Leads']")).click();
		verifyLeadsPage();
		driver.findElement(By.cssSelector("img[title*='Create Lead']")).click();

	}

	public void createLead() throws EncryptedDocumentException, IOException {
		driver.findElement(By.name("firstname")).sendKeys(fl.getExcelData("Sheet1", 4, 0));
		driver.findElement(By.name("lastname")).sendKeys(fl.getExcelData("Sheet1", 4, 1));
		driver.findElement(By.name("company")).sendKeys(fl.getExcelData("Sheet1", 4, 2));
		driver.findElement(By.xpath("(//input[@value='  Save  '])[1]")).click();

		driver.findElement(By.cssSelector("img[title*='Create Lead']")).click();
	}

	public void verifyLoginPage() {
		List<WebElement> labels = driver.findElements(By.xpath("//div[@class='inputs']/div[@class='label']"));
		Assert.assertEquals(labels.get(0).getText(), "User Name");
		Assert.assertEquals(labels.get(1).getText(), "Password");
		Reporter.log("loginpage verified", true);

	}

	public void verifyHomePage() {
		Assert.assertTrue(driver.getTitle().contains("Home"));
		Assert.assertEquals(driver.findElement(By.xpath("//span[@class='userName']")).getText(), "Administrator");
		Reporter.log("homepage verified", true);
	}

	public void verifyLeadsPage() {
		Assert.assertTrue(driver.getTitle().contains("Leads"));
		Assert.assertEquals(driver.findElement(By.xpath("//td[@class='moduleName']//a")).getText(), "Leads");
		Reporter.log("leads page verified", true);
	}

}
