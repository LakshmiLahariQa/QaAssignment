package QAassign;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class launchbrowser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver1 = new ChromeDriver();
		//WebDriver driver1 = new FirefoxDriver();
		//WebDriver driver1 = new EdgeDriver();
		
		driver1.get("https://www.saucedemo.com/");
		System.out.println(driver1.getTitle());
		String Url = driver1.getCurrentUrl();
		if ( Url.equals("https://www.saucedemo.com/")){
			
			System.out.println("correct url launched");	
		}
		else {
			System.out.println("Incorrect url launched");
			
			
			}
		String title = driver1.getTitle();
		System.out.println("title of url launched is :" +title);
		driver1.findElement(By.name("user-name")).sendKeys("standard_user");
		driver1.findElement(By.name("password")).sendKeys("secret_sauce");
		driver1.findElement(By.id("login-button")).click();
		driver1.findElement(By.className("app_logo"));
		String logoname = driver1.findElement(By.className("app_logo")).getText();
		System.out.println("Logo of url launched is :" +logoname);
		//<div class="inventory_item_name " data-test="inventory-item-name">Sauce Labs Bolt T-Shirt</div>
		//String attribute = driver1.findElement(By.xpath("//div[@class='inventory_item_name ']
		String name = "Sauce Labs Backpack";
		driver1.findElement(By.xpath("//div[contains(@class,'inventory_item_name ')and contains(text(),'"+name+"')]")).click();
		driver1.findElement(By.id("add-to-cart")).click();
		driver1.findElement(By.name("back-to-products")).click();
		driver1.findElement(By.xpath("//a[contains(@class,'shopping_cart_link')]")).click();
		driver1.findElement(By.id("checkout")).click();
		driver1.findElement(By.name("firstName")).sendKeys("standard_user");
		driver1.findElement(By.name("lastName")).sendKeys("secret_sauce");
		driver1.findElement(By.name("postalCode")).sendKeys("100987");
		driver1.findElement(By.id("continue")).click();
		driver1.findElement(By.id("finish")).click();
		driver1.findElement(By.name("back-to-products")).click();
		driver1.findElement(By.xpath("//button[contains(@id,'react-burger-menu-btn')and contains(text(),'Open Menu')]")).click();
		WebElement ele =driver1.findElement(By.xpath("//a[contains(@id,'logout_sidebar_link')and contains(text(),'Logout')]"));
		//WebElement ele = driver.findElement(By.xpath("element_xpath"));
		JavascriptExecutor executor = (JavascriptExecutor)driver1;
		executor.executeScript("arguments[0].click();", ele);
		//driver1.quit();
		
		}
		
}


