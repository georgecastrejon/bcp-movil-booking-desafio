package booking.framework.pages;

import booking.framework.base.BaseMobile;
import booking.framework.objects.PaymentObject;
import io.appium.java_client.android.AndroidDriver;

public class PaymentPage extends BaseMobile {
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
