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

public class MMocaTestPage extends BasePage{
	private By startBtn = AppiumBy.accessibilityId("Start");
	private By scoreTxtBox = By.xpath("//android.view.View[@content-desc=\"1\"]/preceding-sibling::android.widget.EditText");
	private By nextArrowBtn = By.xpath("//android.view.View[@content-desc=\"1\"]/following-sibling::android.view.View");
	
//	public By nextArrowBtn1 = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.View\").instance(10)");
	
	//Draw Clock test
	private By scoreTxtBox1 = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(0)");
	private By scoreTxtBox2 = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(1)");
	private By nextArrowBtn2 = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.View\").instance(14)");
	
	// Attention Test
	private By nextBtn = AppiumBy.accessibilityId("Next");
	
	
	
	public MMocaTestPage(AndroidDriver driver) {
		super(driver);
	}
	
	public void startTest() throws InterruptedException {
		click(startBtn);
	}

	public void startAssesment() throws InterruptedException {
		click(startBtn);
		Thread.sleep(1000);
		click(startBtn);
	}
	
	
	public void provideScore() throws InterruptedException {
		Thread.sleep(1000);
		click(scoreTxtBox);
		sendKeys(scoreTxtBox, "1");
	}

	public void goNext() {
		click(nextArrowBtn);
	}
	
	public void drawClockTest() throws InterruptedException {
		sendKeys(scoreTxtBox, "1");
		sendKeys(scoreTxtBox1, "1");
		sendKeys(scoreTxtBox2, "1");
		Thread.sleep(1000);
		click(nextArrowBtn2);
	}
	
	public void memoryTest() {
		TestUtils.action_clickOnPosition((AndroidDriver) driver, driver.manage().window().getSize().width / 2, (int) (driver.manage().window().getSize().height * 0.95));
		for (int i = 0; i < 10; i++) {
			driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(" + i + ")")).click();
			DriverManager.medicoAction.sendKeys("1").perform();
		}
		click(nextArrowBtn2);
	}
	
	public void attentionTest() throws InterruptedException {
		click(startBtn);
		click(scoreTxtBox);
		DriverManager.medicoAction.sendKeys("1").perform();
		click(nextArrowBtn);
		click(scoreTxtBox);
		DriverManager.medicoAction.sendKeys("1").perform();
		click(nextBtn);
		click(scoreTxtBox);
		DriverManager.medicoAction.sendKeys("1").perform();
		click(nextArrowBtn);
		
		for (int i = 0; i < 6; i++) {
			driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(" + i + ")")).click();
			DriverManager.medicoAction.sendKeys("3").perform();
		}
		
//		
//		click(scoreTxtBox);
//		DriverManager.medicoAction.sendKeys("3").perform();
		click(nextArrowBtn);
		
		
	}
}
