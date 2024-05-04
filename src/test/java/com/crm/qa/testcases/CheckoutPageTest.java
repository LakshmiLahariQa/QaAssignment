package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.Pages.CheckoutPage;
import com.crm.qa.Pages.LoginPage;
import com.crm.qa.Pages.LogoutPage;
import com.crm.qa.Pages.ProductsPage;
import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class CheckoutPageTest extends TestBase{
	
	LoginPage loginPage;
	ProductsPage productspage;
	CheckoutPage checkoutpage;
	LogoutPage  logoutpage;
	TestUtil    testutil;

	String sheetName = "Checkoutinfo";
	public CheckoutPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		testutil = new TestUtil();
		productspage = new ProductsPage();
		checkoutpage = new CheckoutPage();
		productspage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		checkoutpage = productspage.selectProductsByName(prop.getProperty("productsname"));
	}

	@DataProvider
	public Object[][] getCheckouTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	
	@Test(dataProvider="getCheckouTestData")
	public void verifyCheckoutPage(String firstName, String lastName, String postalcode) {
		boolean flag = checkoutpage.CheckoutProducts();
		Assert.assertTrue(flag);
		logoutpage = checkoutpage.Checkoutinformation(firstName, lastName, postalcode);
		
	}

	

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	 

	

}
