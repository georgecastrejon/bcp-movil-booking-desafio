package booking.framework.objects;

import org.openqa.selenium.By;

public class InfoObject {
    public static final By ventanaInfo = By.id("com.booking:id/content_recycler_view");
    public static final By txtNombre = By.xpath("(//android.widget.EditText[@resource-id='com.booking:id/bui_input_container_content'])[position() = 1]");
    public static final By txtApellido = By.xpath("(//android.widget.EditText[@resource-id='com.booking:id/bui_input_container_content'])[position() = 2]");
    public static final By txtEmail = By.xpath("(//android.widget.AutoCompleteTextView[@resource-id='com.booking:id/bui_input_container_content'])[position() = 1]");

    public static final By txtTlf = By.xpath("//android.widget.TextView[@resource-id=\"com.booking:id/bui_input_container_label\" and @text=\"Mobile Phone *\"]/following-sibling::android.widget.EditText");
    public static final By txtDireccion = By.xpath("//android.widget.TextView[@resource-id=\"com.booking:id/bui_input_container_label\" and @text=\"Address *\"]/following-sibling::android.widget.EditText");
    public static final By txtPostal = By.xpath("//android.widget.TextView[@resource-id=\"com.booking:id/bui_input_container_label\" and @text=\"Zip Code *\"]/following-sibling::android.widget.EditText");
    public static final By txtCiudad = By.xpath("//android.widget.TextView[@resource-id=\"com.booking:id/bui_input_container_label\" and @text=\"City *\"]/following-sibling::android.widget.EditText");

    public static final By btnNextStep = By.xpath("//android.widget.Button[contains(@text,'Next step')]");
    public static final By btnFinalStep = By.xpath("//android.widget.Button[contains(@text,'Final step')]");

}
