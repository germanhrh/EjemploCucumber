
package co.com.falabella.certificacion.autoconsulta.models.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Code",
        "Detail",
        "ServerId",
        "IosId",
        "MessageError"
})
@Generated("jsonschema2pojo")
public class Status {

    @JsonProperty("Code")
    private String code;
    @JsonProperty("Detail")
    private String detail;
    @JsonProperty("ServerId")
    private Object serverId;
    @JsonProperty("IosId")
    private Object iosId;
    @JsonProperty("MessageError")
    private Object messageError;
}
