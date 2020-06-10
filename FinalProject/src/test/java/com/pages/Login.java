package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	
	public Login(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="username")
	private WebElement txtUserName;
	public WebElement getTxtUserName() {
		return txtUserName;
	}
	public void setTxtUserName(String userName) {
		txtUserName.sendKeys(userName);
	}
	
	@FindBy(name="pwd")
	private WebElement txtPassword;
	public WebElement getTxtPassword() {
		return txtPassword;
	}
	public void setTxtPassword(String pwd) {
		txtPassword.sendKeys(pwd);;
	}
	
	@FindBy(xpath="//a[@id='loginButton']")
	private WebElement btnLogin;
	public WebElement getBtnLogin() {
		return btnLogin;
	}
	public void setBtnLogin() {
		btnLogin.click();
	}
	
	@FindBy(xpath="//td/span[@class='errormsg' and .='Username or Password is invalid. Please try again.']")
	private WebElement errMsg;
	public WebElement getErrMsg() {
		return errMsg;
	}
	public void setErrMsg() {
		errMsg.getText();
	}
	
}
