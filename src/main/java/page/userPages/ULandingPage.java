package page.userPages;

import org.openqa.selenium.By;

import base.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import utils.TestUtils;

public class ULandingPage extends BasePage {
	private By nextBtn = By.xpath(".//*[@content-desc='Next']");
	private By getStartedBtn = AppiumBy.accessibilityId("Get Started");
	private By selectLanguageBtn = By.xpath("//android.view.View[@content-desc=\"English\n" + "A\"]");
	private By landingPageText = AppiumBy.accessibilityId("Your partner in prime-time remembering");
	private By selectLanguageText = AppiumBy.accessibilityId("Select Language");

	public ULandingPage(AndroidDriver driver) {
		super(driver);
	}
	
	public void navigateLandingPage() throws InterruptedException {
		TestUtils.verifyText(driver, landingPageText, "Your partner in prime-time remembering", "Landing Page Welcome Text");
		click(nextBtn);
		Thread.sleep(1000);
		click(nextBtn);
		click(getStartedBtn);
		TestUtils.verifyText(driver, selectLanguageText, "Select Language", "Landing Page Select Language Test");
		click(selectLanguageBtn);
		click(nextBtn);
	}
}
