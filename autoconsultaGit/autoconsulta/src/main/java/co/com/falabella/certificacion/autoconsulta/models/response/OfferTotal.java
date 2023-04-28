
package co.com.falabella.certificacion.autoconsulta.models.response;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;

import javax.annotation.Generated;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Simulacion",
        "ValorCredito",
        "TasaNMV",
        "TasaEA"
})
@Generated("jsonschema2pojo")
@Getter
public class OfferTotal {

    @JsonProperty("Simulacion")
    private List<Simulacion> simulacion = null;
    @JsonProperty("ValorCredito")
    private String valorCredito;
    @JsonProperty("TasaNMV")
    private String tasaNMV;
    @JsonProperty("TasaEA")
    private String tasaEA;
}
