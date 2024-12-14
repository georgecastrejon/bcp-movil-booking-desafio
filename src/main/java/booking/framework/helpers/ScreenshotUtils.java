package booking.framework.helpers;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {
    private static final Logger logger = LogManager.getLogger(ScreenshotUtils.class);

    public static void attachScreenshotToScenario(WebDriver driver, Scenario scenario) throws ExceptionMessage {
        try {
            if (driver instanceof TakesScreenshot) {
                byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshotBytes, "image/png", "Screenshot");
                logger.info("Screenshot capturado y adjuntado con éxito.");
            } else {
                logger.info("El driver no es compatible con capturas de pantalla.");
            }
        } catch (Exception e) {
            throw new ExceptionMessage(e.getMessage());
        }
    }
}