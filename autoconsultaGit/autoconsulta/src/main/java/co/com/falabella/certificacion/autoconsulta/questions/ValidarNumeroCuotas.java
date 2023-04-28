package co.com.falabella.certificacion.autoconsulta.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.falabella.certificacion.autoconsulta.utils.enums.EnumVariableSesion.NUMERO_CUOTAS;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ValidarNumeroCuotas implements Question<String> {

    public static ValidarNumeroCuotas cuotas() {
        return new ValidarNumeroCuotas();
    }

    @Override
    public String answeredBy(Actor actor) {
        return theActorInTheSpotlight().recall(NUMERO_CUOTAS.getVariableSesion()).toString();
    }
}