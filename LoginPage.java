package com.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BasePackage.BaseClass;

public class LoginPage extends BaseClass {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	
	By myEmailField = By.xpath(eleconfig.getProperty("emailField"));
	By myPswd = By.xpath(eleconfig.getProperty("passwordField"));
	By loginSubmitBtn = By.xpath(eleconfig.getProperty("submitLogin"));
	WebDriverWait wait = null;
	
	// Method to enter username
	public void enterEmail(String emailid) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
		//wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(myEmailField)));
		driver.findElement(myEmailField).sendKeys(emailid);
	}

	// Method to enter password
	public void enterPassword(String pass) {
		//wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(myPswd)));
		driver.findElement(myPswd).sendKeys(pass);
	}

	// Method to click on Login button
	public void clickLogin() {
		//wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(loginSubmitBtn)));
		driver.findElement(loginSubmitBtn).click();
	}

}
