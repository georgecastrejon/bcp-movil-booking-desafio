package booking.steps;

import booking.framework.cucumber.TestBase;
import booking.framework.helpers.ExceptionMessage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Map;

public class ReservaStep extends TestBase {
    private Map<String, String> datosReserva;

    @Given("deseo realizar una reserva para dos adultos y un niño")
    public void deseorealizarunareservaparadosadultosyunnino() throws ExceptionMessage {
        searchPage.validateAlerts();
    }

    @When("ingreso los datos correspondientes")
    public void ingresoLosDatosCorrespondientes(DataTable dataTable) throws Exception {
        datosReserva = dataTable.asMap(String.class, String.class);
        searchPage.buscarAlojamiento(datosReserva);
        roomPage.seleccionarHabitaciones();
        infoPage.registrarDatos(datosReserva);
    }

    @Then("realizo la reserva.")
    public void realizolareserva(){
        if(infoPage.reservarConPago()){
            paymentPage.registrarPago(datosReserva);
        }
    }
}