package co.com.falabella.certificacion.autoconsulta.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.falabella.certificacion.autoconsulta.utils.enums.EnumVariableSesion.TASA_MENSUAL;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ValidarTasaMensual implements Question<String> {

    public static ValidarTasaMensual porcentaje() {
        return new ValidarTasaMensual();
    }

    @Override
    public String answeredBy(Actor actor) {
        return theActorInTheSpotlight().recall(TASA_MENSUAL.getVariableSesion()).toString();
    }
}