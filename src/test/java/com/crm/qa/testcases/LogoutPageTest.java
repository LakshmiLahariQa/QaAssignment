package com.crm.qa.testcases;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.Pages.CheckoutPage;
import com.crm.qa.Pages.LoginPage;
import com.crm.qa.Pages.LogoutPage;
import com.crm.qa.Pages.ProductsPage;
import com.crm.qa.base.TestBase;

public class LogoutPageTest extends TestBase{
	
	LoginPage loginPage;
	ProductsPage productspage;
	CheckoutPage checkoutpage;
	LogoutPage  logoutpage;

	public LogoutPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		productspage = new ProductsPage();
		checkoutpage = new CheckoutPage();
		logoutpage = new LogoutPage();
		productspage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	
	@Test
	public void verifyLogoutPage() {
		logoutpage.NavigateLogoutPage();
				
	}

	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	

}
