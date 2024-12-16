package booking.framework.pages;

import booking.framework.base.BaseMobile;
import booking.framework.objects.PaymentObject;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.Duration;

public class PaymentPage extends BaseMobile {
    private static final Logger logger = LogManager.getLogger(PaymentPage.class);

    public PaymentPage(AndroidDriver driver) {
        super(driver);
    }

    public void registrarPago() {
        waitvisibility(Duration.ofSeconds(10), PaymentObject.txtCardNumber);
        logger.info("Se espera que sea visible la caja de texto 'Numero de tarjeta'.");

        type("455578876544333", PaymentObject.txtCardNumber);
        logger.info("Se ingresa número de tarjeta.");
        type("02/25", PaymentObject.txtFechaExpiracion);
        logger.info("Se ingresa Fecha de expiración.");
    }
}