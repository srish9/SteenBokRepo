package com.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BasePackage.BaseClass;

public class DesktopListPage extends BaseClass {

	WebDriver driver;

	public DesktopListPage(WebDriver driver) {
		this.driver = driver;
	}
	WebDriverWait wait = null;

	By listDesktops = By.xpath(eleconfig.getProperty("listview"));
	By gridDesktops = By.xpath(eleconfig.getProperty("gridview"));
	By sortList = By.xpath(eleconfig.getProperty("sortList"));
	By qtyList = By.xpath(eleconfig.getProperty("qtySelect"));
	By itemTitle = By.xpath(eleconfig.getProperty("itemtobuy"));
	By canonHeart = By.xpath(eleconfig.getProperty("heartIcon"));
	By colorSelector = By.xpath(eleconfig.getProperty("colorSelector"));
	By qtyToBuy = By.xpath(eleconfig.getProperty("qtyField"));
	By addToCart = By.xpath(eleconfig.getProperty("addtoCart"));
	By shoppingCartHeader = By.xpath(eleconfig.getProperty("shoppingCartHeader"));
	By continueBtn = By.xpath(eleconfig.getProperty("continueBtn"));
	
	public void ChangeView(String viewType) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
		if (viewType.equalsIgnoreCase("List")) {
			driver.findElement(listDesktops).click();
		} else if (viewType.equalsIgnoreCase("Grid"))
			driver.findElement(gridDesktops).click();
	}

	public void sortDesktops(String sortOption) {
		comm.selectionMethod(driver.findElement(sortList), sortOption);
	}

	public void sortQty(String qtyOption) {
		comm.selectionMethod(driver.findElement(qtyList), qtyOption);
	}

	public void addToWishlist() {
		comm.scrollMethod(driver.findElement(itemTitle));
		wait = new WebDriverWait(driver, Duration.ofSeconds(2000));
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(itemTitle)));
		
		driver.findElement(itemTitle).click();
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(canonHeart)));
		driver.findElement(canonHeart).click();
	}

	public void addToCart(String color) {
		comm.scrollMethod(driver.findElement(colorSelector));
		comm.selectionMethod(driver.findElement(colorSelector), color);
		
		driver.findElement(qtyToBuy).sendKeys("3");
		driver.findElement(addToCart).click();
		
		comm.scrollMethod(driver.findElement(shoppingCartHeader));
		driver.findElement(shoppingCartHeader).click();
		driver.findElement(continueBtn).click();
		
	}

	
	
}
