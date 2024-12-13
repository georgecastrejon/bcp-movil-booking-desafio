package booking.framework.pages;

import booking.framework.base.BaseMobile;
import booking.framework.objects.PaymentObject;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PaymentPage extends BaseMobile {
    private static final Logger logger = LogManager.getLogger(PaymentPage.class);

    public PaymentPage(AndroidDriver driver) {
        super(driver);
    }

    public void registrarPago(){
        waitvisibility(10, PaymentObject.txtCardNumber);
        type("455578876544333",PaymentObject.txtCardNumber);
        type("02/25",PaymentObject.txtFechaExpiracion);
        waitClickable(5,PaymentObject.btnpayment);
    }

}
