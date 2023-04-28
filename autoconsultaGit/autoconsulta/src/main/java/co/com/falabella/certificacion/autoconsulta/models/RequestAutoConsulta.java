package co.com.falabella.certificacion.autoconsulta.models;

import co.com.falabella.certificacion.autoconsulta.utils.UtilidadesCsv;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Map;

import static co.com.falabella.certificacion.autoconsulta.utils.enums.EnumNombresCsv.CLIENTES;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "TiendaId",
        "TerminalId",
        "AdviserHC",
        "DocumentType",
        "Document",
        "FirstName",
        "LastName"
})
public class RequestAutoConsulta {

    public RequestAutoConsulta(String idFiltro) {
        Map<String, String>
                cliente =
                UtilidadesCsv.obtenerPrimerDatoPrueba(CLIENTES.getNombre(),idFiltro);
        this.tiendaId = cliente.get("Oficina");
        this.terminalId = "131";
        this.adviserHC = "Pruebas";
        this.documentType = cliente.get("TipoDocumento");
        this.document = cliente.get("NumeroDocumento");
        this.firstName = cliente.get("Nombre");
        this.lastName = "Rodriguez";
    }

    @JsonProperty("TiendaId")
    private String tiendaId;
    @JsonProperty("TerminalId")
    private String terminalId;
    @JsonProperty("AdviserHC")
    private String adviserHC;
    @JsonProperty("DocumentType")
    private String documentType;
    @JsonProperty("Document")
    private String document;
    @JsonProperty("FirstName")
    private String firstName;
    @JsonProperty("LastName")
    private String lastName;

}
