package tests;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

//@Listeners(AdNabuTest.ScreenshotListener.class)
@Listeners({org.testng.reporters.EmailableReporter.class})
public class AdNabuTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
      
        System.setProperty("webdriver.Firefox.driver", "E:\\softwares\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize(); 

    	
        /* 
        System.setProperty("webdriver.ChromeDriver.driver", "E:\\softwares\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize(); 
        */
    	
    	
        /* 
        System.setProperty("webdriver.edge.driver", "E:\\softwares\\msedgedriver.exe");
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        */
        
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testScenario() throws InterruptedException {
        // Scenario 1: product search
        driver.get("https://adnabu-arjun.myshopify.com/");
        WebElement search = driver.findElement(By.cssSelector("div#shopify-section-header input[name=\"q\"]"));

        // Scenario 1a: Entering a valid keyword in the search bar.
        search.sendKeys("pendant", Keys.ENTER);
        Thread.sleep(2000);
        Assert.assertTrue(driver.getTitle().contains("Search"));

        // Scenario 2: Catalog filter search
        driver.findElement(By.xpath("(//span[@class='site-nav__label'])[2]")).click();

        // Scenario 2a: Verifying that only products from the selected category are displayed.
        WebElement dropdownElement = driver.findElement(By.id("FilterTags"));
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText("White Gold");
        Thread.sleep(2000);
        Assert.assertTrue(driver.getPageSource().contains("White Gold"));

        // Scenario 3: Verifying that only sorted category is displayed.
        WebElement sortbyElement = driver.findElement(By.id("SortBy"));
        Select sortby = new Select(sortbyElement);
        sortby.selectByValue("price-ascending");
        Thread.sleep(2000);
        

        // Scenario 4: Add a product to the shopping cart.
        driver.findElement(By.linkText("14k Interlinked Earrings")).click();
        driver.findElement(By.name("add")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Continue shopping")).click();
        Thread.sleep(2000);
  

        // Scenario 5: Add one more product to the shopping cart.
        driver.findElement(By.linkText("14k Solid Bloom Earrings")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("add")).click();
        Thread.sleep(2000);

        // Scenario 6: Update quantity in the cart.
        WebElement qty = driver.findElement(By.name("updates[]"));
        qty.clear();
        qty.sendKeys("3", Keys.ENTER);
        Thread.sleep(2000);
        

        // Scenario 7: Remove product from the shopping cart.
        driver.findElement(By.xpath("//a[@class='text-link text-link--accent'][normalize-space()='Remove']")).click();
        
    }

    public WebDriver getDriver() {
        return driver;
    }
    public static class ScreenshotListener implements ITestListener {
        @Override
        public void onTestFailure(ITestResult result) {
            System.out.println("Test Failed! Taking Screenshot...");

            // Get the WebDriver instance from the test result
            Object testInstance = result.getInstance();
            if (testInstance instanceof AdNabuTest) {
                WebDriver driver = ((AdNabuTest) testInstance).getDriver();
                if (driver != null) {
                    takeScreenshot(driver, result.getMethod().getMethodName());
                }
            }

            // Print a failure message
            System.out.println("Test Method '" + result.getMethod().getMethodName() + "' failed!");
        }

        private void takeScreenshot(WebDriver driver, String methodName) {
            try {
                // Capture and save the screenshot
                File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                String screenshotPath = "screenshots/" + methodName + "_failure.png";
                FileUtils.copyFile(screenshotFile, new File(screenshotPath));
                System.out.println("Screenshot captured: " + screenshotPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    }


