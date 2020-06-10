package com.utilities;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.aventstack.extentreports.utils.FileUtil;

/**
 * This generic class contains all the controls of webDriver interface 
 * @author ravi
 *
 */
public class WebDriverCommonLibrary extends Base {

	public void waitForPageLoad() {
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}

	public void waitForElementVisibility(By locator) {
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}


	public String getPageTitle() {
		String title =driver.getTitle();
		return title;
	}

	public void select(WebElement element,String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	public void select(String value,WebElement element) {
		Select select = new Select(element);
		select.deselectByValue(value);
	}

	public void select(WebElement element,int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public void mouseHover(WebElement target) {
		Actions act = new Actions(driver);
		act.moveToElement(target).perform();
	}

	public void verifyPage(String actPage,String expPage,String pageName) {
		Assert.assertEquals(actPage, expPage);
		Reporter.log(pageName+" is displayed  -->> pass",true);
	}

	public void elementDispayed(WebElement element, String elementName) {
		System.out.println(element.isDisplayed());
		Assert.assertTrue(element.isDisplayed());
		Reporter.log(elementName+"is Displayed -->>", true);
	}

	public static String captureScreenShots() {
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenshot = System.getProperty("user.dir")+"/ScreenShots/actiTime_"+getCurrentDateTime()+".png";
		try {
			File destination= new File(screenshot);
			FileUtils.copyFile(file, destination);
			System.out.println("screenshot captured");
		}catch(Exception e) {
			System.out.println("unable to capture screenshot >>"+e.getMessage());
		}
		return screenshot;
	}
	public static String getCurrentDateTime() {
		DateFormat customformat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date cdate = new Date();
		return customformat.format(cdate);
	}

}
