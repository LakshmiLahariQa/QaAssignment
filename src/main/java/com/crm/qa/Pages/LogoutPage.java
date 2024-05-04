package com.crm.qa.Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class LogoutPage extends TestBase {

//Pagefactory ---OR
	
	@FindBy(xpath="//a[contains(@id,'logout_sidebar_link')and contains(text(),'Logout')])")
	WebElement logoutbtn;
	
	@FindBy(xpath ="//button[contains(@id,'react-burger-menu-btn')and contains(text(),'Open Menu')]")
	WebElement openmenulink;
	
	@FindBy(className ="login_logo")
	WebElement weblogo;
	
	
	// Initializing the Page Objects:
	public LogoutPage() {
			PageFactory.initElements(driver, this);
		}
	public  boolean NavigateLogoutPage() {
		Actions action = new Actions(driver);
		action.moveToElement(openmenulink).build().perform();
		openmenulink.click();
		//driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		WebElement ele =driver.findElement(By.xpath("//a[contains(@id,'logout_sidebar_link')and contains(text(),'Logout')]"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ele);
		return weblogo.isDisplayed();
		
	}

}
