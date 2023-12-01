package com.runner;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.base.BaseClass;
import com.helper.FileReaderManager;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"C:\\Users\\RAM\\Desktop\\Adnabu\\src\\test\\java\\com\\featurefile"},
		glue = {"com.stepdefenition"},
		snippets = SnippetType.CAMELCASE,
        publish = true,
		monochrome = true,
		dryRun =! true,
		stepNotifications = true,
		tags = "@Adnabu",
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }
			)


public class RunnerTest {
	public static WebDriver driver;
	@BeforeClass
	public static void openBrowser() throws IOException {
 driver=BaseClass.launchBrowser(FileReaderManager.getInstance().getcrInstance().getBrowser());
 
} @BeforeClass
	public static void setUp() throws IOException {
    FileReaderManager.getInstance(); // Initialize FileReaderManager
}
	@AfterClass
	public static void closeBrowser() {
	    if (driver != null) {
	        driver.quit();
	    }
	}
}
