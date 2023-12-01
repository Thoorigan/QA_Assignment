package com.stepdefenition;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.base.BaseClass;
import com.helper.FileReaderManager;
import com.helper.PageObjectManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDef extends BaseClass {

	private WebDriver driver;
    private PageObjectManager pom;
    
    public StepDef() throws IOException {
    	this.driver = BaseClass.launchBrowser(FileReaderManager.getInstance().getcrInstance().getBrowser());
        this.pom = new PageObjectManager(driver);
    }
    

	@Given("User launch the Adnabu appliction")
	public void userLaunchTheAdnabuAppliction() throws IOException {
		enterUrl(FileReaderManager.getInstance().getcrInstance().getAddress());
	}

	@When("User enter the keyword and search")
	public void userEnterTheKeywordAndSearch() throws IOException {
		clickButton(pom.getPe().getSearchIcon());
		enterText(driver.switchTo().activeElement(), FileReaderManager.getInstance().getcrInstance().getKeyWord());
		clickButton(pom.getPe().getSearchButton());
	}

	@Then("Verify that user should get related results")
	public void verifyThatUserShouldGetRelatedResults() throws IOException {
		if (getText(pom.getPe().getProductDesc())
				.contains(FileReaderManager.getInstance().getcrInstance().getKeyWord())) {
			System.out.println("Search product displayed successfully");
		} else {
			System.out.println("Search product Not displayed ");
		}

	}

	@When("User click the Catalog button and select filter option")
	public void userClickTheCatalogButtonAndSelectFilterOption() throws IOException {
		clickButton(pom.getPe().getCatalogMenu());
		Select s = new Select(pom.getPe().getFilterMenu());
		s.selectByVisibleText(FileReaderManager.getInstance().getcrInstance().getFiterOption());
	}

	@Then("Verify that user should get fitered results")
	public void verifyThatUserShouldGetFiteredResults() throws IOException {
		if (driver.getTitle().contains(FileReaderManager.getInstance().getcrInstance().getFiterOption())) {
			System.out.println("Filtering Option Verified successfully");
		} else {
			System.out.println(" Filtering Option Verification Faild");
		}
	}

	@When("User goto the Homepage and click on a Product")
	public void userGotoTheHomepageAndClickOnAProduct() {
		clickButton(pom.getPe().getHome());
		clickButton(pom.getPe().getProduct());
	}

	@And("User click the Add To Cart button")
	public void userClickTheAddToCartButton() {
		clickButton(pom.getPe().getAddCartButton());
	}

	@Then("Verify that product should added to the Cart page")
	public void verifyThatProductShouldAddedToTheCartPage() {
		if (pom.getPe().getProImg().isDisplayed()) {
			System.out.println("Product Added into Cart successfully");
		} else {
			System.out.println("Product Not Added into Cart");
		}

	}

	@When("User click the Remove button")
	public void userClickTheRemoveButton() {
		clickButton(pom.getPe().getRemoveButton());
	}

	@Then("Verify that product should Removed from Cart page")
	public void verifyThatProductShouldRemovedFromCartPage() {
		if ((pom.getPe().getEmptyMessage()).isDisplayed()) {
			System.out.println("Product Removed From Cart successfully");
		} else {
			System.out.println("Product Not Removed From Cart");
		}
		closeBrowser();
	}


}
