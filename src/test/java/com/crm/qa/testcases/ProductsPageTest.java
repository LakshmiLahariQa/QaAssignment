package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.Pages.CheckoutPage;
import com.crm.qa.Pages.LoginPage;
import com.crm.qa.Pages.ProductsPage;
import com.crm.qa.base.TestBase;

public class ProductsPageTest extends TestBase {

	LoginPage loginPage;
	ProductsPage productspage;
	CheckoutPage checkoutpage;

	public ProductsPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		productspage = new ProductsPage();
		checkoutpage = new CheckoutPage();
		productspage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 1)
	public void verifyProductsLogo() {
		boolean flag = productspage.verifyProductsLabel();
		Assert.assertTrue(flag);
	}

	@Test(priority = 2)
	public void AddProductstoCart() {
		checkoutpage = productspage.selectProductsByName(prop.getProperty("productsname"));
	}

	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	 

}
