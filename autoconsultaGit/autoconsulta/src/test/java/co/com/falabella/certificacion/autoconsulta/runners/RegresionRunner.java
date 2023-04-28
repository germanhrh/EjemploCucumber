package co.com.falabella.certificacion.autoconsulta.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/regresion.feature",
                 glue = "co.com.falabella.certificacion.autoconsulta.stepdefinitions")
public class RegresionRunner {}
