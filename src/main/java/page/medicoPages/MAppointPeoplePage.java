package page.medicoPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;
import base.DriverManager;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class MAppointPeoplePage extends BasePage{
	private By mocaDropDown =By.xpath("//android.view.View[@content-desc=\"1. MoCA\"]/following-sibling::android.widget.Button");
	private By selfOption = AppiumBy.accessibilityId("Self");
	private By nextBtn = AppiumBy.accessibilityId("Next");
	
	public MAppointPeoplePage(AndroidDriver driver) {
		super(driver);
	}
	
	public void startTest() throws InterruptedException {
	
		click(mocaDropDown);
		click(selfOption);
		click(nextBtn);
	}

}
