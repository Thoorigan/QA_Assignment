package com.helper;

import org.openqa.selenium.WebDriver;

import com.pom.PageElements;

public class PageObjectManager {
	WebDriver driver;
	
	
	public PageObjectManager (WebDriver driver1) {
		this.driver=driver1;
	}
	public PageElements getPe() {
		  return new PageElements(driver);
	}

}
