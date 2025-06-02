package page.medicoPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;
import base.DriverManager;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class MLoginPage extends BasePage{
	private By medicoOption = AppiumBy.accessibilityId("Medico");
	private By envDropDown = AppiumBy.accessibilityId("TEST");
	private By prodEnvoption = AppiumBy.accessibilityId("PROD");
	private By emailIdTxtBox = By.xpath("//android.widget.EditText[@hint='Email\nEmail Id']");
	private By passwordFieldTxtBox = By.xpath("//android.widget.EditText[@hint='Password\nPassword']");
	private By signInBtn = AppiumBy.accessibilityId("Sign In");

	public MLoginPage(AndroidDriver driver) {
		super(driver);
	}
	
	public void login() throws InterruptedException {
		click(medicoOption);
		click(envDropDown);
		click(prodEnvoption);
		click(emailIdTxtBox);
		sendKeys(emailIdTxtBox, "soubhik111das@gmail.com");
		hideKeyBoard();
		click(passwordFieldTxtBox);
		sendKeys(passwordFieldTxtBox, "Test@456");
		hideKeyBoard();
		click(signInBtn);
	}

}
