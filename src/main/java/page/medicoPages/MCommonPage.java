package page.medicoPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;
import base.DriverManager;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class MCommonPage extends BasePage{
	private By toggleBtn = AppiumBy.accessibilityId("Toggle Picture-in-Picture mode");

	public MCommonPage(AndroidDriver driver) {
		super(driver);
	}
	
	public void minimizeMeeting() throws InterruptedException {
		Thread.sleep(1500);
		click(toggleBtn);
	}

	
}
