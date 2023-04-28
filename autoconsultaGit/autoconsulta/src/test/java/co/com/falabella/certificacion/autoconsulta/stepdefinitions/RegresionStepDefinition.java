package co.com.falabella.certificacion.autoconsulta.stepdefinitions;

import co.com.falabella.certificacion.autoconsulta.exceptions.DescripcionIncorrecta;
import co.com.falabella.certificacion.autoconsulta.exceptions.NumeroCuotasIncorrecto;
import co.com.falabella.certificacion.autoconsulta.exceptions.ValorDelCreditoIncorrecto;
import co.com.falabella.certificacion.autoconsulta.exceptions.ValorPagoMensualIncorrecto;
import co.com.falabella.certificacion.autoconsulta.questions.*;
import co.com.falabella.certificacion.autoconsulta.tasks.EjecutarConsultaSalesFinance;
import co.com.falabella.certificacion.autoconsulta.utils.enums.EnumMensajes;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.rest.SerenityRest;

import java.util.Map;

import static co.com.falabella.certificacion.autoconsulta.exceptions.DescripcionIncorrecta.DESCRIPCION_INCORRECTA;
import static co.com.falabella.certificacion.autoconsulta.exceptions.NumeroCuotasIncorrecto.NUMERO_CUOTAS_INCORRECTO;
import static co.com.falabella.certificacion.autoconsulta.exceptions.ValorDelCreditoIncorrecto.VALOR_CREDITO_INCORRECTO;
import static co.com.falabella.certificacion.autoconsulta.exceptions.ValorPagoMensualIncorrecto.VALOR_PAGO_MENSUAL;
import static co.com.falabella.certificacion.autoconsulta.utils.enums.EnumVariableSesion.CODIGO_MENSAJE;
import static co.com.falabella.certificacion.autoconsulta.utils.enums.EnumVariableSesion.DESCRIPCION_RESPONSE;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class RegresionStepDefinition {
    @Cuando("René ejecute el servicio de AutoConsulta con un cliente que cuenta con la característica {string}")
    public void ejecutarServicioAutoConsulta(String caracteristicaCliente) {
        theActorInTheSpotlight()
                .attemptsTo(EjecutarConsultaSalesFinance.conCliente(caracteristicaCliente));
        System.out.println(SerenityRest.lastResponse().body().prettyPrint());
    }

    @Entonces("el servicio responde con el mensaje {string} y el código {int}")
    public void VerificarMensajeCodigo(String mensaje, int codigo) {
        System.out.println(theActorInTheSpotlight().recall(CODIGO_MENSAJE.getVariableSesion()).toString());
        System.out.println(codigo);
        System.out.println("El que se envia desde el feature" + EnumMensajes
                .getMensaje(mensaje));
        System.out.println("El que se saca del servicio" + theActorInTheSpotlight().recall(DESCRIPCION_RESPONSE.getVariableSesion()).toString());
        System.out.println(ValidarDescripcionResultado.mensaje());
        theActorInTheSpotlight().should(
                // seeThat(
                //         ValidarCodigo.mensaje(), equalTo(codigo)).orComplainWith(
                //         CodigoMensajeIncorrecto.class, CODIGO_MENSAJE_INCORRECTO),
                seeThat(
                        ValidarDescripcionResultado.mensaje(), equalTo(EnumMensajes.getMensaje(mensaje))).orComplainWith(
                        DescripcionIncorrecta.class, DESCRIPCION_INCORRECTA));
    }

    @Entonces("el servicio responde con la siguiente informacion")
    public void verificarOfertaTotal(Map<String, String> ofertaTotal) {
        System.out.println(theActorInTheSpotlight().recall(DESCRIPCION_RESPONSE.getVariableSesion()).toString());
        System.out.println(EnumMensajes
                .getMensaje(ofertaTotal.get("mensaje")));
        theActorInTheSpotlight().should(
                seeThat(
                        ValidarDescripcionResultado.mensaje(), equalTo(EnumMensajes
                                .getMensaje(ofertaTotal.get("mensaje")))).orComplainWith(
                        DescripcionIncorrecta.class, DESCRIPCION_INCORRECTA),
                seeThat(
                        ValidarNumeroCuotas.cuotas(), equalTo(ofertaTotal.get("Numero cuotas"))).orComplainWith(
                        NumeroCuotasIncorrecto.class, NUMERO_CUOTAS_INCORRECTO),
                seeThat(
                        ValidarPagoMensual.pago(), equalTo(ofertaTotal.get("Valor mensual"))).orComplainWith(
                        ValorPagoMensualIncorrecto.class, VALOR_PAGO_MENSUAL),
                seeThat(
                        ValidarValorCredito.precio(), equalTo(ofertaTotal.get("Valor credito"))).orComplainWith(
                        ValorDelCreditoIncorrecto.class, VALOR_CREDITO_INCORRECTO),
                seeThat(
                        ValidarTasaMensual.porcentaje(), equalTo(ofertaTotal.get("Tasa mensual"))),
                seeThat(
                        ValidarTasaAnual.porcentaje(), equalTo(ofertaTotal.get("Tasa Anual"))));
    }
}

