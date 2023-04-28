package co.com.falabella.certificacion.autoconsulta.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.falabella.certificacion.autoconsulta.utils.enums.EnumVariableSesion.VALOR_PAGO_MENSUAL;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ValidarPagoMensual implements Question<String> {

    public static ValidarPagoMensual pago() {
        return new ValidarPagoMensual();
    }

    @Override
    public String answeredBy(Actor actor) {
        return theActorInTheSpotlight().recall(VALOR_PAGO_MENSUAL.getVariableSesion()).toString();
    }
}