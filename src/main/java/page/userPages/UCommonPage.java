package page.userPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;
import base.DriverManager;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import utils.TestUtils;

public class UCommonPage extends BasePage{
	private By acceptBtn = By.id("com.manastik.dadt:id/llAccept");
	private By toggleBtn = AppiumBy.accessibilityId("Toggle Picture-in-Picture mode");
	
	public UCommonPage(AndroidDriver driver) {
		super(driver);
	}
	
	public void acceptMeeting() throws InterruptedException {
		click(acceptBtn);
	}

	public void minimizeMeeting() throws InterruptedException {
		Thread.sleep(1500);
		click(toggleBtn);
		Thread.sleep(1500);
		TestUtils.dragAndDrop(driver, 800, 1900, 1076, 600);
	}
}
