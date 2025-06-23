package page.userPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;
import base.DriverManager;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import utils.EmulatorConfigReader;
import utils.LoginDetailsReader;
import utils.TestUtils;

public class ULoginPage extends BasePage{
	private By userOption = AppiumBy.accessibilityId("User");
	private By envDropDown = AppiumBy.accessibilityId("TEST");
	private By prodEnvoption = AppiumBy.accessibilityId("PROD");
	private By emailIdTxtBox = By.xpath("//android.widget.EditText[@hint='Email\nEmail Id']");
	private By passwordFieldTxtBox = By.xpath("//android.widget.EditText[@hint='Password\nPassword']");
	private By signInBtn = AppiumBy.accessibilityId("Sign In");
	private By welcomeText = AppiumBy.accessibilityId("Welcome Back");
	private By homePageText = AppiumBy.accessibilityId("Features");

	public ULoginPage(AndroidDriver driver) {
		super(driver);
	}
	
	public void login() throws InterruptedException {
		TestUtils.verifyText(driver, welcomeText, "Welcome Back", "Welcome Back Text");
//		click(userOption);
//		click(envDropDown);
//		click(prodEnvoption);
		click(emailIdTxtBox);
		sendKeys(emailIdTxtBox, LoginDetailsReader.getProperty("user.email.id"));
		hideKeyBoard();
		click(passwordFieldTxtBox);
		sendKeys(passwordFieldTxtBox, LoginDetailsReader.getProperty("user.password"));
		hideKeyBoard();
		click(signInBtn);
		TestUtils.verifyText(driver, homePageText, "Features", "Home Page Text");
//		TestUtils.assertAll();
	}

}
