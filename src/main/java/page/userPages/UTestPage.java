package page.userPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;
import base.DriverManager;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class UTestPage extends BasePage{
	private By submitBtn = AppiumBy.accessibilityId("Submit");
	
	public UTestPage(AndroidDriver driver) {
		super(driver);
	}
	
	public void submitTest() throws InterruptedException {
		click(submitBtn);
	}


}
