package base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {

	public static AndroidDriver driver;
	public static AndroidDriver userDriver;
	public IOSDriver iosDriver;
	public static Actions action;
	public static Actions userAction;
	public AppiumDriverLocalService service;
	public AppiumDriverLocalService userService;
	public String platformName = System.getProperty("platformName", "Android"); // Default to Android
	int maxAttempt = 3;

	@BeforeSuite
	public void setup() throws MalformedURLException, InterruptedException {
		if (platformName.equalsIgnoreCase("Android")) {
			
			setupUserDriver();
			setupAndroidDriver();
		} else if (platformName.equalsIgnoreCase("iOS")) {
			setupIOSDriver();
		} else {
			throw new IllegalArgumentException("Invalid platform name provided: " + platformName);
		}
	}
	
	public void startAppiumServer() {
        service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\Shivam\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress("127.0.0.1").usingPort(4724).withArgument(GeneralServerFlag.LOG_LEVEL, "error").build();
        service.start();
        System.out.println("Appium server started successfully on - 127.0.0.1:4724");
//        .withLogFile(new File("NUL"))
    }
	
	public void startUserAppiumServer() {
		userService = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\Shivam\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress("127.0.0.1").usingPort(4725).withArgument(GeneralServerFlag.LOG_LEVEL, "error").build();
		userService.start();
		System.out.println("Appium server started successfully on - 127.0.0.1:4725");
    }
	
	public void setupAndroidDriver() throws MalformedURLException, InterruptedException {
		startAppiumServer();
		Thread.sleep(3000);
		UiAutomator2Options options = new UiAutomator2Options()
				.setUdid("emulator-5556")
				.setAppPackage(System.getProperty("appPackage", "com.manastik.dadt"))
				.setAppActivity(System.getProperty("appActivity", "com.manastik.dadt.MainActivity"))
				.setPlatformName("Android")
				.setAutoGrantPermissions(true)
				.setNoReset(false)
				.setSystemPort(8100);

		for (int attempt = 1; attempt <= 3; attempt++) {
			try {
				driver = new AndroidDriver(new URL("http://127.0.0.1:4724"), options);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				action = new Actions(driver);
				return; 
			} catch (SessionNotCreatedException e) {
				System.err.printf("Attempt %d failed: %s%n", attempt, e.getMessage());
				if (attempt == 3)
					throw e;
				try {Thread.sleep(3000);} catch (InterruptedException ignored) {
				}
			}
		}
	}

	public void setupUserDriver() throws MalformedURLException, InterruptedException {
		startUserAppiumServer();
		Thread.sleep(3000);
		UiAutomator2Options options1 = new UiAutomator2Options()
				.setUdid("emulator-5554")
				.setAppPackage(System.getProperty("appPackage", "com.manastik.dadt"))
				.setAppActivity(System.getProperty("appActivity", "com.manastik.dadt.MainActivity"))
				.setPlatformName("Android")
				.setAutoGrantPermissions(true)
				.setNoReset(false)
				.setSystemPort(8201);

		for (int attempt = 1; attempt <= 3; attempt++) {
			try {
				userDriver = new AndroidDriver(new URL("http://127.0.0.1:4725"), options1);
				userDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				userAction = new Actions(userDriver);
				return; 
			} catch (SessionNotCreatedException e) {
				System.err.printf("Attempt %d failed: %s%n", attempt, e.getMessage());
				if (attempt == 3)
					throw e;
				try {Thread.sleep(3000);} catch (InterruptedException ignored) {
				}
			}
		}

	}

	public void setupIOSDriver() throws MalformedURLException {
		XCUITestOptions options = new XCUITestOptions()
				.setUdid(System.getProperty("udid", "auto"))
				.setBundleId(System.getProperty("bundleId", "com.example.yourapp"))
				.setPlatformVersion(System.getProperty("platformVersion", "17.0")) 
				.setPlatformName("iOS")
				.setDeviceName(System.getProperty("deviceName", "iPhone 15"));
		iosDriver = new IOSDriver(new URL("http://127.0.0.1:4723"), options);
		iosDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

    @AfterSuite
    public void teardown() {
//        if (driver != null) {
//            driver.quit();
//        }
//        if (iosDriver != null) {
//            iosDriver.quit();
//        }
		try {
			if (service != null && service.isRunning())
				service.stop();
				userService.stop();
				System.out.println("Appium servers stopped successfully.");
		} catch (Exception e) {
			System.err.println("❌ Error while stopping Appium server: " + e.getMessage());
		}
    }

	public AndroidDriver getAndroidDriver() {
		return driver;
	}

	public IOSDriver getIosDriver() {
		return iosDriver;
	}
}