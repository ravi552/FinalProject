package com.utilities;
/**
 * This class is the base for every test script
 * every test script extends this base class to access common methods
 */

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
/**
 * 
 * @author ravi
 *
 */

public class Base implements AutoConstant{
	public static WebDriver driver;
	
	@BeforeClass
	public void openBrowser() throws Throwable {
		FileLibrary fl = new FileLibrary();
		String browserValue = fl.getPropKeyValue(PROPERTIES_PATH, "browser");

		if(browserValue.equalsIgnoreCase("chrome")) {
			System.setProperty(CHROME_KEY, CHROME_VALUE);
			driver = new ChromeDriver();
		}
		else if (browserValue.equalsIgnoreCase("firefox")) {
			System.setProperty(FIREFOX_KEY, FIREFOX_VALUE);
			driver = new FirefoxDriver();
		}
		else if (browserValue.equalsIgnoreCase("ie")) {
			System.setProperty(IE_KEY, IE_VALUE);
			driver = new InternetExplorerDriver();
		}
		else {
			System.out.println("!!................Please select valid browser............!!");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		String test_URL =fl.getPropKeyValue(PROPERTIES_PATH,"url");
		driver.get(test_URL);
	}
	@AfterClass
	public void tearDown() {
		driver.close();
	}

}
