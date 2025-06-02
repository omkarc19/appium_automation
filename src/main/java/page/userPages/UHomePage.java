package page.userPages;

import org.openqa.selenium.By;

import base.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class UHomePage extends BasePage {
	private By viewAllBtn = AppiumBy.xpath("//android.view.View[@content-desc=\"View All\"]");

	public UHomePage(AndroidDriver driver) {
		super(driver);
	}

	public void navigateToDrPage() throws InterruptedException {
		
		click(viewAllBtn);
	}
}
