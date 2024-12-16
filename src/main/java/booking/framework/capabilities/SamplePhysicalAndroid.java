package booking.framework.capabilities;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;

public class SamplePhysicalAndroid {
    static String url = "http://127.0.0.1:4723/wd/hub";

    public static final URL LocalUrl() {
        try {
            return new URL(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private SamplePhysicalAndroid() {
    }

    public static final DesiredCapabilities desiredCapabilities_S23Ultra() {
        File fichero = new File("src/main/resources/apk/booking-com-32-9.apk");
        String path = fichero.getAbsolutePath().replace("\\", "\\\\");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium:deviceName", "Galaxy S23 Ultra");
        capabilities.setCapability("appium:udid", System.getenv("UDIDS23Ultra"));
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appium:platformVersion", "14");
        capabilities.setCapability("appium:appPackage", "com.booking");
        capabilities.setCapability("appium:appActivity", "com.booking.startup.HomeActivity");
        capabilities.setCapability("appium:noReset", false);
        capabilities.setCapability("appium:fullReset", false);
        capabilities.setCapability("appium:app", path);
        capabilities.setCapability("appium:automationName", "UiAutomator2");
        capabilities.setCapability("appium:newCommandTimeout", 60);
        capabilities.setCapability("appium:autoGrantPermissions", true);
        return capabilities;
    }

    public static final DesiredCapabilities desiredCapabilities_S9plus() {
        File fichero = new File("src/main/resources/apk/booking-com-32-9.apk");
        String path = fichero.getAbsolutePath().replace("\\", "\\\\");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium:deviceName", "GalaxyS9+");
        capabilities.setCapability("appium:udid", System.getenv("UDIDS9Plus"));
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appium:platformVersion", "10");
        capabilities.setCapability("appium:appPackage", "com.booking");
        capabilities.setCapability("appium:appActivity", "com.booking.startup.HomeActivity");
        capabilities.setCapability("appium:noReset", false);
        capabilities.setCapability("appium:fullReset", false);
        capabilities.setCapability("appium:app", path);
        capabilities.setCapability("appium:automationName", "UiAutomator2");
        capabilities.setCapability("appium:newCommandTimeout", 60);
        capabilities.setCapability("appium:autoGrantPermissions", true);
        return capabilities;
    }

    public static final DesiredCapabilities desiredCapabilities_POCOX55G() {
        File fichero = new File("src/main/resources/apk/booking-com-32-9.apk");
        String path = fichero.getAbsolutePath().replace("\\", "\\\\");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium:deviceName", "POCO X5 5G");
        capabilities.setCapability("appium:udid", System.getenv("UDIDPOCOX55G"));
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appium:platformVersion", "14");
        capabilities.setCapability("appium:appPackage", "com.booking");
        capabilities.setCapability("appium:appActivity", "com.booking.startup.HomeActivity");
        capabilities.setCapability("appium:noReset", false);
        capabilities.setCapability("appium:fullReset", false);
        capabilities.setCapability("appium:app", path);
        capabilities.setCapability("appium:automationName", "UiAutomator2");
        capabilities.setCapability("appium:newCommandTimeout", 60);
        capabilities.setCapability("appium:autoGrantPermissions", true);
        return capabilities;
    }
}