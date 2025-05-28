package page.userPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;
import base.DriverManager;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class UserChooseDrPage extends BasePage{
	private By bookBtn =By.xpath("(//android.view.View[@content-desc=\"Book\"])[1]");
	
	public UserChooseDrPage(AndroidDriver driver) {
		super(driver);
	}
	
	public void selectDr() throws InterruptedException {
		click(bookBtn);
		Thread.sleep(1000);
	}

}
