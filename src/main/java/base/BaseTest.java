package base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {

    public static AndroidDriver driver;
    public static AndroidDriver userDriver;
    public IOSDriver iosDriver;
    public static Actions action;
    public static Actions userAction;
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
    }

    public void setupAndroidDriver() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options()
                .setUdid("emulator-5554") 
                .setAppPackage(System.getProperty("appPackage", "com.manastik.dadt")) 
                .setAppActivity(System.getProperty("appActivity", "com.manastik.dadt.MainActivity")) 
                .setPlatformName("Android")
                .setAutoGrantPermissions(true)
                .setNoReset(false)
                .setSystemPort(8100);
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
        action = new Actions(driver);
    }

    public void setupUserDriver() throws MalformedURLException {
        UiAutomator2Options options1 = new UiAutomator2Options()
                .setUdid("emulator-5556") 
                .setAppPackage(System.getProperty("appPackage", "com.manastik.dadt")) 
                .setAppActivity(System.getProperty("appActivity", "com.manastik.dadt.MainActivity")) 
                .setPlatformName("Android")
                .setAutoGrantPermissions(true)
                .setNoReset(false)
                .setSystemPort(8201);
        userDriver = new AndroidDriver(new URL("http://127.0.0.1:4725"), options1);
        userDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
        userAction = new Actions(userDriver);
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

        iosDriver = new IOSDriver(new URL("http://127.0.0.1:4723"), options);
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
    
    public AndroidDriver getAndroidDriver() {
        return driver;
    }

    public IOSDriver getIosDriver() {
        return iosDriver;
    }
}