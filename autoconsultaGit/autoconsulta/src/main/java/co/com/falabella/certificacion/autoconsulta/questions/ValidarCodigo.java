package co.com.falabella.certificacion.autoconsulta.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.falabella.certificacion.autoconsulta.utils.enums.EnumVariableSesion.CODIGO_MENSAJE;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ValidarCodigo implements Question<Integer> {
    public static ValidarCodigo mensaje() {
        return new ValidarCodigo();
    }

    @Override
    public Integer answeredBy(Actor actor) {
        return Integer.parseInt(theActorInTheSpotlight().recall(CODIGO_MENSAJE.getVariableSesion()).toString());
    }
}
