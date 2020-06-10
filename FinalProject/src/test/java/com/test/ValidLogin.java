package com.test;

import org.testng.annotations.Test;

import com.pages.Login;
import com.utilities.Base;
import com.utilities.FileLibrary;

public class ValidLogin extends Base {
	
	@Test
	public void loginPage() throws Throwable {
		Login login = new Login(driver);
		FileLibrary libfile = new FileLibrary();
		String userName = libfile.getPropKeyValue(PROPERTIES_PATH, "username");
		login.setTxtUserName(userName);
		String password = libfile.getPropKeyValue(PROPERTIES_PATH, "password");
		login.setTxtPassword(password);
		login.setBtnLogin();
	}
}
