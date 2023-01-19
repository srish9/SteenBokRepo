package com.TestPackage;

import org.testng.annotations.Test;
import com.Utilities.IntializeDriver;
import BasePackage.BaseClass;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class LoginTest extends BaseClass {

	
	@Test(priority=1)
	public void UserLogin() {
		System.out.println("User Login Method");
		homepage.clickMyAccountBtn();
		loginpage.enterEmail(detailsconfig.getProperty("Email"));
		loginpage.enterPassword(detailsconfig.getProperty("Password"));
		loginpage.clickLogin();
	}
	

}
