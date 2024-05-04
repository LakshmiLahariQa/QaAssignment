package com.crm.qa.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ProductsPage extends TestBase {
	
	//Pagefactory ---OR
	
	@FindBy(className="app_logo")
	WebElement productpageLogo;
	
	@FindBy(id="add-to-cart")
	WebElement addtocart;
	
	@FindBy(name="back-to-products")
	WebElement backtoproducts;
	
	
	// Initializing the Page Objects:
	public ProductsPage() {
			PageFactory.initElements(driver, this);
		}

	public boolean verifyProductsLabel() {
		return productpageLogo.isDisplayed();
	}

	public CheckoutPage selectProductsByName(String name) {

		driver.findElement(By.xpath("//div[contains(@class,'inventory_item_name ')and contains(text(),'" + name + "')]")).click();
		addtocart.click();
		backtoproducts.click();
		return new CheckoutPage();
	}

}
