package booking.framework.pages;

import booking.framework.base.BaseMobile;
import booking.framework.objects.PaymentObject;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.Duration;
import java.util.Map;

public class PaymentPage extends BaseMobile {
    private static final Logger logger = LogManager.getLogger(PaymentPage.class);

    public PaymentPage(AndroidDriver driver) {
        super(driver);
    }

    public void registrarPago(Map<String, String> datosReserva) {
        waitvisibility(Duration.ofSeconds(10), PaymentObject.txtCardNumber);
        logger.info("Se espera que sea visible la caja de texto 'Numero de tarjeta'.");

        String numeroTarjeta = datosReserva.get("numeroTarjeta");
        String fechaExpiracion = datosReserva.get("fechaExpiracion");
        String cvcCode = datosReserva.get("cvcCode");

        type(numeroTarjeta, PaymentObject.txtCardNumber);
        logger.info("Se ingresa número de tarjeta.");

        type(fechaExpiracion, PaymentObject.txtFechaExpiracion);
        logger.info("Se ingresa Fecha de expiración.");

        waitClickable(Duration.ofSeconds(1), PaymentObject.txtcvcCode);
        type(cvcCode, PaymentObject.txtcvcCode);
        logger.info("Se ingresa CVC Code.");

        waitClickable(Duration.ofSeconds(1), PaymentObject.btnReservar);
        click(PaymentObject.btnReservar);
        logger.info("Se da click en el botón Reservar.");
    }
}