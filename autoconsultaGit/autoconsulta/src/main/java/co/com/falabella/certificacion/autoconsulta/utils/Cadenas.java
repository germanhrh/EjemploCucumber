package co.com.falabella.certificacion.autoconsulta.utils;


import co.com.falabella.certificacion.autoconsulta.utils.enums.EnumSeparadores;

import java.util.Arrays;
import java.util.List;

public final class Cadenas {

    private Cadenas() {
    }

    public static String concatenarCadenas(String... cadenas) {
        StringBuilder cadenaConcatenada = new StringBuilder();
        for (Object cadena : cadenas) {
            cadenaConcatenada.append(cadena);
        }
        return cadenaConcatenada.toString().trim();
    }

    public static String concatenarCadenas(EnumSeparadores separador, String... cadenas) {
        StringBuilder cadenaConcatenada = new StringBuilder();
        int indexCadenas = 1;
        int cantidadCadenas = cadenas.length;
        for (Object cadena : cadenas) {
            cadenaConcatenada.append(cadena);
            if (indexCadenas < cantidadCadenas) {
                cadenaConcatenada.append(separador.getSeparador());
                indexCadenas++;
            }
        }
        return cadenaConcatenada.toString().trim();
    }

    public static String concatenarCadenas(EnumSeparadores separador, List<String> lstCadenas) {
        StringBuilder cadenaConcatenada = new StringBuilder();
        for (int indexLista = 0; indexLista < lstCadenas.size(); indexLista++) {
            cadenaConcatenada.append(lstCadenas.get(indexLista));
            if (indexLista < lstCadenas.size() - 1) {
                cadenaConcatenada.append(separador.getSeparador());
            }
        }
        return cadenaConcatenada.toString().trim();
    }

    public static String[] separarCadenas(String cadena, EnumSeparadores enumSeparadores) {
        return Arrays.stream(cadena.split(enumSeparadores.getSeparador()))
                .map(String::trim)
                .toArray(String[]::new);
    }

    public static String eliminarTildesCadena(String cadena) {
        cadena = cadena.replaceAll("á", "a");
        cadena = cadena.replaceAll("Á", "A");
        cadena = cadena.replaceAll("é", "e");
        cadena = cadena.replaceAll("É", "E");
        cadena = cadena.replaceAll("í", "i");
        cadena = cadena.replaceAll("Í", "I");
        cadena = cadena.replaceAll("ó", "o");
        cadena = cadena.replaceAll("Ó", "O");
        cadena = cadena.replaceAll("ú", "u");
        cadena = cadena.replaceAll("Ú", "U");
        return cadena;
    }
}
