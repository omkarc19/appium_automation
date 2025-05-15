package base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {

    public static AndroidDriver driver;
    public IOSDriver iosDriver;
    public static Actions action;
    public String platformName = System.getProperty("platformName", "Android"); // Default to Android

    @BeforeSuite
    public void setup() throws MalformedURLException {
        if (platformName.equalsIgnoreCase("Android")) {
            setupAndroidDriver();
        } else if (platformName.equalsIgnoreCase("iOS")) {
            setupIOSDriver();
        } else {
            throw new IllegalArgumentException("Invalid platform name provided: " + platformName);
        }
        // Add any other global setup steps here (e.g., setting implicit waits)
    }

    public void setupAndroidDriver() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options()
                .setDeviceName("omkar-intel") 
                .setAppPackage(System.getProperty("appPackage", "com.manastik.dadt")) 
                .setAppActivity(System.getProperty("appActivity", "com.manastik.dadt.MainActivity")) 
                .setPlatformName("Android")
                .setAutoGrantPermissions(true)
                .setNoReset(false);

        // You can add more desired capabilities here

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
        action = new Actions(driver);
    }

    public void setupIOSDriver() throws MalformedURLException {
        XCUITestOptions options = new XCUITestOptions()
                .setUdid(System.getProperty("udid", "auto")) // Replace with your device UDID or 'auto' for simulator
                .setBundleId(System.getProperty("bundleId", "com.example.yourapp")) // Replace with your app's bundle ID
                .setPlatformVersion(System.getProperty("platformVersion", "17.0")) // Replace with your iOS version
                .setPlatformName("iOS")
                .setDeviceName(System.getProperty("deviceName", "iPhone 15")); // Replace with your device/simulator name

        // You can add more desired capabilities here
        // options.setWdaLocalPort(8100); // For multiple iOS devices

        iosDriver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);
        iosDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Example implicit wait
    }

//    @AfterSuite
//    public void teardown() {
//        if (driver != null) {
//            driver.quit();
//        }
//        if (iosDriver != null) {
//            iosDriver.quit();
//        }
//    }
    
 // Add these getter methods to expose the driver
    public AndroidDriver getAndroidDriver() {
        return driver;
    }

    public IOSDriver getIosDriver() {
        return iosDriver;
    }
}