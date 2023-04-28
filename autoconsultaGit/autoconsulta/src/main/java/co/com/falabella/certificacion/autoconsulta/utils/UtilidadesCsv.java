package co.com.falabella.certificacion.autoconsulta.utils;

import lombok.SneakyThrows;
import net.thucydides.core.steps.stepdata.CSVTestDataSource;
import net.thucydides.core.steps.stepdata.TestDataSource;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static co.com.falabella.certificacion.autoconsulta.utils.enums.EnumConstantesCsv.*;
import static co.com.falabella.certificacion.autoconsulta.utils.enums.EnumSeparadores.SEPARADOR_COMA;
import static co.com.falabella.certificacion.autoconsulta.utils.enums.EnumSeparadores.SEPARADOR_PUNTO_COMA;

public final class UtilidadesCsv {

    private UtilidadesCsv() {
    }

    public static Map<String, String> obtenerPrimerDatoPrueba(String nombreCsv, String filtro) {
        try {
            return obtenerDatosPrueba(nombreCsv, filtro).get(0);
        } catch (IndexOutOfBoundsException ex) {
            Logger.error(
                    UtilidadesCsv.class.getSimpleName(),
                    String.format(
                            "No se pudo consultar datos del archivo '%s' con filtro '%s'. Se muestra la excepción '%s'",
                            nombreCsv, filtro, ex));
            throw new IndexOutOfBoundsException();
        }
    }

    @SneakyThrows
    public static List<Map<String, String>> obtenerDatosPrueba(String nombreCsv, String filtro) {
        String rutaCsv =
                Cadenas.concatenarCadenas(
                        RUTA_RECURSOS_DATOS_CSV.getConstanteCsv(),
                        PREFIJO_NOMBRE_DATOS_CSV.getConstanteCsv(),
                        nombreCsv,
                        EXTENSION_NOMBRE_DATOS_CSV.getConstanteCsv());
        TestDataSource datosOrigenCsv =
                new CSVTestDataSource(rutaCsv, SEPARADOR_PUNTO_COMA.getSeparador().charAt(0));
        return obtenerDatosFiltrados(datosOrigenCsv, filtro);
    }

    private static List<Map<String, String>> obtenerDatosFiltrados(
            TestDataSource datosCsv, String cadenaListadoFiltros) {
        List<Map<String, String>> lstTotalDatosCsv = datosCsv.getData();
        if ("".equals(cadenaListadoFiltros)) {
            return lstTotalDatosCsv;
        }
        String[] arrListadoFiltros = cadenaListadoFiltros.split(SEPARADOR_COMA.getSeparador());
        return filtrarDatos(arrListadoFiltros, lstTotalDatosCsv);
    }

    private static List<Map<String, String>> filtrarDatos(
            String[] arrListaFiltros, List<Map<String, String>> lstTotalDatos) {
        return lstTotalDatos
                .stream()
                .filter(fila -> inArray(arrListaFiltros, fila.get(NOMBRE_COLUMNA_FILTRO.getConstanteCsv())))
                .collect(Collectors.toList());
    }

    private static boolean inArray(String[] arr, String item) {
        if (arr.length > 0) {
            for (String n : arr) {
                if (item.trim().equals(n.trim())) {
                    return true;
                }
            }
        }
        return false;
    }
}
