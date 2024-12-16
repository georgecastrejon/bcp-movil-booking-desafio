package booking.framework.pages;


import booking.framework.base.BaseMobile;
import booking.framework.cucumber.Hook;
import booking.framework.helpers.ExceptionMessage;
import booking.framework.helpers.ScreenshotUtils;
import booking.framework.objects.SearchObject;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.Duration;
import java.util.Map;

public class SearchPage extends BaseMobile {
    private static final Logger logger = LogManager.getLogger(SearchPage.class);

    public SearchPage(AndroidDriver driver) {
        super(driver);
    }

    public void validateAlerts() {
        if (isElementVisible(SearchObject.popupCookie, Duration.ofSeconds(3))) {
            click(SearchObject.btnAcceptCookie);
            logger.info("Se detecta alerta de cookie y se acepta.");
        }

        if (isElementVisible(SearchObject.popupcreateAccount, Duration.ofSeconds(3))) {
            click(SearchObject.closePopupCreateAccount);
            logger.info("Se detecta alerta de crear una cuenta y se cierra. ");
        }

        try {
            click(SearchObject.btnCancelSignin);
            waitvisibility(Duration.ofSeconds(5), SearchObject.btnCloseSignin);
            click(SearchObject.btnCloseSignin);
            logger.info("Se deecta popup de intento de logeo y se cierra.");
        } catch (Exception e) {
            logger.info("No se detecto el intento de logeo con cuenta de google.");
        }
    }

    public void seleccionarDestino(String destino) throws ExceptionMessage {
        waitClickable(Duration.ofSeconds(120), SearchObject.btnDestino);
        logger.info("Se detecta que es clickeable la caja de texto Destino.");
        click(SearchObject.btnDestino);
        logger.info("Se da click en la caja de texto Destino.");
        type(destino, SearchObject.txtDestino);
        logger.info("Se escribe el destino deseado.");
        waitvisibility(Duration.ofSeconds(60), SearchObject.optDestino);
        logger.info("Se espera que existan coincidencias del destino consultado.");
        ScreenshotUtils.attachScreenshotToScenario(driver, Hook.getScenario(),"Destino encontrado");
        click(SearchObject.optDestino);
        logger.info("Se selecciona la primera coincidencia de destino.");
    }

    public void selecionarFechas(String fechaIni, String fechaFin) throws ExceptionMessage {
        if (!waitvisibilityBoolean(Duration.ofSeconds(5), SearchObject.popupCalendario)) {
            click(SearchObject.btnCalendario);
        }
        logger.info("Se visualiza calendario disponible.");
        selectDateCalendar(SearchObject.popupCalendario, SearchObject.optdiasCalendario, SearchObject.btnSelectDates, fechaIni, fechaFin, 120);
        logger.info("Se selecciona el rango de fechas deseado.");
        ScreenshotUtils.attachScreenshotToScenario(driver, Hook.getScenario(),"Fechas seleccionadas");
    }

    private void selectedEdadNino(int timeoutInSeconds, String edadNino) throws Exception {
        long startTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - startTime < (long) timeoutInSeconds * 1000) {
            String edadNinoSelected = getText(SearchObject.selectChildren);
            if (!edadNino.equals(edadNinoSelected)) {
                scrollTo(SearchObject.panelChildren, "up", 200);
                logger.info("Se realiza scroll para buscar la cantidad de niño deseada.");
            } else {
                logger.info("Se detecto la cantidad de niño deseado: " + edadNino);
                return;
            }
        }
        throw new Exception("No se encontró la edad del Niño: "+edadNino);
    }

    private void selectedOnlyOneNino(int timeoutInSeconds) throws InterruptedException {
        waitvisibility(Duration.ofSeconds(10), SearchObject.quitChildrenNumber);
        logger.info("Se espera que sea visible el botón elminar niño.");

        long startTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - startTime < (long) timeoutInSeconds * 1000) {
            String defaultchildern = getText(SearchObject.defaultChildrenNumber);
            if (!defaultchildern.equals("0")) {
                click(SearchObject.quitChildrenNumber);
                logger.info("Se elimina un item de niño.");
            } else {
                logger.info("La cantidad de niños es igual a cero.");
                break;
            }
        }

    }

    public void seleccionarHabitacionPersonas(String edadNino) throws Exception {
        waitClickable(Duration.ofSeconds(60), SearchObject.btnRoomsGuest);
        logger.info("Se espera que la caja de texto para seleccionar personas este disponible.");
        click(SearchObject.btnRoomsGuest);
        logger.info("Se da click en la caja de texto para seleccionar personas.");
        selectedOnlyOneNino(30);
        logger.info("Se finaliza la validación de niño igual a 0.");
        waitvisibility(Duration.ofSeconds(30), SearchObject.btnChildren);
        logger.info("Se espera que el botón de agregar niños este visible");
        click(SearchObject.btnChildren);
        logger.info("Se da click en el botón de agregar niños.");
        waitClickable(Duration.ofSeconds(120), SearchObject.panelChildren);
        logger.info("Se espera que el panel de agregar niño sea clickeable.");
        selectedEdadNino(30, edadNino);
        logger.info("Se finaliza la búsqueda de niño deseado.");
        click(SearchObject.btnChildrenOk);
        logger.info("Se realiza click en agregar niño deseado.");
        waitvisibility(Duration.ofSeconds(60), SearchObject.resumenChildren);
        logger.info("Se espera que este visible el panel de selección de personas.");
        ScreenshotUtils.attachScreenshotToScenario(driver, Hook.getScenario(),"Selección de niño");
        click(SearchObject.resumenChildrenApply);
        logger.info("Se da click en aplicar cantidad de personas.");
        ScreenshotUtils.attachScreenshotToScenario(driver, Hook.getScenario(),"Selección de personas");
    }

    public void clickSearch() throws ExceptionMessage {
        waitClickable(Duration.ofSeconds(3), SearchObject.btnSearch);
        logger.info("Se espera que sea clickeable el botón 'Buscar'.");
        click(SearchObject.btnSearch);
        logger.info("Se da click en el botón 'Buscar'.");
        ScreenshotUtils.attachScreenshotToScenario(driver, Hook.getScenario(),"Resultado de búsqueda");
    }

    public void buscarAlojamiento(Map<String, String> datosReserva) throws Exception {
        String destino = datosReserva.get("destino");
        String fechaInicio = datosReserva.get("fechaInicio");
        String fechaFin = datosReserva.get("fechaFin");
        String edadNino = datosReserva.get("edadNino");

        seleccionarDestino(destino);
        selecionarFechas(fechaInicio, fechaFin);
        seleccionarHabitacionPersonas(edadNino);
        clickSearch();
    }
}
