package tests;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.text.Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import base.BaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import utils.TestUtils;

public class teleConE2ETest extends BaseTest {

	private TestUtils utils;
	@Test
	public void medicoPositiveFlow() throws InterruptedException, MalformedURLException {

		// User Phone
		
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
		userAction.sendKeys("omkar2chougale@gmail.com").perform();		
		userDriver.hideKeyboard();
		
		userDriver.findElement(By.xpath("//android.widget.EditText[@hint='Password\nPassword']")).click();
		userAction.sendKeys("Test@123").perform();
		userDriver.hideKeyboard();
		userDriver.findElement(AppiumBy.accessibilityId("Sign In")).click();
		
		utils.swipeUp(userDriver);
		utils.scrollToTextUntilEnd(userDriver, "Consult our top experts");
		userDriver.findElement(AppiumBy.xpath("//android.view.View[@content-desc=\"View All\"]")).click();
		
		userDriver.findElement(By.xpath("(//android.view.View[@content-desc=\"Book\"])[1]")).click();
		Thread.sleep(1000);
		userDriver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.Button\").instance(1)")).click();
		userDriver.findElement(AppiumBy.accessibilityId("26, Monday, May 26, 2025")).click();
		userDriver.findElement(AppiumBy.accessibilityId("OK")).click();
		userDriver.findElement(By.xpath("//android.view.View[@content-desc=\"Select the time slot\"]/following-sibling::android.view.View")).click();
		
		userDriver.findElement(AppiumBy.accessibilityId("Book")).click();	
		Thread.sleep(1000);
		userDriver.findElement(AppiumBy.accessibilityId("Book")).click();
		userDriver.findElement(By.xpath("//android.widget.Button")).click();
		
		
		// Medico phone
		driver.findElement(By.xpath(".//*[@content-desc='Next']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@content-desc='Next']")).click();
		driver.findElement(AppiumBy.accessibilityId("Get Started")).click();

		driver.findElement(By.xpath("//android.view.View[@content-desc=\"English\n" + "A\"]")).click();
		driver.findElement(AppiumBy.accessibilityId("Next")).click();

		driver.findElement(AppiumBy.accessibilityId("Medico")).click();
		driver.findElement(AppiumBy.accessibilityId("TEST")).click();
		driver.findElement(AppiumBy.accessibilityId("PROD")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//android.widget.EditText[@hint='Email\nEmail Id']")).click();
		action.sendKeys("soubhik111das@gmail.com").perform();
		
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.EditText[@hint='Password\nPassword']")).click();
		action.sendKeys("Test@456").perform();
		driver.hideKeyboard();
		driver.findElement(AppiumBy.accessibilityId("Sign In")).click();
		
		
		driver.findElement(AppiumBy.accessibilityId("Pending appointment requests")).click();
		driver.findElement(AppiumBy.accessibilityId("Accept")).click();
		
		driver.findElement(By.xpath("//android.view.View[@content-desc=\"View All\"]")).click();
		
		utils.scrollToTextUntilEnd(driver, "Automation user");
		driver.findElement(By.xpath("//*[contains(@content-desc, 'Automation user')]")).click();
		
		driver.findElement(AppiumBy.accessibilityId("Start Appointment")).click();
		
		Thread.sleep(3000);
	
		// User Phone
		 ((AndroidDriver) userDriver).openNotifications();
		 userDriver.findElement(By.id("com.manastik.dadt:id/llAccept")).click();
		 
		// Medico Phone
		 driver.findElement(AppiumBy.accessibilityId("Toggle Picture-in-Picture mode")).click();
	}
}
