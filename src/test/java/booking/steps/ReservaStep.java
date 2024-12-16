package booking.steps;

import booking.framework.cucumber.Hook;
import booking.framework.cucumber.TestBase;

import booking.framework.helpers.ScreenshotUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

public class ReservaStep extends TestBase {
    private static final Logger logger = LogManager.getLogger(ReservaStep.class);

    @Given("deseo realizar una reserva para dos adultos y un niño")
    public void deseorealizarunareservaparadosadultosyunnino() {
        searchPage.validateAlerts();
    }

    @When("ingreso los datos correspondientes")
    public void ingresoLosDatosCorrespondientes(DataTable dataTable) throws Exception {
        Map<String, String> datosReserva = dataTable.asMap(String.class, String.class);

        searchPage.buscarAlojamiento(datosReserva);
        ScreenshotUtils.attachScreenshotToScenario(driver, Hook.getScenario(),"Resultado de búsqueda");
        logger.info("Se realiza screenShot al resultado de búsqueda.");

        roomPage.seleccionarHabitaciones();
        infoPage.registrarDatos(datosReserva);
    }

    @Then("realizo la reserva.")
    public void realizolareserva(){
        if(infoPage.reservarConPago()){
            paymentPage.registrarPago();
        }
    }
}