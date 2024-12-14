package booking.framework.pages;

import booking.framework.base.BaseMobile;

import booking.framework.helpers.InfoRegistro;
import booking.framework.objects.InfoObject;
import io.appium.java_client.android.AndroidDriver;

public class InfoPage extends BaseMobile {

    public InfoPage(AndroidDriver driver) {
        super(driver);
    }

    public InfoRegistro setDatos() {
        InfoRegistro infoRegistro = new InfoRegistro();
        infoRegistro.setNombre("George");
        infoRegistro.setApellido("Castrejon");
        infoRegistro.setEmail("sandovalcastrejon@gmail.com");
        infoRegistro.setPais("Peru");
        infoRegistro.setDireccion("calle las begonias");
        infoRegistro.setCodigoPostal("1234");
        infoRegistro.setCiudad("lima");
        infoRegistro.setTelefono("99999999");
        return infoRegistro;
    }

    public void registrarDatos() throws InterruptedException {
        waitClickable(60, InfoObject.txtNombre);
        InfoRegistro infoRegistro = setDatos();

        type(infoRegistro.getNombre(),InfoObject.txtNombre);
        type(infoRegistro.getApellido(),InfoObject.txtApellido);
        type(infoRegistro.getEmail(),InfoObject.txtEmail);
        scrollTo(InfoObject.ventanaInfo,"up",400);

        if(waitvisibilityBoolean(3,InfoObject.txtDireccion)){
            type(infoRegistro.getDireccion(),InfoObject.txtDireccion);
            type(infoRegistro.getCodigoPostal(),InfoObject.txtPostal);
            scrollTo(InfoObject.ventanaInfo,"up",400);
            type(infoRegistro.getCiudad(),InfoObject.txtCiudad);
        }

        type(infoRegistro.getTelefono(),InfoObject.txtTlf);
        waitvisibility(5,InfoObject.btnNextStep);
        click(InfoObject.btnNextStep);
        waitvisibility(10,InfoObject.btnFinalStep);
        click(InfoObject.btnFinalStep);
    }


}
