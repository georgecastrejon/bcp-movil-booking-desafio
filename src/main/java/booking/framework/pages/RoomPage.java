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

    public void seleccionarSegundoResultado() throws ExceptionMessage {
        waitElementLocated(Duration.ofSeconds(60), RoomObject.btnSort);
        scrollTo(RoomObject.panelResultadosHotel, "up", 200);

        logger.info("Se espera que sea visibleel botón 'Sort'.");
        click(RoomObject.secondOptionRoom);
        logger.info("Se da click al segundo resultado de la búsqueda.");
        ScreenshotUtils.attachScreenshotToScenario(driver, Hook.getScenario(),"Selección de segundo resultado");
    }

    public void seleccionarPromocionHabitacion() throws ExceptionMessage {
        waitClickable(Duration.ofSeconds(30), RoomObject.selectRooms);
        logger.info("Se espera que sea visible el botón 'See your options.");
        click(RoomObject.selectRooms);
        logger.info("Se da click en el botón 'See your options'.");
        ScreenshotUtils.attachScreenshotToScenario(driver, Hook.getScenario(),"Selección de promoción habitación");
    }

    private void seleccionarPrimeraHabitacion() throws ExceptionMessage {
        waitElementLocated(Duration.ofSeconds(8), RoomObject.panelResultadosHab);
        scrollTo(RoomObject.panelResultadosHab, "up", 400);

        if (waitvisibilityBoolean(Duration.ofSeconds(5), RoomObject.selectRoomFirst)) {
            click(RoomObject.selectRoomFirst);
        } else {
            waitvisibility(Duration.ofSeconds(30), RoomObject.selectRoomFirstTWO);
            click(RoomObject.selectRoomFirstTWO);
        }
        logger.info("Se da click a la primera opción de habitación disponible.");
        ScreenshotUtils.attachScreenshotToScenario(driver, Hook.getScenario(),"Selección primera habitación");
    }

    public void reservarPrimeraHabitacion() throws ExceptionMessage {
        waitClickable(Duration.ofSeconds(60), RoomObject.btnReservar);
        logger.info("Se espera que sea clickeable el botón de 'Reservar'.");
        click(RoomObject.btnReservar);
        ScreenshotUtils.attachScreenshotToScenario(driver, Hook.getScenario(),"Click en reserva");
        logger.info("Se da click en el botón de 'Reservar'.");
    }

    public void seleccionarHabitaciones() throws ExceptionMessage {
        seleccionarSegundoResultado();
        seleccionarPromocionHabitacion();
        seleccionarPrimeraHabitacion();
        reservarPrimeraHabitacion();
    }
}
