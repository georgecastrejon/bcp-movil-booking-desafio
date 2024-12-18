package booking.framework.pages;

import booking.framework.base.BaseMobile;
import booking.framework.cucumber.Hook;
import booking.framework.helpers.ExceptionMessage;
import booking.framework.helpers.ScreenshotUtils;
import booking.framework.objects.RoomObject;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.Duration;

public class RoomPage extends BaseMobile {
    private static final Logger logger = LogManager.getLogger(RoomPage.class);

    public RoomPage(AndroidDriver driver) {
        super(driver);
    }

    public void seleccionarSegundoResultado() throws Exception {
        waitElementLocated(Duration.ofSeconds(60), RoomObject.btnSort);
        logger.info("Se espera que sea visible el botón 'Sort'.");

        waitvisibility(Duration.ofSeconds(30),RoomObject.panelResultadosHotel);
        logger.info("Se espera que sea visible el 'panel de resultados'.");

        clickItemElements(RoomObject.totalOptionRoom,2,RoomObject.panelResultadosHotel,10);
        logger.info("Se da click al segundo resultado de la búsqueda.");

        ScreenshotUtils.attachScreenshotToScenario(driver, Hook.getScenario(), "Selección de segundo resultado");
    }

    public void seleccionarPromocionHabitacion() throws ExceptionMessage {
        waitClickable(Duration.ofSeconds(60), RoomObject.selectRooms);
        logger.info("Se espera que sea visible las opciones disponibles.");

        click(RoomObject.selectRooms);
        logger.info("Se da click en el botón 'See your options'.");

        ScreenshotUtils.attachScreenshotToScenario(driver, Hook.getScenario(), "Selección de promoción habitación");
    }

    private void seleccionarPrimeraHabitacion() throws ExceptionMessage {
        waitElementLocated(Duration.ofSeconds(8), RoomObject.panelResultadosHab);
        logger.info("Se espera que sea localizado el panel de resultados de habitaciones.");

        scrollTo(RoomObject.panelResultadosHab, "up", 200);
        logger.info("Se realiza scroll.");

        if (waitvisibilityBoolean(Duration.ofSeconds(2), RoomObject.selectRoomFirst)) {
            click(RoomObject.selectRoomFirst);
        } else if (waitvisibilityBoolean(Duration.ofSeconds(1), RoomObject.selectRoomFirstTWO)) {
            click(RoomObject.selectRoomFirstTWO);
        } else {
            waitvisibilityBoolean(Duration.ofSeconds(1), RoomObject.selectRoomFirstThree);
            click(RoomObject.selectRoomFirstThree);
        }
        logger.info("Se da click a la primera opción de habitación disponible.");

        ScreenshotUtils.attachScreenshotToScenario(driver, Hook.getScenario(), "Selección primera habitación");
    }

    public void reservarPrimeraHabitacion() throws ExceptionMessage {
        waitClickable(Duration.ofSeconds(60), RoomObject.btnReservar);
        logger.info("Se espera que sea clickeable el botón de 'Reservar'.");

        click(RoomObject.btnReservar);
        logger.info("Se da click en el botón de 'Reservar'.");
    }

    public void seleccionarHabitaciones() throws Exception {
        seleccionarSegundoResultado();
        seleccionarPromocionHabitacion();
        seleccionarPrimeraHabitacion();
        reservarPrimeraHabitacion();
    }
}