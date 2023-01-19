package com.Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import BasePackage.BaseClass;

public class IntializeDriver extends BaseClass {

	private static IntializeDriver intializeDriverInstance = null;
	private WebDriver driver;

	// Constructor
	private IntializeDriver() {

		if (detailsconfig.getProperty("browser").equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\main\\resources\\Executables\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (detailsconfig.getProperty("browser").equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "\\src\\main\\resources\\Executables\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();

	}

	/******************************************************************************************************
	 * Function Name:-> getInstanceOfIntializeDriverClass() Description :-> returns
	 * instance of this class Param :-> Outpur Param :->
	 *******************************************************************************************************/

	public static IntializeDriver getInstanceOfIntializeDriverClass() {
		if (intializeDriverInstance == null) {
			intializeDriverInstance = new IntializeDriver();
		}
		return intializeDriverInstance;
	}

	/******************************************************************************************************
	 * Function Name:-> getDriver() Description :-> to get driver Param :-> Outpur
	 * Param :->
	 *******************************************************************************************************/
	public WebDriver getDriver() {

		// invoke the URL
		driver.get(detailsconfig.getProperty("applicationURL"));
		System.out.println("Inside get Driver Method " + prop.loadDetails().getProperty("applicationURL"));
		try {
			Thread.sleep(Integer.parseInt(detailsconfig.getProperty("MinWaitTime")));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driver;
	}

}
