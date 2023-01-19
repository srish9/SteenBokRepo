package com.TestPackage;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.Pages.HomePage;
import com.Pages.LoginPage;
import BasePackage.BaseClass;

public class RegisterTest extends BaseClass {

	@Test(priority=0)
	public void UserRegisteration() {
		System.out.println("User Registeration Method");
		homepage.clickMyAccountBtn();
		homepage.clickRegisterBtn();
		Assert.assertEquals("login page", homepage.fillRegisterForm(detailsconfig.getProperty("UserName"),
				detailsconfig.getProperty("LastName"),
				detailsconfig.getProperty("Email"),
				detailsconfig.getProperty("Password")),
				"Registration was unsuccessful, Try Login");
	}

}
