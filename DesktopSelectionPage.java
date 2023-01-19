package com.Pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BasePackage.BaseClass;

public class DesktopSelectionPage extends BaseClass {

	WebDriver driver;

	public DesktopSelectionPage(WebDriver driver) {
		this.driver = driver;
	}

	By desktopMenu = By.xpath(eleconfig.getProperty("DesktopMenu"));
	By pcMenu = By.xpath(eleconfig.getProperty("PCMenu"));
	By macMenu = By.xpath(eleconfig.getProperty("MacMenu"));
	By allDesktops = By.xpath(eleconfig.getProperty("allDesktops"));
	By continueBtn = By.xpath(eleconfig.getProperty("continueBtn"));
	WebDriverWait wait = null;
	
	public void navigateToPC() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
		driver.findElement(desktopMenu).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(pcMenu)));
		driver.findElement(pcMenu).click();
		driver.findElement(continueBtn).click();
	}
	
	public void navigateToMac() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
		driver.findElement(desktopMenu).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(macMenu)));
		driver.findElement(macMenu).click();
		driver.findElement(continueBtn).click();
	}
	
	public void navigateToAllDesktops() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
		driver.findElement(desktopMenu).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(allDesktops)));
		driver.findElement(desktopMenu).click();
	}
	
}
