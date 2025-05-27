package base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import utils.ConfigReader;

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

	@BeforeSuite
	public void setup() throws MalformedURLException, InterruptedException {
		if (platformName.equalsIgnoreCase("Android")) {
			setupUserDriver();
//			setupAndroidDriver();
		} else if (platformName.equalsIgnoreCase("iOS")) {
			setupIOSDriver();
		} else {
			throw new IllegalArgumentException("Invalid platform name provided: " + platformName);
		}
	}

	public void startAppiumServer() {
		String appiumServerIp = ConfigReader.getProperty("appium.server.ip");
		int appiumServerPort1 = Integer.parseInt(ConfigReader.getProperty("appium.server1.port"));

		service = new AppiumServiceBuilder()
				.withAppiumJS(new File(getAppiumMainJsPath()))
				.withIPAddress(appiumServerIp)
				.usingPort(appiumServerPort1)
				.withArgument(GeneralServerFlag.LOG_LEVEL, "error")
				.build();
		service.start();
		System.out.println("Appium server started successfully on - " + appiumServerIp + ":" + appiumServerPort1);
	}

	public void startUserAppiumServer() {
		
		String appiumServerIp = ConfigReader.getProperty("appium.server.ip");
		int appiumServerPort2 = Integer.parseInt(ConfigReader.getProperty("appium.server2.port"));

		userService = new AppiumServiceBuilder()
				.withAppiumJS(new File(getAppiumMainJsPath()))
				.withIPAddress(appiumServerIp)
				.usingPort(appiumServerPort2)
				.withArgument(GeneralServerFlag.LOG_LEVEL, "error")
				.build();
		userService.start();
		System.out.println("Appium server started successfully on - " + appiumServerIp + ":" + appiumServerPort2);
	}

	public void setupAndroidDriver() throws MalformedURLException, InterruptedException {
		startAppiumServer();
		Thread.sleep(3000);

		String driver1Udid = ConfigReader.getProperty("android.driver1.udid");
		int driver1SystemPort = Integer.parseInt(ConfigReader.getProperty("android.driver1.systemPort"));
		String appPackage = ConfigReader.getProperty("app.package");
		String appActivity = ConfigReader.getProperty("app.activity");
		String appiumServerIp = ConfigReader.getProperty("appium.server.ip");
		int appiumServerPort1 = Integer.parseInt(ConfigReader.getProperty("appium.server1.port"));

		UiAutomator2Options options = new UiAutomator2Options()
				.setUdid(driver1Udid)
				.setAppPackage(appPackage)
				.setAppActivity(appActivity)
				.setPlatformName("Android")
				.setAutoGrantPermissions(true)
				.setNoReset(false)
				.setSystemPort(driver1SystemPort);

		for (int attempt = 1; attempt <= 3; attempt++) {
			try {
				driver = new AndroidDriver(new URL("http://" + appiumServerIp + ":" + appiumServerPort1), options);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				action = new Actions(driver);
				return;
			} catch (SessionNotCreatedException e) {
				System.err.printf("Attempt %d failed: %s%n", attempt, e.getMessage());
				if (attempt == 3)
					throw e;
				try {
					Thread.sleep(3000);
				} catch (InterruptedException ignored) {
				}
			}
		}
	}

	public void setupUserDriver() throws MalformedURLException, InterruptedException {
		startUserAppiumServer();
		Thread.sleep(3000);

		// Get properties for user driver 2
		String driver2Udid = ConfigReader.getProperty("android.driver2.udid");
		int driver2SystemPort = Integer.parseInt(ConfigReader.getProperty("android.driver2.systemPort"));
		String appPackage = ConfigReader.getProperty("app.package");
		String appActivity = ConfigReader.getProperty("app.activity");
		String appiumServerIp = ConfigReader.getProperty("appium.server.ip");
		int appiumServerPort2 = Integer.parseInt(ConfigReader.getProperty("appium.server2.port"));

		UiAutomator2Options options1 = new UiAutomator2Options()
				.setUdid(driver2Udid)
				.setAppPackage(appPackage)
				.setAppActivity(appActivity)
				.setPlatformName("Android")
				.setAutoGrantPermissions(true)
				.setNoReset(false)
				.setSystemPort(driver2SystemPort);

		for (int attempt = 1; attempt <= 3; attempt++) {
			try {
				userDriver = new AndroidDriver(new URL("http://" + appiumServerIp + ":" + appiumServerPort2), options1);
				userDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				userAction = new Actions(userDriver);
				return;
			} catch (SessionNotCreatedException e) {
				System.err.printf("Attempt %d failed: %s%n", attempt, e.getMessage());
				if (attempt == 3)
					throw e;
				try {
					Thread.sleep(3000);
				} catch (InterruptedException ignored) {
				}
			}
		}

	}

	public void setupIOSDriver() throws MalformedURLException {
		XCUITestOptions options = new XCUITestOptions().setUdid(System.getProperty("udid", "auto"))
				.setBundleId(System.getProperty("bundleId", "com.example.yourapp"))
				.setPlatformVersion(System.getProperty("platformVersion", "17.0")).setPlatformName("iOS")
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

	public static String getAppiumMainJsPath() {
        String userHome = System.getProperty("user.home");
        String os = System.getProperty("os.name").toLowerCase();
        String appiumPath;
        if (os.contains("win")) {
        	appiumPath = userHome + ConfigReader.getProperty("appium.js.path");
        } else {
        	appiumPath = "\\usr\\local\\lib\\node_modules\\appium\\build\\lib\\main.js";
        }
        File file = new File(appiumPath);
        if (file.exists()) {
            return file.getAbsolutePath();
        } else {
            throw new RuntimeException("Appium main.js not found at: " + appiumPath);
        }
    }
}