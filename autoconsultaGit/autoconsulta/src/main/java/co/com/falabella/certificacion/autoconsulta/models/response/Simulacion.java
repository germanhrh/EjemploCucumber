
package co.com.falabella.certificacion.autoconsulta.models.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "NumCuotas",
    "ValorMensual"
})
@Generated("jsonschema2pojo")
@Getter
public class Simulacion {

    @JsonProperty("NumCuotas")
    private String numCuotas;
    @JsonProperty("ValorMensual")
    private String valorMensual;
}
