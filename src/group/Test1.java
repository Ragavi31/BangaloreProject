package group;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.autodesk.com.genericlib.MyTestListener;

@Listeners(MyTestListener.class)
public class Test1 {
	
	@Test
	public void demo()
	{
		System.setProperty("webdriver.chrome.driver", "./exefiles/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com");
	
		
	
	}

}
