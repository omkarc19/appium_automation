package page.userPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;
import base.DriverManager;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class UBookAppointmentPage extends BasePage{
	private By calendarOption =AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.Button\").instance(1)");
	private By dateOption =  AppiumBy.accessibilityId("13, Friday, June 13, 2025");
	private By okBtn =  AppiumBy.accessibilityId("OK");
	private By timeSlot = By.xpath("//android.view.View[@content-desc=\"Select the time slot\"]/following-sibling::android.view.View");
	private By bookBtn = AppiumBy.accessibilityId("Book");
	private By closeBtn = By.xpath("//android.widget.Button");
			
	public UBookAppointmentPage(AndroidDriver driver) {
		super(driver);
	}
	
	public void bookAppointment() throws InterruptedException {
		click(calendarOption);
		click(dateOption);
		click(okBtn);
		click(timeSlot);
		click(bookBtn);
		Thread.sleep(1000);
		click(bookBtn);
		click(closeBtn);
	}

}
