# language: es

Característica: Ejecutar regresion para el componente AutoConsulta
  Yo como persona de negocio
  deseo realizar la regresion del componente AutoConsulta
  para garantizar que los flujos criticos se encuentren estables


  Esquema del escenario: Ejecutar regresion para el componente AutoConsulta
    Cuando René ejecute el servicio de AutoConsulta con un cliente que cuenta con la característica "<Característica>"
    Entonces el servicio responde con el mensaje "<mensaje>" y el código <código>

    Ejemplos:
      | Característica                                                                      | mensaje                    | código |
      | Cliente con contrato cerrado y cupo preaprobado                                     | No cliente con preaprobado | 10     |
      | Cliente existente  con mora y cupo preaprobado                                      | Cliente sin financiacion   | 9      |
#     | Cliente existente con castigo y cupo preaprobado                                    | Cliente sin financiacion   | 9      |
      | Cliente con cupo preaprobado y tipo CE                                              | Cliente sin financiacion   | 9      |
      | Cliente con tarjeta de credito sin preaprobado                                      | Cliente sin financiacion   | 9      |
      | Cliente existente en lista robinson con cupo preaprobado                            | Cliente con preaprobado    | 10      |
      | Cliente existente con cupo preaprobado y tipo CC                                    | Cliente con preaprobado    | 9      |
      | Cliente no creado en flex con preaprobado                                           | No cliente con preaprobado | 10      |
      | Cliente no creado con preaprobado de tarjeta                                        | Cliente preaprobado de TC  | 1      |
      | Cliente no existente en el banco con cupo preaprobado                               | No cliente con preaprobado | 10     |
#     | Cliente que cuente con productos cancelados                                         | No cliente con preaprobado | 10     |
      | Cliente que cuente unicamente con cuenta de ahorro en el banco con cupo preaprobado | Cliente sin financiacion   | 9      |
#     | Cliente que cuente unicamente con TC en el banco sin cupo preaprobado               | Cliente sin financiacion   | 9      |
      | Cliente que cuente unicamente con cuenta de ahorro en el banco sin cupo preaprobado | Cliente sin financiacion   | 9      |
      | Cliente que cuente con cuenta de ahorro inactiva sin cupo preaprobado               | Cliente sin financiacion   | 9      |
      | Cliente que cuente con cuenta corriente inactiva sin cupo preaprobado               | Cliente sin financiacion   | 9      |

  Esquema del escenario: Escenario regresion para validar simulacion de credito.
    Cuando René ejecute el servicio de AutoConsulta con un cliente que cuenta con la característica "<Característica>"
    Entonces el servicio responde con la siguiente informacion
      | Numero cuotas | 60              |
      | Valor mensual | <valor mensual> |
      | Valor credito | <valor credito> |
      | Tasa mensual  | 1,500           |
      | Tasa Anual    | 19,561          |
      | mensaje       | <mensaje>       |
    Ejemplos:
      | Característica                                             | mensaje                 | valor mensual | valor credito |
      | Cliente existente con cupo preprobado menor a 30 millones  | Cliente con preaprobado | $692.995,63   | $26.000.000   |
      | Cliente existente con cupo preaprobado mayor a 30 millones | Cliente con preaprobado | $799.610,35   | $30.000.000   |

