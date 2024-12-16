package booking.framework.pages;

import booking.framework.base.BaseMobile;
import booking.framework.objects.RoomObject;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.Duration;

public class RoomPage extends BaseMobile {
    private static final Logger logger = LogManager.getLogger(SearchPage.class);

    public RoomPage(AndroidDriver driver) {
        super(driver);
    }

    public void seleccionarSegundoResultado() {
        waitElementLocated(Duration.ofSeconds(60), RoomObject.btnSort);
        logger.info("Se espera que sea visibleel botón 'Sort'.");
        click(RoomObject.secondOptionRoom);
        logger.info("Se da click al segundo resultado de la búsqueda.");
    }

    public void seleccionarPromocionHabitacion() {
        waitClickable(Duration.ofSeconds(30), RoomObject.selectRooms);
        logger.info("Se espera que sea visible el botón 'See your options.");
        click(RoomObject.selectRooms);
        logger.info("Se da click en el botón 'See your options'.");
    }

    private void seleccionarPrimeraHabitacion() {
        if (waitvisibilityBoolean(Duration.ofSeconds(5), RoomObject.selectRoomFirst)) {
            click(RoomObject.selectRoomFirst);
        } else {
            waitvisibility(Duration.ofSeconds(30), RoomObject.selectRoomFirstTWO);
            click(RoomObject.selectRoomFirstTWO);
        }
        logger.info("Se da click a la primera opción de habitación disponible.");
    }

    public void reservarPrimeraHabitacion() {
        waitClickable(Duration.ofSeconds(60), RoomObject.btnReservar);
        logger.info("Se espera que sea clickeable el botón de 'Reservar'.");
        click(RoomObject.btnReservar);
        logger.info("Se da click en el botón de 'Reservar'.");
    }

    public void seleccionarHabitaciones() {
        seleccionarSegundoResultado();
        seleccionarPromocionHabitacion();
        seleccionarPrimeraHabitacion();
        reservarPrimeraHabitacion();
    }
}
