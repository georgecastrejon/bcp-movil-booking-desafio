package booking.framework.pages;


import booking.framework.base.BaseMobile;
import booking.framework.objects.SearchObject;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.Duration;

public class SearchPage extends BaseMobile {
    private static final Logger logger = LogManager.getLogger(SearchPage.class);

    public SearchPage(AndroidDriver driver) {
        super(driver);
    }

    public void validateAlerts(){
        if(isElementVisible(SearchObject.popupCookie, Duration.ofSeconds(3))){
            click(SearchObject.btnAcceptCookie);
        }

        if(isElementVisible(SearchObject.popupcreateAccount,Duration.ofSeconds(3))){
            click(SearchObject.closePopupCreateAccount);
        }

        try{
            click(SearchObject.btnCancelSignin);
            waitvisibility(Duration.ofSeconds(2),SearchObject.btnCloseSignin);
            click(SearchObject.btnCloseSignin);
        }catch (Exception e){
            logger.info("No se detecto el intento de logeo con cuenta de google");
        }

    }

    public void seleccionarDestino(String destino){
        waitvisibility(Duration.ofSeconds(3), SearchObject.btnDestino);
        click(SearchObject.btnDestino);
        type(destino, SearchObject.txtDestino);
        waitvisibility(Duration.ofSeconds(3), SearchObject.optDestino);
        click(SearchObject.optDestino);
    }

    public void selecionarFechas(String fechaIni, String fechaFin){
        if(!waitvisibilityBoolean(Duration.ofSeconds(3), SearchObject.popupCalendario)){
            click(SearchObject.btnCalendario);
        }
        logger.info("Inicio la busquedas de fechas");
        selectDateCalendar(SearchObject.popupCalendario, SearchObject.optdiasCalendario, SearchObject.btnSelectDates,fechaIni,fechaFin,120);
    }

    private void selectedEdadNino(int timeoutInSeconds,String optionEdad){
        long startTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - startTime < (long)timeoutInSeconds * 1000) {
            String edadNinoSelected = getText(SearchObject.selectChildren);
            if(!optionEdad.equals(edadNinoSelected)){
                scrollTo(SearchObject.panelChildren, "up",200);
            }else{
                break;
            }
        }
    }

    private void selectedOnlyOneNino(int timeoutInSeconds) throws InterruptedException {
       waitvisibility(Duration.ofSeconds(10),SearchObject.quitChildrenNumber);

        long startTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - startTime < (long)timeoutInSeconds * 1000) {
            String defaultchildern = getText(SearchObject.defaultChildrenNumber);
            if(!defaultchildern.equals("0")){
                click(SearchObject.quitChildrenNumber);
            }else{
                break;
            }
        }
    }

    public void seleccionarHabitacionPersonas(String optionEdad) throws InterruptedException {
        waitClickable(Duration.ofSeconds(3),SearchObject.btnRoomsGuest);
        click(SearchObject.btnRoomsGuest);
        selectedOnlyOneNino(20);
        waitvisibility(Duration.ofSeconds(3),SearchObject.btnChildren);
        click(SearchObject.btnChildren);
        waitvisibility(Duration.ofSeconds(3),SearchObject.panelChildren);
        selectedEdadNino(20,optionEdad);
        click(SearchObject.btnChildrenOk);
        waitvisibility(Duration.ofSeconds(3),SearchObject.resumenChildren);
        click(SearchObject.resumenChildrenApply);
    }

    public void buscarAlojamiento(String destino) throws InterruptedException {
      seleccionarDestino(destino);
      selecionarFechas("14 February 2025","28 February 2025");
      seleccionarHabitacionPersonas("5 years old");

      waitClickable(Duration.ofSeconds(3),SearchObject.btnSearch);
      click(SearchObject.btnSearch);
    }
}
