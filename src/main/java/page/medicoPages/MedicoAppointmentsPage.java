package page.medicoPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;
import base.DriverManager;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class MedicoAppointmentsPage extends BasePage {
	
	public MedicoAppointmentsPage(AndroidDriver driver) {
		super(driver);
	}

	private By confirmedUserBtn = By.xpath("//*[contains(@content-desc, 'Vishnu Kumar')]");
	private By startAppointmentBtn = AppiumBy.accessibilityId("Start Appointment");
	
	public void acceptRequest() throws InterruptedException {
		click(confirmedUserBtn);
		click(startAppointmentBtn);
		Thread.sleep(3000);
		
	}
}
