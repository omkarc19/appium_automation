package base; 

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

	protected AppiumDriver driver; // This will hold the specific driver for this page object instance
	protected WebDriverWait wait;

	public BasePage(AppiumDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Default wait time
	}

	protected WebElement waitForVisibility(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	protected WebElement waitForClickability(By locator) {
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	protected void click(By locator) {
		waitForClickability(locator).click();
	}

	protected void sendKeys(By locator, String text) {
		waitForVisibility(locator).sendKeys(text);
	}

	protected String getText(By locator) {
		return waitForVisibility(locator).getText();
	}

	protected boolean isElementDisplayed(By locator) {
		try {
			return waitForVisibility(locator).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	protected void hideKeyBoard() {
		((AndroidDriver) driver).hideKeyboard();
	}

	/**
	 * Scrolls the screen until the specified text is visible. This method is
	 * primarily designed for Android using UiAutomator2's UiScrollable.
	 *
	 * @param text       The text string to scroll to.
	 * @param maxScrolls The maximum number of scroll attempts before giving up.
	 * @return true if the text is found and visible, false otherwise.
	 * @throws RuntimeException if the driver is not an AndroidDriver.
	 */
	public boolean scrollToText(String text, int maxScrolls) {
		if (!(driver instanceof AndroidDriver)) {
			throw new RuntimeException("scrollToText method is currently only supported for AndroidDriver.");
		}

		AndroidDriver androidDriver = (AndroidDriver) driver;
		String uiScrollable = "new UiScrollable(new UiSelector().scrollable(true).instance(0))";
		String uiSelector = ".scrollTextIntoView(new UiSelector().textContains(\"" + text + "\").instance(0))";
		String command = uiScrollable + uiSelector;

		for (int i = 0; i < maxScrolls; i++) {
			try {
				if (isElementDisplayed(By.xpath("//*[contains(@text, '" + text + "')]"))) {
					return true;
				}
				driver.findElement(AppiumBy.androidUIAutomator(command));
				Thread.sleep(500);
				if (isElementDisplayed(By.xpath("//*[contains(@text, '" + text + "')]"))) {
					System.out.println("Text '" + text + "' found after scrolling.");
					return true;
				}
			} catch (Exception e) {
				System.out.println("Scroll attempt " + (i + 1) + " failed or text not found yet: " + e.getMessage());
				}
		}
		System.out.println("Text '" + text + "' not found after " + maxScrolls + " attempts.");
		return false; 
	}
}