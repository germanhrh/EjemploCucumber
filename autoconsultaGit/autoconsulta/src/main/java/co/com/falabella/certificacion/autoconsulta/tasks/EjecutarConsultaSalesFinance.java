package co.com.falabella.certificacion.autoconsulta.tasks;

import co.com.falabella.certificacion.autoconsulta.models.RequestAutoConsulta;
import co.com.falabella.certificacion.autoconsulta.models.response.ResponseAutoConsulta;
import co.com.falabella.certificacion.autoconsulta.utils.enums.EnumCredenciales;
import co.com.falabella.certificacion.autoconsulta.utils.enums.EnumRecursosServicios;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;


import static co.com.falabella.certificacion.autoconsulta.utils.enums.EnumVariableSesion.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class EjecutarConsultaSalesFinance implements Task {

    private String caracteristicas;

    public EjecutarConsultaSalesFinance(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public static EjecutarConsultaSalesFinance conCliente(String caracteristicas) {
        return instrumented(EjecutarConsultaSalesFinance.class, caracteristicas);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(Post.to(EnumRecursosServicios.SALES_FINANCE.getRecurso())
                .with(
                        requestSpecification -> requestSpecification
                                .auth()
                                .preemptive()
                                .basic(EnumCredenciales.CREDENCIALES_AUTO_CONSULTA.getUsuario(), EnumCredenciales.CREDENCIALES_AUTO_CONSULTA.getClave())
                                .contentType(ContentType.JSON)
                                .body(new RequestAutoConsulta(caracteristicas))
                                .log().all(true)));
  //      if(!SerenityRest.lastResponse().as(ResponseAutoConsulta.class).getOfferTotal().getSimulacion().isEmpty()){
  //          actor.remember(
  //                  NUMERO_CUOTAS.getVariableSesion(),
  //                  SerenityRest.lastResponse().as(ResponseAutoConsulta.class).getOfferTotal().getSimulacion().get(0).getNumCuotas());
  //          actor.remember(
  //                  VALOR_PAGO_MENSUAL.getVariableSesion(),
  //                  SerenityRest.lastResponse().as(ResponseAutoConsulta.class).getOfferTotal().getSimulacion().get(0).getValorMensual());
  //      }

        actor.remember(
                DESCRIPCION_RESPONSE.getVariableSesion(),
                SerenityRest.lastResponse().as(ResponseAutoConsulta.class).getResult().getDescription());

        actor.remember(
                CODIGO_MENSAJE.getVariableSesion(),
                SerenityRest.lastResponse().as(ResponseAutoConsulta.class).getResult().getMessageCode());



        actor.remember(
                TASA_ANUAL.getVariableSesion(),
                SerenityRest.lastResponse().as(ResponseAutoConsulta.class).getOfferTotal().getTasaEA());

        actor.remember(
                TASA_MENSUAL.getVariableSesion(),
                SerenityRest.lastResponse().as(ResponseAutoConsulta.class).getOfferTotal().getTasaNMV());

        actor.remember(
                VALOR_CREDITO.getVariableSesion(),
                SerenityRest.lastResponse().as(ResponseAutoConsulta.class).getOfferTotal().getValorCredito());
    }
}
