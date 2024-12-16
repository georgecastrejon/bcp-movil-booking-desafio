package booking.framework.objects;

import org.openqa.selenium.By;

public class SearchObject {
    private SearchObject() {
    }

    public static final By btnCancelSignin = By.id("com.google.android.gms:id/cancel_signin_button");
    public static final By btnCloseSignin = By.xpath("//android.widget.ImageView[@content-desc=\"Cancel\"]");
    public static final By popupCookie = By.id("com.booking:id/gdpr_consent_heading");
    public static final By btnAcceptCookie = By.id("com.booking:id/bt_accept");
    public static final By popupcreateAccount = By.xpath("//android.widget.TextView[@text=\"Sign in or create an account\"]");
    public static final By closePopupCreateAccount = By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]");
    public static final By btnDestino = By.xpath("//androidx.recyclerview.widget.RecyclerView[2]//android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[1]");
    public static final By txtDestino = By.xpath("//android.widget.EditText[@text='Enter destination']");
    public static final By optDestino = By.xpath("//android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]");
    public static final By btnCalendario = By.xpath("//androidx.recyclerview.widget.RecyclerView[2]//android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[2]");
    public static final By popupCalendario = By.id("com.booking:id/calendar_month_list");
    public static final By optdiasCalendario = By.xpath("//android.view.View[@content-desc]");
    public static final By btnSelectDates = By.id("com.booking:id/facet_date_picker_confirm");
    public static final By btnRoomsGuest = By.id("com.booking:id/facet_search_box_accommodation_occupancy");
    public static final By btnChildren = By.xpath("(//android.widget.Button[@resource-id='com.booking:id/bui_input_stepper_add_button'])[last()]");
    public static final By panelChildren = By.id("android:id/parentPanel");
    public static final By selectChildren = By.id("android:id/numberpicker_input");//5 years old
    public static final By defaultChildrenNumber = By.xpath("(//android.widget.TextView[@resource-id='com.booking:id/bui_input_stepper_value'])[position() = 3]");
    public static final By quitChildrenNumber = By.xpath("(//android.widget.Button[@resource-id=\"com.booking:id/bui_input_stepper_remove_button\"])[3]");
    public static final By btnChildrenOk = By.id("android:id/button1");
    public static final By resumenChildren = By.id("com.booking:id/group_config_main_configs");
    public static final By resumenChildrenApply = By.id("com.booking:id/group_config_apply_button");
    public static final By btnSearch = By.id("com.booking:id/facet_search_box_cta");
}