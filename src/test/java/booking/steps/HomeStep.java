package booking.steps;

import booking.framework.cucumber.Hook;
import booking.framework.cucumber.TestBase;
import booking.framework.helpers.ExceptionMessage;

import booking.framework.helpers.ScreenshotUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomeStep extends TestBase {
    @Given("deseo buscar una reserva")
    public void deseoBuscarUnaReserva() {
        searchPage.validateAlerts();
    }

    @When("ingreso los datos correspondientes {string}")
    public void ingresoLosDatosCorrespondientes(String destino) throws InterruptedException, ExceptionMessage {
        /*searchPage.buscarAlojamiento(destino);
        ScreenshotUtils.attachScreenshotToScenario(driver, Hook.getScenario());
         */
    }

    @Then("busco destino.")
    public void buscoDestino() throws ExceptionMessage, InterruptedException {
        /*roomPage.seleccionarHabitaciones();
        ScreenshotUtils.attachScreenshotToScenario(driver, Hook.getScenario());
        infoPage.registrarDatos();
        ScreenshotUtils.attachScreenshotToScenario(driver, Hook.getScenario());
        paymentPage.registrarPago();
        ScreenshotUtils.attachScreenshotToScenario(driver, Hook.getScenario());
         */
    }
}
