package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import utils.EmulatorConfigReader;

import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverManager {

	public static AndroidDriver medicoDriver;
	public static Actions medicoAction;
	public AppiumDriverLocalService medicoService;

	public static AndroidDriver userDriver;
	public static Actions userAction;
	public AppiumDriverLocalService userService;

	public IOSDriver iosDriver;

	@BeforeSuite
	public void setup() throws MalformedURLException, InterruptedException {
		String platformName = EmulatorConfigReader.getProperty("platformName");
		if (platformName.equalsIgnoreCase("Android")) {
			setupUserDriver();
			setupMedicoDriver();
		} else if (platformName.equalsIgnoreCase("iOS")) {
			setupIOSDriver();
		} else {
			throw new IllegalArgumentException("Invalid platform name provided: " + platformName);
		}
	}

	public static String getAppiumMainJsPath() {
		String userHome = System.getProperty("user.home");
		String os = System.getProperty("os.name").toLowerCase();
		String appiumPath;
		if (os.contains("win")) {
			appiumPath = userHome + EmulatorConfigReader.getProperty("appium.js.path");
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
	
	public void startMedicoAppiumServer() {
		String appiumServerIp = EmulatorConfigReader.getProperty("appium.server.ip");
		int appiumServerPort1 = Integer.parseInt(EmulatorConfigReader.getProperty("appium.server1.port"));

		medicoService = new AppiumServiceBuilder().withAppiumJS(new File(getAppiumMainJsPath()))
				.withIPAddress(appiumServerIp).usingPort(appiumServerPort1)
				.withArgument(GeneralServerFlag.LOG_LEVEL, "error").build();
		medicoService.start();
		System.out.println("Appium server started successfully on - " + appiumServerIp + ":" + appiumServerPort1);
	}

	public void startUserAppiumServer() {

		String appiumServerIp = EmulatorConfigReader.getProperty("appium.server.ip");
		int appiumServerPort2 = Integer.parseInt(EmulatorConfigReader.getProperty("appium.server2.port"));

		userService = new AppiumServiceBuilder().withAppiumJS(new File(getAppiumMainJsPath()))
				.withIPAddress(appiumServerIp).usingPort(appiumServerPort2)
				.withArgument(GeneralServerFlag.LOG_LEVEL, "error").build();
		userService.start();
		System.out.println("Appium server started successfully on - " + appiumServerIp + ":" + appiumServerPort2);
	}

	public void setupMedicoDriver() throws MalformedURLException, InterruptedException {
		startMedicoAppiumServer();
		Thread.sleep(3000);

		String driver1Udid = EmulatorConfigReader.getProperty("android.driver1.udid");
		int driver1SystemPort = Integer.parseInt(EmulatorConfigReader.getProperty("android.driver1.systemPort"));
		String appPackage = EmulatorConfigReader.getProperty("app.package");
		String appActivity = EmulatorConfigReader.getProperty("app.activity");
		String appiumServerIp = EmulatorConfigReader.getProperty("appium.server.ip");
		int appiumServerPort1 = Integer.parseInt(EmulatorConfigReader.getProperty("appium.server1.port"));
		boolean setNoReset1 = Boolean.parseBoolean(EmulatorConfigReader.getProperty("setNoReset1"));
		
		UiAutomator2Options options = 
				new UiAutomator2Options()
				.setUdid(driver1Udid)
				.setAppPackage(appPackage)
				.setAppActivity(appActivity)
				.setPlatformName("Android")
				.setAutoGrantPermissions(true)
				.setNoReset(setNoReset1)
				.setSystemPort(driver1SystemPort);

		for (int attempt = 1; attempt <= 3; attempt++) {
			try {
				medicoDriver = new AndroidDriver(new URL("http://" + appiumServerIp + ":" + appiumServerPort1),
						options);
				medicoDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				medicoAction = new Actions(medicoDriver);
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

		String driver2Udid = EmulatorConfigReader.getProperty("android.driver2.udid");
		int driver2SystemPort = Integer.parseInt(EmulatorConfigReader.getProperty("android.driver2.systemPort"));
		String appPackage = EmulatorConfigReader.getProperty("app.package");
		String appActivity = EmulatorConfigReader.getProperty("app.activity");
		String appiumServerIp = EmulatorConfigReader.getProperty("appium.server.ip");
		int appiumServerPort2 = Integer.parseInt(EmulatorConfigReader.getProperty("appium.server2.port"));
		boolean setNoReset2 = Boolean.parseBoolean(EmulatorConfigReader.getProperty("setNoReset2"));
		
		UiAutomator2Options options1 = 
				new UiAutomator2Options()
				.setUdid(driver2Udid)
				.setAppPackage(appPackage)
				.setAppActivity(appActivity)
				.setPlatformName("Android")
				.setAutoGrantPermissions(true)
				.setNoReset(setNoReset2)
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
			if (medicoService != null && medicoService.isRunning()) {
				medicoService.stop();
				System.out.println("Medico Appium servers stopped successfully.");
			}

			if ((userService != null && userService.isRunning())) {
				userService.stop();
				System.out.println("User Appium servers stopped successfully.");
			}
		} catch (Exception e) {
			System.err.println("❌ Error while stopping Appium servers: " + e.getMessage());
		}
	}

	public AndroidDriver getMedicoDriver() {
		return medicoDriver;
	}

	public AndroidDriver getUserDriver() {
		return userDriver;
	}
	
	public IOSDriver getIosDriver() {
		return iosDriver;
	}

	
}