package tests;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.BaseTest;
import io.appium.java_client.AppiumBy;
import utils.TestUtils;

public class teleConE2ETest extends BaseTest {

	private TestUtils utils;
	@Test
	public void medicoPositiveFlow() throws InterruptedException, MalformedURLException {
		
		driver.findElement(By.xpath(".//*[@content-desc='Next']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@content-desc='Next']")).click();
		driver.findElement(AppiumBy.accessibilityId("Get Started")).click();

		driver.findElement(By.xpath("//android.view.View[@content-desc=\"English\n" + "A\"]")).click();
		driver.findElement(AppiumBy.accessibilityId("Next")).click();

		driver.findElement(AppiumBy.accessibilityId("Medico")).click();
		driver.findElement(By.xpath("//android.view.View[@content-desc=\"Mobile Number\"]/following-sibling::android.widget.EditText")).click();
		driver.setClipboardText("soubhik111das@gmail.com");
		String email = driver.getClipboardText();
		action.sendKeys(email).perform();
		
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.view.View[@content-desc=\"Version V2.16.6+209\"]/android.view.View/android.widget.EditText[2]")).click();
		driver.setClipboardText("Test@456");
		String pwd = driver.getClipboardText();		
		action.sendKeys(pwd).perform();
		driver.hideKeyboard();
		driver.findElement(AppiumBy.accessibilityId("Sign In")).click();
		
		// User Phone
		setupUserDriver();
		userDriver.findElement(By.xpath(".//*[@content-desc='Next']")).click();
		Thread.sleep(1000);
		userDriver.findElement(By.xpath(".//*[@content-desc='Next']")).click();
		userDriver.findElement(AppiumBy.accessibilityId("Get Started")).click();

		userDriver.findElement(By.xpath("//android.view.View[@content-desc=\"English\n" + "A\"]")).click();
		userDriver.findElement(AppiumBy.accessibilityId("Next")).click();

		userDriver.findElement(AppiumBy.accessibilityId("User")).click();
		userDriver.findElement(By.xpath("//android.view.View[@content-desc=\"Mobile Number\"]/following-sibling::android.widget.EditText[1]")).click();
		userDriver.setClipboardText("vishnu.kumar@manastik.com");
		String email1 = userDriver.getClipboardText();
		System.out.println(email1);
		action.sendKeys(email1).perform();
		
		userDriver.hideKeyboard();
		userDriver.findElement(By.xpath("//android.view.View[@content-desc=\"Version V2.16.6+209\"]/android.view.View/android.widget.EditText[2]")).click();
		userDriver.setClipboardText("Test@123");
		String pwd1 = userDriver.getClipboardText();		
		action.sendKeys(pwd1).perform();
		userDriver.hideKeyboard();
		userDriver.findElement(AppiumBy.accessibilityId("Sign In")).click();
		
	}
}
