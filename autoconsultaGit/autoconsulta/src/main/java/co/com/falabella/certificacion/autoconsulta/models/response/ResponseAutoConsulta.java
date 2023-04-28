
package co.com.falabella.certificacion.autoconsulta.models.response;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Status",
    "Result",
    "OfferTotal"
})
public class ResponseAutoConsulta {

    @JsonProperty("Status")
    private Status status;

    @JsonProperty("Result")
    @Getter
    private Result result;

    @JsonProperty("OfferTotal")
    @Getter
    private OfferTotal offerTotal;

}
