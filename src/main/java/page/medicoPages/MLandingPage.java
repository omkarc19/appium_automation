package page.medicoPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;
import base.DriverManager;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class MLandingPage extends BasePage {
	
	public MLandingPage(AndroidDriver driver) {
		super(driver);
	}

	private By nextBtn = By.xpath(".//*[@content-desc='Next']");
	private By getStartedBtn = AppiumBy.accessibilityId("Get Started");
	private By selectLanguageBtn = By.xpath("//android.view.View[@content-desc=\"English\n" + "A\"]");

	public void navigateLandingPage() throws InterruptedException {
		click(nextBtn);
		Thread.sleep(1000);
		click(nextBtn);
		click(getStartedBtn);
		click(selectLanguageBtn);
		click(nextBtn);
	}
}
