package group;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.autodesk.com.genericlib.MyTestListener;


public class ParallelExecution {
	static WebDriver driver;

	@BeforeMethod
	@Parameters({"browser"})
	public void openBrowser(String browserName)
	{
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./exefiles/chromedriver.exe");
			driver=new ChromeDriver();
			driver.get("https://www.google.com");
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "./exefiles/geckodriver.exe");
			driver=new FirefoxDriver();
			driver.get("https://www.google.com");
		}
		
	}
	
	@Test
	public void test()
	{
		Reporter.log("running test",true);
	
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.close();
	}
}
