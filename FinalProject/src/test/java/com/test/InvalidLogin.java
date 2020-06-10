package com.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pages.Login;
import com.utilities.Base;
import com.utilities.FileLibrary;
import com.utilities.WebDriverCommonLibrary;

public class InvalidLogin extends Base{
	
	@Test
	public void loginPage() throws Throwable {
		Login login = new Login(driver);
		FileLibrary libfile = new FileLibrary();
		WebDriverCommonLibrary commonLib= new WebDriverCommonLibrary();
//		String username = libfile.getCellData(EXCEL_PATH, "Sheet1", 1, 0);
//		login.setTxtUserName(username);
//		String password = libfile.getCellData(EXCEL_PATH, "Sheet1", 2, 1);
//		login.setTxtPassword(password);
//		login.setBtnLogin();
		int rowCount=libfile.getRowCount(EXCEL_PATH, "Sheet1");
		System.out.println(rowCount);
		for(int i=1;i<=rowCount;i++) {
			String userName = libfile.getCellData(EXCEL_PATH, "Sheet1",i,0);
			login.setTxtUserName(userName);
			String password = libfile.getCellData(EXCEL_PATH, "Sheet1",i,1);
			login.setTxtPassword(password);
			login.setBtnLogin();
			Thread.sleep(3000);
			Assert.assertTrue(login.getErrMsg().isDisplayed(),"something wrong" );
			libfile.writeDataintoExcel(EXCEL_PATH, "Sheet1", i, 2, "passed");
			commonLib.captureScreenShots();
			Assert.assertFalse(login.getErrMsg().isDisplayed(),"success");
			libfile.writeDataintoExcel(EXCEL_PATH, "Sheet1", i, 2, "Failed");
		}
	}
	
	
}
