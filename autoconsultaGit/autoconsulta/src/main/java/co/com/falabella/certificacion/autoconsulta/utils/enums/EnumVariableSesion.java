package co.com.falabella.certificacion.autoconsulta.utils.enums;

public enum EnumVariableSesion {
    CODIGO_MENSAJE("Codigo mensaje"),
    DESCRIPCION_RESPONSE("Descripcion del response"),
    NUMERO_CUOTAS("Numero cuotas"),
    TASA_ANUAL("Tasa anual"),
    TASA_MENSUAL("Tasa mensual"),
    VALOR_CREDITO("Valor total credito"),
    VALOR_PAGO_MENSUAL("Valor mensual");

    private final String variableSesion;

    public String getVariableSesion() {
        return variableSesion;
    }

    EnumVariableSesion(String variableSesion) {
        this.variableSesion = variableSesion;
    }
}
