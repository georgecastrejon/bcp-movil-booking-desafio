package booking.framework.helpers;

import booking.framework.capabilities.SamplePhysicalAndroid;
import booking.framework.capabilities.SampleSauceLabAndroid;
import booking.framework.enviroment.Enviroment;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aeonbits.owner.ConfigFactory;

import java.net.URL;
import java.util.Objects;

public class AppiumUtil {
    static Enviroment env = ConfigFactory.create(Enviroment.class);
    private static final Logger logger = LogManager.getLogger(AppiumUtil.class);

    protected static AndroidDriver driver;

    protected AppiumUtil() {
    }

    public static void initDevice() {
        String device;
        if (env.executeSaucelabs()) {

            URL url = SampleSauceLabAndroid.LocalUrl();
            device = System.getProperty("device");

            if (device == null || device.isEmpty()) {
                device = env.cloudDeviceDefaul();
            }

            switch (device) {
                case "Samsung Galaxy S9":
                    driver = new AndroidDriver(Objects.requireNonNull(url), SampleSauceLabAndroid.desiredCapabilities_S9());
                    logger.info("Se inicia la prueba en la nube con Samsung Galaxy S9");
                    break;
                case "Google Pixel 5":
                    driver = new AndroidDriver(Objects.requireNonNull(url), SampleSauceLabAndroid.desiredCapabilities_PIXEL5());
                    logger.info("Se inicia la prueba en la nube con Google Pixel 5");
                    break;
                case "Samsung Galaxy A23 5G":
                    driver = new AndroidDriver(Objects.requireNonNull(url), SampleSauceLabAndroid.desiredCapabilities_A235G());
                    logger.info("Se inicia la prueba en la nube con Samsung Galaxy A23 5G");
                    break;
                default:
                    throw new IllegalArgumentException("Dispositivo no soportado en Sauce Labs: " + device);
            }
            return;
        }

        device = env.localDeviceDefault();
        switch (device) {
            case "Samsung Galaxy S23 Ultra":
                driver = new AndroidDriver(Objects.requireNonNull(SamplePhysicalAndroid.LocalUrl()), SamplePhysicalAndroid.desiredCapabilities_S23Ultra());
                logger.info("Se inician las pruebas en local con: " + device);
                break;
            default:
                throw new IllegalArgumentException("Dispositivo local no implementado: " + device);
        }
    }
}