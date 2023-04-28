package co.com.falabella.certificacion.autoconsulta.exceptions;

public class DescripcionIncorrecta extends AssertionError {

    public static final String DESCRIPCION_INCORRECTA =
            "La descripcion no es igual a la esperada";

    public DescripcionIncorrecta(String mensaje, Throwable causa){ super(mensaje, causa);}

}
