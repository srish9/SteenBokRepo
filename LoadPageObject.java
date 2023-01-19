package com.Pages;

import java.lang.reflect.Constructor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoadPageObject {
	
	public static <T extends HomePage> T getNewPageInstance(WebDriver driver, Class<T> typeOfPage) {
		  try {
		    Constructor<T> constructor = typeOfPage.getConstructor(typeOfPage);
		    T page = constructor.newInstance(driver);
		    PageFactory.initElements(driver, page);
		    return page;
		  } catch (Exception e) {
		    throw new RuntimeException(e);
		  }
		}

}
