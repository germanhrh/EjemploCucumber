package co.com.falabella.certificacion.autoconsulta.utils.enums;

public enum EnumCredenciales {
  CREDENCIALES_AUTO_CONSULTA("usertest", "usertest");

  private final String usuario;
  private final String clave;

  EnumCredenciales(String usuario, String clave) {
    this.usuario = usuario;
    this.clave = clave;
  }

  public String getUsuario() {
    return usuario;
  }

  public String getClave() {
    return clave;
  }
}
