package co.com.falabella.certificacion.autoconsulta.exceptions;

public class ValorPagoMensualIncorrecto extends AssertionError {

    public static final String VALOR_PAGO_MENSUAL =
            "El valor del pago mensual no es igual al esperado";

    public ValorPagoMensualIncorrecto(String mensaje, Throwable causa){ super(mensaje, causa);}

}
