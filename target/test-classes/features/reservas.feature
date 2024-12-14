# language: en

@smokeTest
Feature: crear reserva

  Como usuario registrado en la plataforma Booking.com,
  Quiero realizar una reserva,
  Para validar funcionalidad del sistema.

  @HappyPath
  Scenario Outline: Crear una reserva correcta
    Given deseo buscar una reserva
    When ingreso los datos correspondientes "<destino>"
    Then busco destino.
    Examples:
      |destino|
      |cusco  |

  @unHappyPath
  Scenario Outline: Crear una reserva correcta
    Given deseo buscar una reserva
    When ingreso los datos correspondientes "<destino>"
    Then busco destino.
    Examples:
      |destino        |
      |cuscojksadhjk  |