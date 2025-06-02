package utils;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.MouseButton;
import org.openqa.selenium.interactions.PointerInput.Origin;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import base.DriverManager;

public class TestUtils extends DriverManager {
	
	public static RemoteWebDriver driver;
	
	public static void action_clickOnPosition(AndroidDriver driver, int pointA_X, int pointA_Y) {
		PointerInput finger = new PointerInput(org.openqa.selenium.interactions.PointerInput.Kind.TOUCH, "finger");
		org.openqa.selenium.interactions.Sequence clickPosition = new org.openqa.selenium.interactions.Sequence(finger,
				1);

		clickPosition.addAction(finger.createPointerMove(Duration.ZERO, Origin.viewport(), pointA_X, pointA_Y))
				.addAction(finger.createPointerDown(MouseButton.LEFT.asArg()))
				.addAction(finger.createPointerUp(MouseButton.LEFT.asArg()));
		driver.perform(Arrays.asList(clickPosition));
	}

	public static void swipeUp(AndroidDriver driver) {
		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		Sequence swipe = new Sequence(finger, 1);
		int startX = driver.manage().window().getSize().width / 2;
		int startY = (int) (driver.manage().window().getSize().height * 0.8);
		int endY = (int) (driver.manage().window().getSize().height * 0.2);
		swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
		swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		swipe.addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), startX, endY));
		swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		driver.perform(Arrays.asList(swipe));
	}

	public static void scrollToTextUntilEnd(AndroidDriver driver, String visibleText) {
		while (true) {
			try {
				driver.findElement(By.xpath("//*[contains(@content-desc,'" + visibleText + "')]"));
				return; // Found the element
			} catch (NoSuchElementException e) {
				String before = driver.getPageSource();
				swipeUp(driver);
				String after = driver.getPageSource();
				if (before.equals(after)) {
					throw new NoSuchElementException("Scolled till end. " +visibleText+ " Text not found");
				}
			}
		}
	}
	
	public static WebDriver getDriver() {
		return driver;
	}
	
	public static boolean isTitleTextPresentCaseInsenstive(String value) {
		return getDriver().getTitle().toLowerCase().contains(value.toLowerCase());
	}
	
	public static boolean isPageSourceTextPresentCaseInsensitive(String value) {
		return getDriver().getPageSource().toLowerCase().contains(value.toLowerCase());
	}
	
	public static boolean waitUntilTextIsPresent(String validationText) {
		int searchFlag=0;
		int attemptCount = 1;
		int maxAttempts = 11;
		int sleepInterval = 1000;
			Reporter.log("Searching for := "+ validationText,true);	
		if (isTitleTextPresentCaseInsenstive(validationText)) {
			System.out.println("Page Title for " + validationText + " is true");
			Reporter.log("Page Title for " + validationText + " is true");
			searchFlag=1;
		} else {
				
			foundIt:
			while (attemptCount <= maxAttempts ) {
				if (isPageSourceTextPresentCaseInsensitive(validationText)) {
					Reporter.log("Page Source for " + validationText + " is true",true);
					searchFlag=1;
					break foundIt;
				} else {					
					try {
						Thread.sleep(sleepInterval);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				attemptCount++;
			}		
		}	
		if (searchFlag==0) {
			Reporter.log("Page Source for " + validationText + " is not found",true);
			Assert.assertTrue(false);
		}
		return (attemptCount <= maxAttempts) ? true : false;
	}

}
