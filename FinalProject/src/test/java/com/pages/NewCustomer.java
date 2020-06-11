package com.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewCustomer {

	public  NewCustomer(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@class='content users']//div[@id='container_users']")
	private WebElement clickUser;
	public WebElement getClickUser() {
		return clickUser;
	}
	public void setClickUser() {
		clickUser.click();
	}
	
	@FindBy(xpath="//div[@class='components_button withPlusIcon']//div[.='New User']")
	private WebElement clickNewUser;
	public WebElement getClickNewUser() {
		return clickNewUser;
	}
	public void setClickNewUser() {
		clickNewUser.click();
	}
	
	@FindBy(xpath="(//input[@name='firstName'])[2]")
	private WebElement txtFirstName;
	/*public WebElement getTxtFirstName() {
		return txtFirstName;
	}
	public void setTxtFirstName(String fName) {
		txtFirstName.sendKeys(fName);
 	} */
	@FindBy(xpath="(//input[@name='lastName'])[2]")
	private WebElement txtSecondName;
	@FindBy(xpath="(//input[@name='email'])[2]")
	public WebElement txtEmail;

	
	@FindBy(xpath="(//div[@class='selectorPlaceholder'])[2]")
	private WebElement clickDept;
	public WebElement getClickDept() {
		return clickDept;
	}
	public void setClickDept() {
		clickDept.click();
	}
	
	@FindBy(xpath="//div[@class='item']")
	private List<WebElement> clickDropdown;
	public List<WebElement> getClickDropdown() {
		return clickDropdown;
	}
	public void setClickDropdown() {
		this.clickDropdown = clickDropdown;
	}
	
	@FindBy(xpath="(//button[@class='x-btn-text'])[4]")
	private WebElement clickHireDate;
	public WebElement getClickHireDate() {
		return clickHireDate;
	}
	public void setClickHireDate(WebElement clickHireDate) {
		clickHireDate.click();
	}
	
	@FindBy(xpath="(//td[@class='x-date-active'])[18]")
	private WebElement selectDate;
	public WebElement getSelectDate() {
		return selectDate;
	}
	public void setSelectDate() {
		selectDate.click();
	}
	
	@FindBy(xpath="(//td[@class='tumbler']//div)[2]")
	private WebElement clickTimeTrack;
	public WebElement getClickTimeTrack() {
		return clickTimeTrack;
	}
	public void setClickTimeTrack() {
		clickTimeTrack.click();
	}
	
	@FindBy(xpath="//div[@class='buttonsBox']//div[.='Save & Send Invitation']")
	private WebElement clickSave;
	public WebElement getClickSave() {
		return clickSave;
	}
	public void setClickSave() {
		clickSave.click();
	}
	
	@FindBy(xpath="(//div[@class='ui-dialog-buttonset']//span[.='OK'])[4]")
	private WebElement clickalertok;
	public WebElement getClickalertok() {
		return clickalertok;
	}
	public void setClickalertok() {
		clickalertok.click();
	}
	
	@FindBy(xpath="(//div[@class='closeLink']//span[.='Close'])[1]")
	private WebElement clickClose;
	public WebElement getClickClose() {
		return clickClose;
	}
	public void setClickClose() {
		clickClose.click();
	}
	
	@FindBy(xpath="//div[@class='userNameContent clickable']//span[@class='userNameSpan']")
	private List<WebElement> selectUser;
	public List<WebElement> getSelectUser() {
		return selectUser;
	}
	public void setSelectUser(List<WebElement> selectUser) {
		this.selectUser = selectUser;
	}
	
	public void newUser(String FIRST_NAME, String LAST_NAME, String EMAIL) {
		txtFirstName.sendKeys(FIRST_NAME);
		txtSecondName.sendKeys(LAST_NAME);
		txtEmail.sendKeys(EMAIL);
	}
	
}
