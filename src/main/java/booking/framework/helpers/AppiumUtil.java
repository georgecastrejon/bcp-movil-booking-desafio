package booking.framework.helpers;

import booking.framework.capabilities.SamplePhysicalAndroid;
import booking.framework.capabilities.SampleSauceLabAndroid;
import booking.framework.enviroment.Enviroment;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aeonbits.owner.ConfigFactory;
import java.util.Objects;

public class AppiumUtil {
    static Enviroment env = ConfigFactory.create(Enviroment.class);
    private static final Logger logger = LogManager.getLogger(AppiumUtil.class);

    protected static AndroidDriver<MobileElement> driver;


    protected AppiumUtil() {
    }

    public static void initDevice() {
        if(env.executeSaucelabs()){


            driver = new AndroidDriver<MobileElement>(Objects.requireNonNull(SampleSauceLabAndroid.LocalUrl()), SampleSauceLabAndroid.desiredCapabilities_S9());
            logger.info("Se inicia las prueba en la nube");
            return;
        }
        driver = new AndroidDriver<MobileElement>(Objects.requireNonNull(SamplePhysicalAndroid.LocalUrl()), SamplePhysicalAndroid.desiredCapabilities_S23());
        logger.info("Se inician las pruebas en local");
    }
}
