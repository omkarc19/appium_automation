package page.medicoPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;
import base.DriverManager;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class MTestPage extends BasePage{
	private By startBtn = AppiumBy.accessibilityId("Start");
	private By scoreTxtBox = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\")");
	private By nextArrowBtn = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.View\").instance(9)");
	
	public MTestPage(AndroidDriver driver) {
		super(driver);
	}
	
	public void startTest() throws InterruptedException {
		click(startBtn);
	}

	public void startAssesment() throws InterruptedException {
		click(startBtn);
		Thread.sleep(1000);
		click(startBtn);
	}
	
	public void provideScore() {
		click(scoreTxtBox);
		sendKeys(scoreTxtBox, "1");
		click(nextArrowBtn);
	}

}
