package booking.framework.pages;

import booking.framework.base.BaseMobile;
import booking.framework.objects.PaymentObject;
import io.appium.java_client.android.AndroidDriver;

import java.time.Duration;

public class PaymentPage extends BaseMobile {
    public PaymentPage(AndroidDriver driver) {
        super(driver);
    }

    public void registrarPago(){
        waitvisibility(Duration.ofSeconds(10), PaymentObject.txtCardNumber);
        type("455578876544333",PaymentObject.txtCardNumber);
        type("02/25",PaymentObject.txtFechaExpiracion);
        waitClickable(Duration.ofSeconds(5),PaymentObject.btnpayment);
    }
}
