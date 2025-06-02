package page.medicoPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;
import base.DriverManager;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class MAddCogniTestPage extends BasePage{
	private By aceIIICheckBox = AppiumBy.accessibilityId("ACE - III");
	private By cdrCheckBox = AppiumBy.accessibilityId("CDR");
	private By npiCheckBox = AppiumBy.accessibilityId("NPI");
	private By mmseCheckBox = AppiumBy.accessibilityId("MMSE");
	private By iadledrCheckBox = AppiumBy.accessibilityId("IADL - EDR");
	private By gdsCheckBox = AppiumBy.accessibilityId("GDS");
	private By modifiedBarthelADLIndexCheckBox = AppiumBy.accessibilityId("Modified Barthel ADL Index");
	private By functionalActivitiesAssessmentToolCheckBox = AppiumBy.accessibilityId("Functional Activities Assessment Tool");
	private By ad8DementiaScreeningCheckBox = AppiumBy.accessibilityId("AD8 Dementia Screening");
	private By nextBtn = AppiumBy.accessibilityId("Next");
	
	
	
	public MAddCogniTestPage(AndroidDriver driver) {
		super(driver);
	}
	
	public void selectTest() throws InterruptedException {
		click(aceIIICheckBox);
		click(cdrCheckBox);
		click(npiCheckBox);
		click(mmseCheckBox);
		click(iadledrCheckBox);
		click(gdsCheckBox);
		click(modifiedBarthelADLIndexCheckBox);
		click(functionalActivitiesAssessmentToolCheckBox);
		click(ad8DementiaScreeningCheckBox);
		click(nextBtn);
	}


}
