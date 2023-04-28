
package co.com.falabella.certificacion.autoconsulta.models.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "MessageCode",
        "Description"
})
@Getter
public class Result {

    @JsonProperty("MessageCode")
    private Integer messageCode;

    @JsonProperty("Description")
    private String description;
}
