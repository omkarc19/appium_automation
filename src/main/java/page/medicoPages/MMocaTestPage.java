package page.medicoPages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;
import base.DriverManager;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import utils.TestUtils;

public class MMocaTestPage extends BasePage {
	
	//Common Locators
	private By startBtn = AppiumBy.accessibilityId("Start");
	private By scoreTxtBox = By.xpath("//android.view.View[@content-desc=\"1\"]/preceding-sibling::android.widget.EditText");
	private By nextArrowBtn = By.xpath("//android.view.View[@content-desc=\"1\"]/following-sibling::android.view.View");

	// Draw Clock test locators
	private By scoreTxtBox1 = By.xpath("//android.view.View[@content-desc=\"Contour\"]/following-sibling::android.widget.EditText");
	private By scoreTxtBox2 = By.xpath("//android.view.View[@content-desc=\"Numbers\"]/following-sibling::android.widget.EditText");
	private By scoreTxtBox3 = By.xpath("//android.view.View[@content-desc=\"Hands\"]/following-sibling::android.widget.EditText");
	private By nextArrowBtn2 = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.View\").instance(14)");


	// Attention test locators
	private By nextBtn = AppiumBy.accessibilityId("Next");
	private By nextArrowBtn3 = By.xpath("//android.view.View[@content-desc=\"Score\"]/following-sibling::*[last()]");

	//Language Test locators
	private By fieldTxtBox = By.xpath("//android.view.View[@content-desc=\"F\"]/following-sibling::android.widget.EditText");
	private By scoreTxtBox5 = By.xpath("//android.view.View[@content-desc=\"Score\"]/following-sibling::android.widget.EditText");
	
	//Abstraction test locators
	private By trainTxtBox = By.xpath("//android.view.View[@content-desc=\"train – bicycle\"]/preceding-sibling::android.widget.EditText");
	private By watchTxtBox = By.xpath("//android.view.View[@content-desc=\"train – bicycle\"]/following-sibling::android.widget.EditText");
	private By scoreTxtBox4 = By.xpath("//android.view.View[@content-desc=\"Score\"]/following-sibling::android.widget.EditText");
	private By nextArrowBtn4 = By.xpath("//android.view.View[@content-desc=\"2\"]/following-sibling::android.view.View");
	
	//Delayed Recall Test locators
	private By nextArrowBtn5 = By.xpath("//android.view.View[@content-desc=\"Red\"]/following-sibling::android.view.View");
	
	// Orientation Test Locators
	private By scoreTxtBox6 = By.xpath("//android.widget.EditText");
	private By nextArrowBtn6 = By.xpath("//android.view.View[@content-desc=\"What is the\"]/following-sibling::android.view.View[2]");
	
	
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

	public void namingTest() throws InterruptedException {
		System.out.println("In Naming Test");
		click(startBtn);
		provideScore();
		goNext();
		System.out.println("Completed Naming Test");
	}

	public void drawClockTest() throws InterruptedException {
		System.out.println("In Draw Clock Test");
		click(scoreTxtBox1);
		DriverManager.medicoAction.sendKeys("1").perform();
		hideKeyBoard();
		click(scoreTxtBox2);
		DriverManager.medicoAction.sendKeys("1").perform();
		hideKeyBoard();
		click(scoreTxtBox3);
		DriverManager.medicoAction.sendKeys("1").perform();
		hideKeyBoard();
		Thread.sleep(1000);
		click(nextArrowBtn2);
		System.out.println("Completed Draw Clock Test");
	}

	public void memoryTest() throws InterruptedException {
		System.out.println("In Memory Test");
		Thread.sleep(1000);
		TestUtils.action_clickOnPosition((AndroidDriver) driver, driver.manage().window().getSize().width / 2,
				(int) (driver.manage().window().getSize().height * 0.9));
		for (int i = 0; i < 10; i++) {
			driver.findElement(AppiumBy
					.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(" + i + ")"))
					.click();
			DriverManager.medicoAction.sendKeys("1").perform();
		}
		hideKeyBoard();
		click(nextArrowBtn2);
		System.out.println("Completed Memory Test");
	}

	public void attentionTest() throws InterruptedException {
		System.out.println("In Attention Test");
		click(startBtn);
		click(scoreTxtBox);
		DriverManager.medicoAction.sendKeys("1").perform();
		hideKeyBoard();
		click(nextArrowBtn);
		click(scoreTxtBox);
		DriverManager.medicoAction.sendKeys("1").perform();
		hideKeyBoard();
		click(nextBtn);
		click(scoreTxtBox);
		DriverManager.medicoAction.sendKeys("1").perform();
		hideKeyBoard();
		click(nextArrowBtn);

		for (int i = 0; i < 5; i++) {
			driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(" + i + ")")).click();
			DriverManager.medicoAction.sendKeys("3").perform();			
		}
		hideKeyBoard();
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(5)")).click();
		DriverManager.medicoAction.sendKeys("3").perform();	
		hideKeyBoard();
		click(nextArrowBtn3);
		System.out.println("Completed Attention Test");
	}

	public void languageTest() throws InterruptedException {
		System.out.println("In Language Test");
		Thread.sleep(1000);
		TestUtils.action_clickOnPosition((AndroidDriver) driver, driver.manage().window().getSize().width / 2,
				(int) (driver.manage().window().getSize().height * 0.9));
		provideScore();
		goNext();
		provideScore();
		goNext();
		click(fieldTxtBox);
		DriverManager.medicoAction.sendKeys("12").perform();
		click(scoreTxtBox5);
		DriverManager.medicoAction.sendKeys("1").perform();
		hideKeyBoard();
		goNext();		
		System.out.println("Completed Language Test");
	}
	
	public void abstractionTest() throws InterruptedException {
		System.out.println("In Abstraction Test");
		Thread.sleep(1000);
		TestUtils.action_clickOnPosition((AndroidDriver) driver, driver.manage().window().getSize().width / 2,
				(int) (driver.manage().window().getSize().height * 0.9));
		
		click(trainTxtBox);
		DriverManager.medicoAction.sendKeys("vehicle").perform();
		hideKeyBoard();
		click(watchTxtBox);
		DriverManager.medicoAction.sendKeys("stationary").perform();
		hideKeyBoard();
		Thread.sleep(1000);
		click(scoreTxtBox4);
		DriverManager.medicoAction.sendKeys("2").perform();
		hideKeyBoard();
		click(nextArrowBtn4);
		System.out.println("Completed Abstraction Test");
	}
	
	public void delayedRecallTest() throws InterruptedException {
		System.out.println("In Delayed Recall Test");
		Thread.sleep(1000);
		TestUtils.action_clickOnPosition((AndroidDriver) driver, driver.manage().window().getSize().width / 2,
				(int) (driver.manage().window().getSize().height * 0.9));

		List<WebElement> textboxes = driver.findElements(By.className("android.widget.EditText"));
		for (WebElement textBox : textboxes) {
			textBox.click();
			textBox.sendKeys("1");
		}
		hideKeyBoard();
		click(nextArrowBtn5);
		System.out.println("Completed Delayed Recall Test");
	}
	
	public void orientationTest() throws InterruptedException {
		System.out.println("In Orientation Test");
		Thread.sleep(1000);
		TestUtils.action_clickOnPosition((AndroidDriver) driver, driver.manage().window().getSize().width / 2,
				(int) (driver.manage().window().getSize().height * 0.9));

		click(scoreTxtBox6);
		sendKeys(scoreTxtBox6, "1");
		hideKeyBoard();
		click(nextArrowBtn6);
		
		click(scoreTxtBox6);
		sendKeys(scoreTxtBox6, "1");
		hideKeyBoard();
		click(nextArrowBtn6);
		
		click(scoreTxtBox6);
		sendKeys(scoreTxtBox6, "1");
		hideKeyBoard();
		click(nextArrowBtn6);
		
		click(scoreTxtBox6);
		sendKeys(scoreTxtBox6, "1");
		hideKeyBoard();
		click(nextArrowBtn6);
		
		click(scoreTxtBox6);
		sendKeys(scoreTxtBox6, "1");
		hideKeyBoard();
		click(nextArrowBtn6);
		
		click(scoreTxtBox6);
		sendKeys(scoreTxtBox6, "1");
		click(scoreTxtBox5);
		sendKeys(scoreTxtBox5, "6");
		hideKeyBoard();
		
		click(nextArrowBtn3);
		System.out.println("Completed Orientation Test");
	}
	
	
}
