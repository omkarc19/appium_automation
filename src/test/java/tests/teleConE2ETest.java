package tests;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import base.BaseTest;
import io.appium.java_client.AppiumBy;
import utils.TestUtils;

public class teleConE2ETest extends BaseTest {

	private TestUtils utils;
	@Test
	public void medicoPositiveFlow() throws InterruptedException, MalformedURLException {
		
//		driver.findElement(By.xpath(".//*[@content-desc='Next']")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath(".//*[@content-desc='Next']")).click();
//		driver.findElement(AppiumBy.accessibilityId("Get Started")).click();
//
//		driver.findElement(By.xpath("//android.view.View[@content-desc=\"English\n" + "A\"]")).click();
//		driver.findElement(AppiumBy.accessibilityId("Next")).click();
//
//		driver.findElement(AppiumBy.accessibilityId("Medico")).click();
//		driver.findElement(AppiumBy.accessibilityId("TEST")).click();
//		driver.findElement(AppiumBy.accessibilityId("PROD")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//android.widget.EditText[@hint='Email\nEmail Id']")).click();
//		action.sendKeys("soubhik111das@gmail.com").perform();
//		
//		driver.hideKeyboard();
//		driver.findElement(By.xpath("//android.widget.EditText[@hint='Password\nPassword']")).click();
//		action.sendKeys("Test@456").perform();
//		driver.hideKeyboard();
//		driver.findElement(AppiumBy.accessibilityId("Sign In")).click();
		
		// User Phone
		setupUserDriver();
		userDriver.findElement(By.xpath(".//*[@content-desc='Next']")).click();
		Thread.sleep(1000);
		userDriver.findElement(By.xpath(".//*[@content-desc='Next']")).click();
		userDriver.findElement(AppiumBy.accessibilityId("Get Started")).click();

		userDriver.findElement(By.xpath("//android.view.View[@content-desc=\"English\n" + "A\"]")).click();
		userDriver.findElement(AppiumBy.accessibilityId("Next")).click();

		userDriver.findElement(AppiumBy.accessibilityId("User")).click();
		userDriver.findElement(AppiumBy.accessibilityId("TEST")).click();
		userDriver.findElement(AppiumBy.accessibilityId("PROD")).click();
		Thread.sleep(1000);
		userDriver.findElement(By.xpath("//android.widget.EditText[@hint='Email\nEmail Id']")).click();
		userAction.sendKeys("vishnu.kumar@manastik.com").perform();		
		userDriver.hideKeyboard();
		
		userDriver.findElement(By.xpath("//android.widget.EditText[@hint='Password\nPassword']")).click();
		userAction.sendKeys("Test@123").perform();
		userDriver.hideKeyboard();
		userDriver.findElement(AppiumBy.accessibilityId("Sign In")).click();
		
//		WebElement element = driver.findElement(By.xpath("//android.view.View[@content-desc=\"Consult our top experts\"]"));
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		Map<String, Object> params = new HashMap<String, Object>();
//		params.put("element", ((RemoteWebElement) element).getId());
//		params.put("direction", "down");
//		js.executeScript("mobile: scroll", params);


	}
}
