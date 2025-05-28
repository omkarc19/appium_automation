package page.medicoPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;
import base.DriverManager;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class MedicoHomePage extends BasePage {
	
	public MedicoHomePage(AndroidDriver driver) {
		super(driver);
	}

	private By pendingRequestBtn = AppiumBy.accessibilityId("Pending appointment requests");
	private By viewAllBtn = By.xpath("//android.view.View[@content-desc=\"View All\"]");
	
	public void viewPendingRequest() throws InterruptedException {
		click(pendingRequestBtn);
	}
	
	public void viewAllRequestBtn() throws InterruptedException {
		click(viewAllBtn);
	}
	
}
