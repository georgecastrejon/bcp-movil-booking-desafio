package booking.framework.capabilities;


import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;

public class SamplePhysicalAndroid {

    static String url = "http://0.0.0.0:4723/wd/hub";

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
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Galaxy S23 Ultra");
        capabilities.setCapability(MobileCapabilityType.UDID, System.getenv("UDIDS23Ultra"));
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "14");
        capabilities.setCapability("appPackage", "com.booking");
        capabilities.setCapability("appActivity", "com.booking.startup.HomeActivity");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
        capabilities.setCapability(MobileCapabilityType.FULL_RESET, false);
        capabilities.setCapability(MobileCapabilityType.APP, path);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
        capabilities.setCapability("autoGrantPermissions", true);
        return capabilities;
    }
}
