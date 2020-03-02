package com.autodesk.com.organization;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.autodesk.com.genericlib.BrowserFactory;
import com.autodesk.com.genericlib.FileLib;
import com.autodesk.com.genericlib.WebDriverUtils;

public class ContactsTest {
	WebDriver driver;
	WebDriverUtils wdu;
	FileLib fl;
	

	@Test
	public void SelectmultipleContactAndDeleteMassContactWithHeaderAndCancel() throws IOException {
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
		driver.findElement(By.linkText("Contacts")).click();
		verifyContactsPage();
		driver.findElement(By.cssSelector("img[title*='Create Contact']")).click();
		customerInfo(fl.getExcelData("Sheet1", 1, 0), fl.getExcelData("Sheet1", 1, 1));
		customerInfo(fl.getExcelData("Sheet1", 2, 0), fl.getExcelData("Sheet1", 2, 1));
		customerInfo(fl.getExcelData("Sheet1", 3, 0), fl.getExcelData("Sheet1", 3, 1));
		driver.findElement(By.linkText("Contacts")).click();
		wdu.isSelected(driver.findElement(By.id("selectCurrentPageRec")));
		driver.findElement(By.xpath("//table[@class='small']//td//input[@value='Delete']")).click();

		Alert alt = driver.switchTo().alert();
		String actual = alt.getText();
		verifyAlert(actual);
		alt.dismiss();
		driver.findElement(By.cssSelector("td[onmouseover*='ragavivenkatt@gmail.com']")).click();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
	}

	public void customerInfo(String firstName, String lastName) throws EncryptedDocumentException, IOException {
		driver.findElement(By.name("firstname")).sendKeys(firstName);
		driver.findElement(By.name("lastname")).sendKeys(lastName);
		driver.findElement(By.xpath("(//input[@value='  Save  '])[1]")).click();
		verifyCustomerCreation(firstName);
		driver.findElement(By.cssSelector("img[title*='Create Contact']")).click();
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

	public void verifyContactsPage() {
		Assert.assertTrue(driver.getTitle().contains("Contacts "));
		Reporter.log("ContactsPage has been verifies,true");
	}

	public void verifyContactInformationPage() {
		Assert.assertEquals(driver.findElement(By.xpath("//td[@class='dvtSelectedCell']")).getText(),
				"Contact Information");
		Reporter.log("ContactsPage has been verifies,true");
	}

	public void verifyCustomerCreation(String FirstName)  {

		String actual = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		Assert.assertTrue(actual.contains(FirstName));
		Reporter.log("customer creation verified", true);
		
	}

	public void verifyAlert(String actual) {
		Assert.assertTrue(actual.contains("Are you sure you want to delete the selected"));
		Reporter.log("alert msg verified", true);
	}
}
