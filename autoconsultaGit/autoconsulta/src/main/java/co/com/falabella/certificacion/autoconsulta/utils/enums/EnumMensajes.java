package co.com.falabella.certificacion.autoconsulta.utils.enums;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public enum EnumMensajes {

    SIN_FINANCIACION("Cliente sin financiacion", "Cliente sin opción de financiación"),
    NO_CLIENTE_PREAPROBADO("No cliente con preaprobado", "Tienes un Crédito de Consumo preaprobado(No Cliente)"),
    CLIENTE_PREAPROBADO("Cliente con preaprobado", "¡Acércate a nuestras oficinas!, tienes un Crédito de Consumo preaprobado."),
    CLIENTE_PREAPROBADO_TARJETA_CREDITO("Cliente preaprobado de TC", "¡Bienvenido a un mundo de beneficios! Tienes preaprobada la Tarjeta de Crédito CMR Banco Falabella y en instantes un asesor te ayudará a finalizar el proceso."),
    CLIENTE_AUMENTO_CUPO("Cliente con aumento de cupo en la TC", "¡Acércate a nuestras oficinas!, tienes un aumento de cupo en tu Tarjeta de Crédito CMR Banco Falabella."),
    CLIENTE_CUENTA_CORRIENTE_PREAPROBADO("Cliente con solo cuenta corriente y preaprobado", "¡Acércate a nuestras oficinas!, tienes un Crédito de Consumo preaprobado.");

    EnumMensajes(String caracteristicaCliente, String mensaje) {
        this.caracteristicaCliente = caracteristicaCliente;
        this.mensaje = mensaje;
    }

    private final String caracteristicaCliente;
    private final String mensaje;
    private static final Map<String, String> mapMensaje = Collections
            .unmodifiableMap(initializeMapping());

    public static String getMensaje(String caracteristicaCliente) {
        if (mapMensaje.containsKey(caracteristicaCliente)) {
            return mapMensaje.get(caracteristicaCliente);
        }
        return null;
    }

    private static Map<String, String> initializeMapping() {
        Map<String, String> mapMensaje = new HashMap<>();
        for (EnumMensajes mensaje : EnumMensajes.values()) {
            mapMensaje.put(mensaje.caracteristicaCliente, mensaje.mensaje);
        }
        return mapMensaje;
    }
}
