package co.com.falabella.certificacion.autoconsulta.utils.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EnumConstantesCsv {
  RUTA_RECURSOS_DATOS_CSV("src/test/resources/data/"),
  PREFIJO_NOMBRE_DATOS_CSV("datos_"),
  EXTENSION_NOMBRE_DATOS_CSV(".csv"),
  NOMBRE_COLUMNA_FILTRO("idFiltro");

  private final String constanteCsv;
}
