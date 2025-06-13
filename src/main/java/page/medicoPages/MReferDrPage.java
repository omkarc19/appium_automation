package page.medicoPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.BasePage;
import base.DriverManager;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import utils.TestUtils;

public class MReferDrPage extends BasePage{
	private By skipBtn = AppiumBy.accessibilityId("Skip");


	public MReferDrPage(AndroidDriver driver) {
		super(driver);
	}
	
	public void clickSkipBtn() throws InterruptedException {
		click(skipBtn);
	}

}
