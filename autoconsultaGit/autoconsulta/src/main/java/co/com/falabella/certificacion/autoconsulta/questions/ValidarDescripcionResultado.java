package co.com.falabella.certificacion.autoconsulta.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.falabella.certificacion.autoconsulta.utils.enums.EnumVariableSesion.DESCRIPCION_RESPONSE;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ValidarDescripcionResultado implements Question<String> {

    public static ValidarDescripcionResultado mensaje() {
        return new ValidarDescripcionResultado();
    }

    @Override
    public String answeredBy(Actor actor) {
        return theActorInTheSpotlight().recall(DESCRIPCION_RESPONSE.getVariableSesion()).toString();
    }
}