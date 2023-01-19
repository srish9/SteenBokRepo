package com.Pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BasePackage.BaseClass;

public class HomePage extends BaseClass {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	By myAccountBtn = By.xpath(eleconfig.getProperty("myAccount"));
	By RegisterBtn = By.xpath(eleconfig.getProperty("Register"));
	By fnField = By.id(eleconfig.getProperty("firstNameid"));
	By lnField = By.id(eleconfig.getProperty("lastNameid"));
	By emailField = By.id(eleconfig.getProperty("emailid"));
	By passwordField = By.id(eleconfig.getProperty("passwordid"));
	By yesSubscribe = By.xpath(eleconfig.getProperty("subscribeYesBullet"));
	By noSubscribe = By.xpath(eleconfig.getProperty("subscribeNoBullet"));
	By agreeCheckbox = By.xpath(eleconfig.getProperty("agreeCheckboxName"));
	By submitBtn = By.xpath(eleconfig.getProperty("submitBtn"));
	By registerErrMsg = By.xpath(eleconfig.getProperty("RegisterError"));
	By loginLink = By.xpath(eleconfig.getProperty("loginLink"));
	By openCartLogo = By.xpath(eleconfig.getProperty("openCartLogo"));

	String failureMsg = "login page";
	WebDriverWait wait=null;

	// Method to click on my account icon
	public void clickMyAccountBtn() {
		// wait.until(ExpectedConditions.visibilityOf(driver.findElement(myAccountBtn)));
		driver.findElement(myAccountBtn).click();
	}

	// Method to click on Register
	public void clickRegisterBtn() {
		// wait.until(ExpectedConditions.visibilityOf(driver.findElement(RegisterBtn)));
		driver.findElement(RegisterBtn).click();
	}

	public String fillRegisterForm(String firstname, String lastname, String email, String password) {
		try {

			wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
			driver.findElement(fnField).sendKeys(detailsconfig.getProperty("UserName"));
			driver.findElement(lnField).sendKeys(detailsconfig.getProperty("LastName"));
			driver.findElement(emailField).sendKeys(detailsconfig.getProperty("Email"));
			driver.findElement(passwordField).sendKeys(detailsconfig.getProperty("Password"));

			comm.scrollMethod(driver.findElement(submitBtn));

			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(yesSubscribe)));
			driver.findElement(yesSubscribe).click();

			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(agreeCheckbox)));
			driver.findElement(agreeCheckbox).click();

			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(submitBtn)));
			driver.findElement(submitBtn).click();

			comm.scrollMethod(driver.findElement(registerErrMsg));
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(registerErrMsg)));
			if (driver.findElement(loginLink).isDisplayed()) {
				System.out.println("Registration was unsuccessful, Try Login");
				failureMsg = driver.findElement(loginLink).getText();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return failureMsg;
	}

	public void clickLogo() {
		driver.findElement(openCartLogo).click();
	}

	public void menuHeaderNavigation() {
		//navigate through menu headers
	}
}
