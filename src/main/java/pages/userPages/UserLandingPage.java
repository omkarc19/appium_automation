package pages.userPages;

import org.openqa.selenium.By;
import base.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class UserLandingPage extends BasePage {
	private By nextBtn = By.xpath(".//*[@content-desc='Next']");
	private By getStartedBtn = AppiumBy.accessibilityId("Get Started");
	private By selectLanguageBtn = By.xpath("//android.view.View[@content-desc=\"English\n" + "A\"]");

	public UserLandingPage(AndroidDriver driver) {
		super(driver);
	}
	
	public void navigateLandingPage() throws InterruptedException {
		click(nextBtn);
		Thread.sleep(1000);
		click(nextBtn);
		click(getStartedBtn);
		click(selectLanguageBtn);
		click(nextBtn);
	}
}
