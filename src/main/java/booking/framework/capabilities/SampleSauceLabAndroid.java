package booking.framework.capabilities;

import io.appium.java_client.remote.MobileCapabilityType;
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
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Samsung Galaxy S9");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
        capabilities.setCapability(MobileCapabilityType.FULL_RESET, false);
        capabilities.setCapability(MobileCapabilityType.APP, "storage:filename=booking-com-32-9.apk");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        HashMap<String, Object> sauceOptions = new HashMap<String, Object>();
        sauceOptions.put("appiumVersion", "latest");
        capabilities.setCapability("sauce:options", sauceOptions);
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,60);
        capabilities.setCapability("autoGrantPermissions",true);
        return capabilities;
    }

    public static final DesiredCapabilities desiredCapabilities_A235G() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Samsung Galaxy A23 5G");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
        capabilities.setCapability(MobileCapabilityType.FULL_RESET, false);
        capabilities.setCapability(MobileCapabilityType.APP, "storage:filename=booking-com-32-9.apk");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        HashMap<String, Object> sauceOptions = new HashMap<String, Object>();
        sauceOptions.put("appiumVersion", "latest");
        capabilities.setCapability("sauce:options", sauceOptions);
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,60);
        capabilities.setCapability("autoGrantPermissions",true);
        return capabilities;
    }

    public static final DesiredCapabilities desiredCapabilities_PIXEL5() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Google Pixel 5");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "14");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
        capabilities.setCapability(MobileCapabilityType.FULL_RESET, false);
        capabilities.setCapability(MobileCapabilityType.APP, "storage:filename=booking-com-32-9.apk");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        HashMap<String, Object> sauceOptions = new HashMap<String, Object>();
        sauceOptions.put("appiumVersion", "latest");
        capabilities.setCapability("sauce:options", sauceOptions);
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,60);
        capabilities.setCapability("autoGrantPermissions",true);
        return capabilities;
    }
}
