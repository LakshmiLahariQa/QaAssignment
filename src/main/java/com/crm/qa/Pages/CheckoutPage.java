package com.crm.qa.Pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class CheckoutPage extends TestBase{
	
	//Pagefactory ---OR
	
		@FindBy(xpath ="//a[contains(@class,'shopping_cart_link')]")
		WebElement cartlink;
		
		@FindBy(id="checkout")
		WebElement checkoutbtn;
		
		@FindBy(name="firstName")
		WebElement firstnameinput;
		
		@FindBy(name="lastName")
		WebElement lastnameinput;
		
		@FindBy(name="postalCode")
		WebElement postalCodeinput;
		
		@FindBy(id="continue")
		WebElement continuebtn;
		
		@FindBy(id="finish")
		WebElement finishbtn;
		
		@FindBy(name="back-to-products")
		WebElement backtoproductslink;
		
		@FindBy(xpath ="//button[contains(@id,'react-burger-menu-btn')and contains(text(),'Open Menu')]")
		WebElement openmenulink;
			
		
		// Initializing the Page Objects:
		public CheckoutPage() {
				PageFactory.initElements(driver, this);
			}

		public boolean CheckoutProducts() {

			
			cartlink.click();
			checkoutbtn.click();
			return firstnameinput.isDisplayed();
			
		}
		
		public LogoutPage Checkoutinformation(String firstName, String lastName, String postalcode) {

			firstnameinput.clear();
			firstnameinput.sendKeys(firstName);
			lastnameinput.sendKeys(lastName);
			postalCodeinput.sendKeys(postalcode);
			continuebtn.click();
			finishbtn.click();
			backtoproductslink.click();
			Actions action = new Actions(driver);
			action.moveToElement(openmenulink).build().perform();
			openmenulink.click();
			return new LogoutPage();
		}

	
}
