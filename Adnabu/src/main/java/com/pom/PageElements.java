package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageElements {
	
	WebDriver driver;

	public PageElements(WebDriver driver1) {
		this.driver = driver1;
		PageFactory.initElements(driver1, this);
	}

	@FindBy(xpath = "//button[@class='btn--link site-header__icon site-header__search-toggle js-drawer-open-top']")
	private WebElement SearchIcon;
	
	@FindBy(xpath = "//button[@class='search-bar__submit search__submit btn--link']")
	private WebElement SearchButton;

	@FindBy(xpath = "//a[@class='full-width-link']")
	private WebElement ProductDesc;

	@FindBy(xpath = "//span[.='Catalog']")
	private WebElement CatalogMenu;
	
	@FindBy(id = "FilterTags")
	private WebElement FilterMenu;

	@FindBy(xpath = "//span[.='Home']")
	private WebElement Home;

	@FindBy(xpath = "//li[@class='grid__item grid__item--featured-collections small--one-half medium-up--one-third']")
	private WebElement Product;

	@FindBy(xpath = "//button[@class='btn product-form__cart-submit btn--secondary-accent']")
	private WebElement AddCartButton;

	@FindBy(xpath = "//a[.='Remove']")
	private WebElement RemoveButton;

	@FindBy(xpath = "//img[@alt='14k Solid Bloom Earrings']")
	private WebElement ProImg;

	@FindBy(xpath = "//p[@class='cart--empty-message']")
	private WebElement EmptyMessage;


	public WebElement getSearchIcon() {
		return SearchIcon;
	}

	public WebElement getSearchButton() {
		return SearchButton;
	}

	public WebElement getProductDesc() {
		return ProductDesc;
	}

	public WebElement getCatalogMenu() {
		return CatalogMenu;
	}

	public WebElement getFilterMenu() {
		return FilterMenu;
	}

	public WebElement getHome() {
		return Home;
	}

	public WebElement getProduct() {
		return Product;
	}

	public WebElement getAddCartButton() {
		return AddCartButton;
	}

	public WebElement getRemoveButton() {
		return RemoveButton;
	}

	public WebElement getProImg() {
		return ProImg;
	}

	public WebElement getEmptyMessage() {
		return EmptyMessage;
	}

	

}
