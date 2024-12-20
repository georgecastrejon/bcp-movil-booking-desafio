package booking.framework.cucumber;

import booking.framework.helpers.AppiumUtil;
import booking.framework.helpers.ExceptionMessage;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.*;

public class Hook extends AppiumUtil {
    private static Scenario scenario;

    @Before
    public void before(Scenario injectedScenario) throws ExceptionMessage {
        try {
            initDevice();
            scenario = injectedScenario;
        } catch (Exception e) {
            throw new ExceptionMessage(e.getMessage());
        }
    }

    public static Scenario getScenario() {
        return scenario;
    }

    @After
    public static void after() throws ExceptionMessage {
        try {
            if (driver != null) {
                driver.quit();
            }
        } catch (Exception e) {
            throw new ExceptionMessage(e.getMessage());
        }
    }

    public static AndroidDriver getdriver() {
        return driver;
    }
}