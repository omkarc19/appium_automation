package page.medicoPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;
import base.DriverManager;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class MAppointmentDetailsPage extends BasePage{
	private By addSymptomsDropDown = By.xpath("//android.view.View[@content-desc=\"Add Symptoms\"]/following-sibling::android.widget.EditText");
	private By memoryLossOption = AppiumBy.accessibilityId("Memory loss");
	private By historyTxtBox = By.xpath("//android.view.View[@content-desc=\"History\"]/following-sibling::android.widget.EditText");
	private By medicalHistoryTxtBox = By.xpath("//android.view.View[@content-desc=\"Medical History\"]/following-sibling::android.widget.EditText");

	private By testReportBtn = AppiumBy.accessibilityId("Upload Tests or Reports");
	private By cameraBtn = AppiumBy.accessibilityId("Camera");
	private By shutterBtn = AppiumBy.accessibilityId("Shutter");
	private By doneBtn = AppiumBy.accessibilityId("Done");
	private By uploadBtn = AppiumBy.accessibilityId("Upload");
	private By nextBtn = AppiumBy.accessibilityId("Next");
	
	
	
	public MAppointmentDetailsPage(AndroidDriver driver) {
		super(driver);
	}
	
	public void addAppointmentDetails() throws InterruptedException {
		
		click(addSymptomsDropDown);
		click(memoryLossOption);
		click(historyTxtBox);
		clear(historyTxtBox);
		sendKeys(historyTxtBox, "Text by automation script");
		click(medicalHistoryTxtBox);
		clear(medicalHistoryTxtBox);
		click(medicalHistoryTxtBox);
		sendKeys(medicalHistoryTxtBox, "Text by automation script");

		
//		click(testReportBtn);
//		click(cameraBtn);
//		click(shutterBtn);
//		click(doneBtn);
//		click(uploadBtn);
		
		click(nextBtn);
		
		
	}

}
