package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.DriverManager;
import io.appium.java_client.AppiumBy;
import utils.TestUtils;

public class MedicoE2EFlow extends DriverManager {

	private TestUtils utils;
	@Test
	public void medicoPositiveFlow() throws InterruptedException {
		
		medicoDriver.findElement(By.xpath(".//*[@content-desc='Next']")).click();
		Thread.sleep(1000);
		medicoDriver.findElement(By.xpath(".//*[@content-desc='Next']")).click();
		medicoDriver.findElement(AppiumBy.accessibilityId("Get Started")).click();

		medicoDriver.findElement(By.xpath("//android.view.View[@content-desc=\"English\n" + "A\"]")).click();
		medicoDriver.findElement(AppiumBy.accessibilityId("Next")).click();

		medicoDriver.findElement(AppiumBy.accessibilityId("Medico")).click();
		medicoDriver.findElement(By.xpath("//android.view.View[@content-desc=\"Mobile Number\"]/following-sibling::android.widget.EditText")).click();
		medicoAction.sendKeys("soubhik111das@gmail.com").perform();
		
		medicoDriver.hideKeyboard();
		medicoDriver.findElement(By.xpath("//android.view.View[@content-desc=\"Version V2.16.6+209\"]/android.view.View/android.widget.EditText[2]")).click();
		medicoAction.sendKeys("Test@456").perform();
		medicoDriver.hideKeyboard();
		medicoDriver.findElement(AppiumBy.accessibilityId("Sign In")).click();

		WebElement nextBtn = medicoDriver.findElement(AppiumBy.accessibilityId("Next"));
		if (nextBtn.isDisplayed())
			nextBtn.click();
		// Home page
		
		medicoDriver.findElement(AppiumBy.accessibilityId("20\n"+ "May")).click();
		medicoDriver.findElement(AppiumBy.accessibilityId("Add an Offline Appointment")).click();

		// Patient Information Page
		medicoDriver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[3]")).click();
		medicoAction.sendKeys("vishnu.kumar@manastik.com").perform();
		medicoDriver.findElement(
				By.xpath("//android.widget.EditText[@text=\"vishnu.kumar@manastik.com\"]/android.widget.Button"))
				.click();
		medicoDriver.findElement(AppiumBy.accessibilityId("Register")).click();

		medicoDriver.findElement(AppiumBy.accessibilityId("Start Appointment")).click();

		Thread.sleep(2000);
		medicoDriver.findElement(By.xpath(
				"//android.view.View[@content-desc=\"Add Symptoms\"]/following-sibling::android.widget.EditText"))
				.click();

		medicoDriver.findElement(AppiumBy.accessibilityId("Memory loss")).click();

		medicoDriver.findElement(
				By.xpath("//android.view.View[@content-desc=\"History\"]/following-sibling::android.widget.EditText"))
				.click();
		medicoDriver.findElement(
				By.xpath("//android.view.View[@content-desc=\"History\"]/following-sibling::android.widget.EditText"))
				.clear();
		medicoAction.sendKeys("Text by automation script").perform();
		medicoDriver.hideKeyboard();

		medicoDriver.findElement(
				By.xpath("//android.view.View[@content-desc=\"Medical History\"]/following-sibling::android.widget.EditText"))
				.click();
		medicoDriver.findElement(
				By.xpath("//android.view.View[@content-desc=\"Medical History\"]/following-sibling::android.widget.EditText"))
				.clear();
		medicoAction.sendKeys("Text by automation script").perform();
		medicoDriver.hideKeyboard();
		
		// Uploading dummy image for test report
		medicoDriver.findElement(AppiumBy.accessibilityId("Upload Tests or Reports ")).click();
		medicoDriver.findElement(AppiumBy.accessibilityId("Camera")).click();
		medicoDriver.findElement(AppiumBy.accessibilityId("Shutter")).click();
		medicoDriver.findElement(AppiumBy.accessibilityId("Done")).click();
		medicoDriver.findElement(AppiumBy.accessibilityId("Upload")).click();
		medicoDriver.findElement(AppiumBy.accessibilityId("Next")).click();
		
		// Add cognitive tests page
		medicoDriver.findElement(AppiumBy.accessibilityId("NPI")).click();
		medicoDriver.findElement(AppiumBy.accessibilityId("MoCA")).click();
		medicoDriver.findElement(AppiumBy.accessibilityId("MMSE")).click();
		medicoDriver.findElement(AppiumBy.accessibilityId("IADL - EDR")).click();
		medicoDriver.findElement(AppiumBy.accessibilityId("GDS")).click();
		medicoDriver.findElement(AppiumBy.accessibilityId("Modified Barthel ADL Index")).click();
		medicoDriver.findElement(AppiumBy.accessibilityId("Functional Activities Assessment Tool")).click();
		medicoDriver.findElement(AppiumBy.accessibilityId("AD8 Dementia Screening")).click();
		medicoDriver.findElement(AppiumBy.accessibilityId("Next")).click();
		
		// Appoint people page
		medicoDriver.findElement(By.xpath("//android.view.View[@content-desc=\"1. ACE - III\"]/following-sibling::android.widget.Button")).click();
		medicoDriver.findElement(By.xpath("//android.widget.Button")).click();
		
		medicoDriver.findElement(By.xpath("//android.view.View[@content-desc=\"2. CDR\"]/following-sibling::android.widget.Button")).click();
		medicoDriver.findElement(AppiumBy.accessibilityId("Self")).click();
		
		medicoDriver.findElement(AppiumBy.accessibilityId("Next")).click();
		
		//Patients Test page
		medicoDriver.findElement(AppiumBy.accessibilityId("Start")).click();		
		Thread.sleep(1000);

		utils.action_clickOnPosition(medicoDriver, 555, 2026);
		Thread.sleep(1500);
		utils.action_clickOnPosition(medicoDriver,638, 590);
		utils.action_clickOnPosition(medicoDriver,104, 1406);

	}
}
