package co.com.falabella.certificacion.autoconsulta.exceptions;

public class CodigoMensajeIncorrecto extends AssertionError{

    public static final String CODIGO_MENSAJE_INCORRECTO =
            "El codigo del mensaje no es igual al esperado";

    public CodigoMensajeIncorrecto(String mensaje, Throwable causa){ super(mensaje, causa);}
}
