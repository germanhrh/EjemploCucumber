package co.com.falabella.certificacion.autoconsulta.utils.enums;

public enum EnumRecursosServicios {
  SALES_FINANCE("ProfileClient/autosalesfinance");

  private final String recurso;

  public String getRecurso() {
    return recurso;
  }

  EnumRecursosServicios(String recurso) {
    this.recurso = recurso;
  }
}
