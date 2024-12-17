package booking.framework.pages;

import booking.framework.base.BaseMobile;

import booking.framework.cucumber.Hook;
import booking.framework.helpers.ExceptionMessage;
import booking.framework.helpers.ScreenshotUtils;
import booking.framework.objects.InfoObject;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.Duration;
import java.util.Map;

public class InfoPage extends BaseMobile {
    private static final Logger logger = LogManager.getLogger(InfoPage.class);

    public InfoPage(AndroidDriver driver) {
        super(driver);
    }

    public boolean reservarConPago() {
        if (!waitvisibilityBoolean(Duration.ofSeconds(10), InfoObject.btnFinalStep)) {
            click(InfoObject.btnBookNow);
            logger.info("Se da click al botón 'Book now'.");
            return false;
        } else {
            click(InfoObject.btnFinalStep);
            logger.info("Se da click al botón 'Final Step'.");
            return true;
        }
    }

    public void registrarDatos(Map<String, String> datosReserva) throws ExceptionMessage {
        waitClickable(Duration.ofSeconds(60), InfoObject.txtNombre);
        logger.info("Se espera que sea clickeable la caja de texto 'First Name'.");

        String nombre = datosReserva.get("nombre");
        String apellido = datosReserva.get("apellido");
        String email = datosReserva.get("email");
        String direccion = datosReserva.get("direccion");
        String codpostal = datosReserva.get("codigoPostal");
        String ciudad = datosReserva.get("ciudad");
        String telefono = datosReserva.get("telefono");

        type(nombre, InfoObject.txtNombre);
        logger.info("Se ingresa Nombre.");
        type(apellido, InfoObject.txtApellido);
        logger.info("Se ingresa Apellido.");
        type(email, InfoObject.txtEmail);
        logger.info("Se ingresa Email.");
        scrollTo(InfoObject.ventanaInfo, "up", 400);
        logger.info("Se realiza scroll.");

        if (waitvisibilityBoolean(Duration.ofSeconds(3), InfoObject.txtDireccion)) {
            type(direccion, InfoObject.txtDireccion);
            logger.info("Se ingresa Dirección.");
            type(codpostal, InfoObject.txtPostal);
            logger.info("Se ingresa Código postal.");
            scrollTo(InfoObject.ventanaInfo, "up", 400);
            logger.info("Se realiza scroll.");
            type(ciudad, InfoObject.txtCiudad);
            logger.info("Se ingresa ciudad.");
        }

        type(telefono, InfoObject.txtTlf);
        logger.info("Se ingresa teléfono.");

        //Para capturar pantalla con datos sensibles es necesario modificar el FLAG_SECURE del apk a false
        waitvisibility(Duration.ofSeconds(10), InfoObject.btnNextStep);
        logger.info("Se espera que sea visible el botón 'Next step'.");
        click(InfoObject.btnNextStep);
        logger.info("Se da click al botón 'Next step'.");
    }
}