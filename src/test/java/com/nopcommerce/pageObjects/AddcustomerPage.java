package com.nopcommerce.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddcustomerPage {

	public WebDriver ldriver;

	public AddcustomerPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	By lnkCustomers_menu = By
			.xpath("//body[1]/div[3]/aside[1]/div[1]/div[4]/div[1]/div[1]/nav[1]/ul[1]/li[4]/a[1]/p[1]");

	By lnkCustomers_menuitem = By
			.xpath("//body[1]/div[3]/aside[1]/div[1]/div[4]/div[1]/div[1]/nav[1]/ul[1]/li[4]/ul[1]/li[1]/a[1]/p[1]");

	By btnAddnew = By.xpath("//body/div[3]/div[1]/form[1]/div[1]/div[1]/a[1]"); // Add new

	By txtEmail = By.xpath("//input[@id='Email']");
	By txtPassword = By.xpath("//input[@id='Password']");

	By txtFirstName = By.xpath("//input[@id='FirstName']");
	By txtLastName = By.xpath("//input[@id='LastName']");

	By rdMaleGender = By.id("Gender_Male");
	By rdFeMaleGender = By.id("Gender_Female");

	By txtDob = By.xpath("//input[@id='DateOfBirth']");

	By txtCompanyName = By.xpath("//input[@id='Company']");

	By taxExempt = By.xpath("//input[@id='IsTaxExempt']");

	/*By newsLetter = By.xpath(
			"//body/div[3]/div[1]/form[1]/section[1]/div[1]/div[1]/nop-cards[1]/nop-card[1]/div[1]/div[2]/div[9]/div[2]/div[1]/div[1]/div[1]/div[1]");
*/
	
	By txtcustomerRoles = By.xpath(
			"//body/div[3]/div[1]/form[1]/section[1]/div[1]/div[1]/nop-cards[1]/nop-card[1]/div[1]/div[2]/div[10]/div[2]/div[1]/div[1]/div[1]/div[1]");

	//body/div[3]/div[1]/form[1]/section[1]/div[1]/div[1]/nop-cards[1]/nop-card[1]/div[1]/div[2]/div[10]/div[2]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]
	By lstitemAdministrators = By.xpath("//li[contains(text(),'Administrators')]");
	By lstitemRegistered = By.xpath("//body/div[3]/div[1]/form[1]/section[1]/div[1]/div[1]/nop-cards[1]/nop-card[1]/div[1]/div[2]/div[10]/div[2]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]");
	By lstitemGuests = By.xpath("//li[contains(text(),'Guests')]");
	By lstitemVendors = By.xpath("//li[contains(text(),'Vendors')]");

	By drpmgrOfVendor = By.xpath("//select[@id='VendorId']");

	By active = By.xpath("//input[@id='Active']");

	By txtAdminContent = By.xpath("//textarea[@id='AdminComment']");

	By btnSave = By.xpath("//body/div[3]/div[1]/form[1]/div[1]/div[1]/button[1]");

	public void clickOnCustomersMenu() {
		ldriver.findElement(lnkCustomers_menu).click();
	}

	public void clickOnCustomersMenuItem() {
		ldriver.findElement(lnkCustomers_menuitem).click();
	}

	public void clickOnAddnew() {
		ldriver.findElement(btnAddnew).click();
	}

	public void setEmail(String email) {
		ldriver.findElement(txtEmail).sendKeys(email);
	}

	public void setPassword(String password) {
		ldriver.findElement(txtPassword).sendKeys(password);
	}

	public void setCustomerRoles(String role) throws InterruptedException {
		ldriver.findElement(By.xpath("//*[@id=\"SelectedCustomerRoleIds_taglist\"]/li/span[2]")).click();

		ldriver.findElement(txtcustomerRoles).click();

		WebElement listitem;

		Thread.sleep(3000);

		if (role.equals("Administrators")) {
			listitem = ldriver.findElement(lstitemAdministrators);
		} else if (role.equals("Guests")) {
			listitem = ldriver.findElement(lstitemGuests);
		} else if (role.equals("Registered")) {
			listitem = ldriver.findElement(lstitemRegistered);
		} else if (role.equals("Vendors")) {
			listitem = ldriver.findElement(lstitemVendors);
		} else {
			listitem = ldriver.findElement(lstitemGuests);
		}

		listitem.click();
		Thread.sleep(3000);

		JavascriptExecutor js = (JavascriptExecutor) ldriver;
		js.executeScript("arguments[0].click();", listitem);

	}

	public void setManagerOfVendor(String value) {
		Select drp = new Select(ldriver.findElement(drpmgrOfVendor));
		drp.selectByVisibleText(value);
	}

	public void setGender(String gender) {
		if (gender.equals("Male")) {
			ldriver.findElement(rdMaleGender).click();
		} else if (gender.equals("Female")) {
			ldriver.findElement(rdFeMaleGender).click();
		} else {
			ldriver.findElement(rdMaleGender).click();// Default
		}

	}

	public void setFirstName(String fname) {
		ldriver.findElement(txtFirstName).sendKeys(fname);
	}

	public void setLastName(String lname) {
		ldriver.findElement(txtLastName).sendKeys(lname);
	}

	public void setDob(String dob) {
		ldriver.findElement(txtDob).sendKeys(dob);
	}

	public void setCompanyName(String comname) {
		ldriver.findElement(txtCompanyName).sendKeys(comname);
	}

	public void setAdminContent(String content) {
		ldriver.findElement(txtAdminContent).sendKeys(content);
	}

	public void clickOnSave() {
		ldriver.findElement(btnSave).click();
	}

}
