package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.BaseTest;
import io.appium.java_client.AppiumBy;
import utils.TestUtils;

public class medicoE2EFlow extends BaseTest {

	private TestUtils utils;
	@Test
	public void medicoPositiveFlow() throws InterruptedException {
		
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

		WebElement nextBtn = driver.findElement(AppiumBy.accessibilityId("Next"));
		if (nextBtn.isDisplayed())
			nextBtn.click();
		// Home page
		
		driver.findElement(AppiumBy.accessibilityId("20\n"+ "May")).click();
		driver.findElement(AppiumBy.accessibilityId("Add an Offline Appointment")).click();

		// Patient Information Page
		driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[3]")).click();
		action.sendKeys("vishnu.kumar@manastik.com").perform();
		driver.findElement(
				By.xpath("//android.widget.EditText[@text=\"vishnu.kumar@manastik.com\"]/android.widget.Button"))
				.click();
		driver.findElement(AppiumBy.accessibilityId("Register")).click();

		driver.findElement(AppiumBy.accessibilityId("Start Appointment")).click();

		Thread.sleep(2000);
		driver.findElement(By.xpath(
				"//android.view.View[@content-desc=\"Add Symptoms\"]/following-sibling::android.widget.EditText"))
				.click();

		driver.findElement(AppiumBy.accessibilityId("Memory loss")).click();

		driver.findElement(
				By.xpath("//android.view.View[@content-desc=\"History\"]/following-sibling::android.widget.EditText"))
				.click();
		driver.findElement(
				By.xpath("//android.view.View[@content-desc=\"History\"]/following-sibling::android.widget.EditText"))
				.clear();
		action.sendKeys("Text by automation script").perform();
		driver.hideKeyboard();

		driver.findElement(
				By.xpath("//android.view.View[@content-desc=\"Medical History\"]/following-sibling::android.widget.EditText"))
				.click();
		driver.findElement(
				By.xpath("//android.view.View[@content-desc=\"Medical History\"]/following-sibling::android.widget.EditText"))
				.clear();
		action.sendKeys("Text by automation script").perform();
		driver.hideKeyboard();
		
		// Uploading dummy image for test report
		driver.findElement(AppiumBy.accessibilityId("Upload Tests or Reports ")).click();
		driver.findElement(AppiumBy.accessibilityId("Camera")).click();
		driver.findElement(AppiumBy.accessibilityId("Shutter")).click();
		driver.findElement(AppiumBy.accessibilityId("Done")).click();
		driver.findElement(AppiumBy.accessibilityId("Upload")).click();
		driver.findElement(AppiumBy.accessibilityId("Next")).click();
		
		// Add cognitive tests page
		driver.findElement(AppiumBy.accessibilityId("NPI")).click();
		driver.findElement(AppiumBy.accessibilityId("MoCA")).click();
		driver.findElement(AppiumBy.accessibilityId("MMSE")).click();
		driver.findElement(AppiumBy.accessibilityId("IADL - EDR")).click();
		driver.findElement(AppiumBy.accessibilityId("GDS")).click();
		driver.findElement(AppiumBy.accessibilityId("Modified Barthel ADL Index")).click();
		driver.findElement(AppiumBy.accessibilityId("Functional Activities Assessment Tool")).click();
		driver.findElement(AppiumBy.accessibilityId("AD8 Dementia Screening")).click();
		driver.findElement(AppiumBy.accessibilityId("Next")).click();
		
		// Appoint people page
		driver.findElement(By.xpath("//android.view.View[@content-desc=\"1. ACE - III\"]/following-sibling::android.widget.Button")).click();
		driver.findElement(By.xpath("//android.widget.Button")).click();
		
		driver.findElement(By.xpath("//android.view.View[@content-desc=\"2. CDR\"]/following-sibling::android.widget.Button")).click();
		driver.findElement(AppiumBy.accessibilityId("Self")).click();
		
		driver.findElement(AppiumBy.accessibilityId("Next")).click();
		
		//Patients Test page
		driver.findElement(AppiumBy.accessibilityId("Start")).click();		
		Thread.sleep(1000);

		utils.action_clickOnPosition(555, 2026);
		Thread.sleep(1500);
		utils.action_clickOnPosition(638, 590);
		utils.action_clickOnPosition(104, 1406);
		
		utils.swipeToEnd("down", 0.70);
		
		utils.swipeTillTextVisible("How is the Community Affairs?", "down", 0.20, 5);
//		driver.findElement(AppiumBy.accessibilityId("Next")).click();
	}
}
