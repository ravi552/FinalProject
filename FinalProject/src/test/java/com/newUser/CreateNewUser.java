package com.newUser;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.pages.Login;
import com.pages.NewCustomer;
import com.utilities.Base;
import com.utilities.FileLibrary;
import com.utilities.WebDriverCommonLibrary;

public class CreateNewUser extends Base{
	
	@Test
	public void createNewUser() throws Throwable {
		Login login = new Login(driver);
		NewCustomer nc = new NewCustomer(driver);
		FileLibrary fLib = new FileLibrary();
		WebDriverCommonLibrary wcLib = new WebDriverCommonLibrary();
		
		String userName = fLib.getPropKeyValue(PROPERTIES_PATH, "username");
		login.setTxtUserName(userName);
		String password = fLib.getPropKeyValue(PROPERTIES_PATH, "password");
		login.setTxtPassword(password);
		login.setBtnLogin();
		nc.setClickUser();
		Thread.sleep(4000);
		nc.setClickNewUser();
		Thread.sleep(4000);
		String firstName=fLib.getCellData(Excel_PATH_NEW_CUSTOMER, "Sheet1", 2, 0);
		//nc.setTxtFirstName(firstName);
		String secondtName=fLib.getCellData(Excel_PATH_NEW_CUSTOMER, "Sheet1", 2, 1);
		String email=fLib.getCellData(Excel_PATH_NEW_CUSTOMER, "Sheet1", 2, 2);
		nc.newUser(firstName, secondtName, email);
		wcLib.selectDept(nc.getClickDropdown(),"Quality Control");
		wcLib.selectHireDate(nc.getClickHireDate(), nc.getSelectDate());
		nc.setClickTimeTrack();
		nc.setClickSave();
		Thread.sleep(2000);
		nc.setClickalertok();
		Thread.sleep(2000);
		nc.setClickClose();
		Thread.sleep(2000);
		wcLib.selectUser(nc.getSelectUser(), "Young, Zimmy");
		
	}

}
