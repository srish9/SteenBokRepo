package com.Utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import BasePackage.BaseClass;

public class CommonFunctions extends BaseClass {

	public void scrollMethod(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		// js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void scrollByEndOfPage() {
		// This will scroll the web page till end.
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void scrollToElement(WebElement element) {
		new Actions(driver).scrollToElement(element).perform();
	}

	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
	// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
	
	public void selectionMethod(WebElement SelectMenu,String option) {
		Select selectmenu = new Select(SelectMenu);
		selectmenu.selectByVisibleText(option);
	}
	
	
	
}
