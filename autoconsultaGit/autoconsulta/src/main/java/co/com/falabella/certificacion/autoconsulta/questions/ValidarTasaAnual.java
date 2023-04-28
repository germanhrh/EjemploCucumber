package co.com.falabella.certificacion.autoconsulta.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.falabella.certificacion.autoconsulta.utils.enums.EnumVariableSesion.TASA_ANUAL;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ValidarTasaAnual implements Question<String> {

    public static ValidarTasaAnual porcentaje() {
        return new ValidarTasaAnual();
    }

    @Override
    public String answeredBy(Actor actor) {
        return theActorInTheSpotlight().recall(TASA_ANUAL.getVariableSesion()).toString();
    }
}