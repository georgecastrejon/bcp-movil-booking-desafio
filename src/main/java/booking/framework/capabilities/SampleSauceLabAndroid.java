package booking.framework.capabilities;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.HashMap;

public class SampleSauceLabAndroid {
    static String url = "https://"
            + System.getenv("SAUCE_USERNAME") + ":"
            + System.getenv("SAUCE_ACCESS_KEY")
            + "@ondemand.us-west-1.saucelabs.com:443/wd/hub";

    public static final URL LocalUrl() {
        try {
            return new URL(url);
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

    public static final DesiredCapabilities desiredCapabilities_S9() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium:deviceName", "Samsung Galaxy S9");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appium:platformVersion", "10");
        capabilities.setCapability("appium:noReset", false);
        capabilities.setCapability("appium:fullReset", false);
        capabilities.setCapability("appium:app", "storage:filename=booking-com-32-9.apk");
        capabilities.setCapability("appium:automationName", "UiAutomator2");
        HashMap<String, Object> sauceOptions = new HashMap<String, Object>();
        sauceOptions.put("appiumVersion", "latest");
        capabilities.setCapability("sauce:options", sauceOptions);
        capabilities.setCapability("appium:newCommandTimeout", 60);
        capabilities.setCapability("appium:autoGrantPermissions", true);
        return capabilities;
    }

    public static final DesiredCapabilities desiredCapabilities_A235G() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium:deviceName", "Samsung Galaxy A23 5G");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appium:platformVersion", "13");
        capabilities.setCapability("appium:noReset", false);
        capabilities.setCapability("appium:fullReset", false);
        capabilities.setCapability("appium:app", "storage:filename=booking-com-32-9.apk");
        capabilities.setCapability("appium:automationName", "UiAutomator2");
        HashMap<String, Object> sauceOptions = new HashMap<String, Object>();
        sauceOptions.put("appiumVersion", "latest");
        capabilities.setCapability("sauce:options", sauceOptions);
        capabilities.setCapability("appium:newCommandTimeout", 60);
        capabilities.setCapability("appium:autoGrantPermissions", true);
        return capabilities;
    }

    public static final DesiredCapabilities desiredCapabilities_PIXEL5() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium:deviceName", "Google Pixel 5");
        capabilities.setCapability("appium:platformName", "Android");
        capabilities.setCapability("appium:platformVersion", "14");
        capabilities.setCapability("appium:noReset", false);
        capabilities.setCapability("appium:fullReset", false);
        capabilities.setCapability("appium:app", "storage:filename=booking-com-32-9.apk");
        capabilities.setCapability("appium:automationName", "UiAutomator2");
        HashMap<String, Object> sauceOptions = new HashMap<String, Object>();
        sauceOptions.put("appiumVersion", "latest");
        capabilities.setCapability("sauce:options", sauceOptions);
        capabilities.setCapability("appium:newCommandTimeout", 60);
        capabilities.setCapability("appium:autoGrantPermissions", true);
        return capabilities;
    }
}
