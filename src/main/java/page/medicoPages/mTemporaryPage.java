package page.medicoPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;
import base.DriverManager;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import utils.TestUtils;

public class mTemporaryPage extends BasePage{
	private By thirdBtn = By.xpath("//android.widget.ImageView[@content-desc=\"Appointments\r\n"
			+ "Tab 3 of 4\"]");
	private By continueBtn = AppiumBy.accessibilityId("Continue");
	
	public mTemporaryPage(AndroidDriver driver) {
		super(driver);
	}
	
	public void startAppointment() throws InterruptedException {
		click(thirdBtn);
		TestUtils.scrollToTextUntilEnd((AndroidDriver) driver, "Vishnu Kumar");
		click(continueBtn);
		
	}

	
}
