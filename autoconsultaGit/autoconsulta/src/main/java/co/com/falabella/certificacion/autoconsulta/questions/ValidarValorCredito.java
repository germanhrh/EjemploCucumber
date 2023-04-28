package co.com.falabella.certificacion.autoconsulta.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.falabella.certificacion.autoconsulta.utils.enums.EnumVariableSesion.VALOR_CREDITO;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ValidarValorCredito implements Question<String> {

    public static ValidarValorCredito precio() {
        return new ValidarValorCredito();
    }

    @Override
    public String answeredBy(Actor actor) {
        return theActorInTheSpotlight().recall(VALOR_CREDITO.getVariableSesion()).toString();
    }
}