package co.com.falabella.certificacion.autoconsulta.exceptions;

public class NumeroCuotasIncorrecto extends AssertionError {

    public static final String NUMERO_CUOTAS_INCORRECTO =
            "El numero de cuotas no es igual al esperado";

    public NumeroCuotasIncorrecto(String mensaje, Throwable causa){ super(mensaje, causa);}

}
