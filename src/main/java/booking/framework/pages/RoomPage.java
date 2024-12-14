package booking.framework.pages;

import booking.framework.base.BaseMobile;
import booking.framework.objects.RoomObject;
import io.appium.java_client.android.AndroidDriver;

public class RoomPage extends BaseMobile {

    public RoomPage(AndroidDriver driver) {
        super(driver);
    }

    public void seleccionarSegundoResultado(){
        wait(30, RoomObject.btnSort);
        click(RoomObject.secondOptionRoom);
    }

    public void seleccionarPromocionHabitacion(){
        waitClickable(30,RoomObject.selectRooms);
        click(RoomObject.selectRooms);
        seleccionarPrimeraHabitacion();
    }

    private void seleccionarPrimeraHabitacion(){
        if(waitvisibilityBoolean(5,RoomObject.selectRoomFirst)){
            click(RoomObject.selectRoomFirst);
        }else{
            waitvisibility(5,RoomObject.selectRoomFirstTWO);
            click(RoomObject.selectRoomFirstTWO);
        }
    }

    public void reservarPrimeraHabitacion(){
        waitClickable(3, RoomObject.btnReservar);
        click(RoomObject.btnReservar);
    }

    public void seleccionarHabitaciones(){
        seleccionarSegundoResultado();
        seleccionarPromocionHabitacion();
        reservarPrimeraHabitacion();
    }
}
