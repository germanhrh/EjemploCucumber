package co.com.falabella.certificacion.autoconsulta.exceptions;

public class ValorDelCreditoIncorrecto extends AssertionError {

    public static final String VALOR_CREDITO_INCORRECTO =
            "El valor del credito no es igual al esperado";

    public ValorDelCreditoIncorrecto(String mensaje, Throwable causa){ super(mensaje, causa);}

}
