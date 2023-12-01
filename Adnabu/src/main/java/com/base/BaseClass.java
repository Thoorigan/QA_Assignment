package com.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
public static WebDriver driver;
	

public static void waitForElementToBeClickable(WebElement element) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    wait.until(ExpectedConditions.elementToBeClickable(element));
}

	public static WebDriver launchBrowser(String browser) {
		   if (driver == null) {
	            if (browser.equalsIgnoreCase("chrome")) {
	                driver = new ChromeDriver();
	            } 
	            else if (browser.equalsIgnoreCase("edge")) 
	            {
	                driver = new EdgeDriver();
	            } else if (browser.equalsIgnoreCase("Firefox")) 
	            {
	                driver = new FirefoxDriver();
	            } else {
	                throw new IllegalArgumentException("Unsupported browser: " + browser);
	            }
	            driver.manage().window().maximize();
	            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	        }
	        return driver;
	    }
	
	public static void enterUrl(String url) {
		try {
	        driver.get(url);
	    } catch (Exception e) {
	        // Handle the exception (e.g., log, throw, or report)
	        e.printStackTrace();
	    }
	}
	
	public static void closeBrowser() {
		driver.quit();
		 driver = null; // Optional: nullify the driver instance
	}

	public static void enterText(WebElement element,String text) {
	   	
       element.sendKeys(text);  
	}
	
	public static void refresh() {
		driver.navigate().refresh();
	}

	public static void backward() {
		driver.navigate().back();
	}
	
	public static void clickButton(WebElement element) {
		element.click();
	}

	public static String getText(WebElement element) {
		String text=element.getText();
		return text;
	}

}
