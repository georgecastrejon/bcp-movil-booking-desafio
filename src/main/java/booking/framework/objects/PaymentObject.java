package booking.framework.objects;

import org.openqa.selenium.By;

public class PaymentObject {
    public static final By txtCardNumber = By.id("com.booking:id/new_credit_card_number_edit");
    public static final By txtFechaExpiracion = By.id("com.booking:id/new_credit_card_expiry_date_edit");
    public static final By txtcvcCode = By.id("com.booking:id/new_credit_card_cvc_edit_text");
    public static final By btnReservar = By.id("com.booking:id/action_button");

}
