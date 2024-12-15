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

    public void seleccionarSegundoResultado(){
        wait(Duration.ofSeconds(30), RoomObject.btnSort);
        click(RoomObject.secondOptionRoom);
    }

    public void seleccionarPromocionHabitacion(){
        waitClickable(Duration.ofSeconds(30),RoomObject.selectRooms);
        click(RoomObject.selectRooms);
        seleccionarPrimeraHabitacion();
    }

    private void seleccionarPrimeraHabitacion(){
        if(waitvisibilityBoolean(Duration.ofSeconds(5),RoomObject.selectRoomFirst)){
            click(RoomObject.selectRoomFirst);
        }else{
            waitvisibility(Duration.ofSeconds(5),RoomObject.selectRoomFirstTWO);
            click(RoomObject.selectRoomFirstTWO);
        }
    }

    public void reservarPrimeraHabitacion(){
        waitClickable(Duration.ofSeconds(10), RoomObject.btnReservar);
        click(RoomObject.btnReservar);
    }

    public void seleccionarHabitaciones(){
        seleccionarSegundoResultado();
        seleccionarPromocionHabitacion();
        reservarPrimeraHabitacion();

    }
}
