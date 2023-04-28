package co.com.falabella.certificacion.autoconsulta.utils.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EnumSeparadores {
  SEPARADOR_COMA(","),
  SEPARADOR_DOS_PUNTOS(":"),
  SEPARADOR_ESPACIO(" "),
  SEPARADOR_FLECHA("->"),
  SEPARADOR_GUION("-"),
  SEPARADOR_PUNTO_COMA(";"),
  SEPARADOR_SLASH("/"),
  SEPARADOR_BACKSLASH("\\"),
  SEPARADOR_VIRGULILLA("~");

  private final String separador;
}
