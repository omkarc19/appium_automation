package page.userPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;
import base.DriverManager;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import utils.TestUtils;

public class UChooseDrPage extends BasePage{
	private By bookBtn =By.xpath("(//android.view.View[@content-desc=\"Book\"])[1]");
	private By selectSlotText = AppiumBy.accessibilityId("Select Slots");
	
	public UChooseDrPage(AndroidDriver driver) {
		super(driver);
	}
	
	public void selectDr() throws InterruptedException {
		
		click(bookBtn);
		TestUtils.verifyText(driver, selectSlotText, "Select Slots", "Select Slots Text");
		Thread.sleep(1000);
	}

}
