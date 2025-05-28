package page.medicoPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;
import base.DriverManager;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class MedicoAppointmentReqPage extends BasePage {
	
	public MedicoAppointmentReqPage(AndroidDriver driver) {
		super(driver);
	}

	private By acceptBtn = AppiumBy.accessibilityId("Accept");
	
	public void acceptRequest() throws InterruptedException {
		click(acceptBtn);
		
	}
}
