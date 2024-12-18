@smokeTest
Feature: crear reserva

  Como usuario registrado en la plataforma Booking.com,
  Quiero realizar una reserva,
  Para validar funcionalidad del sistema.

  @HappyPath
  Scenario: Crear una reserva correcta
    Given deseo realizar una reserva para dos adultos y un niño
    When ingreso los datos correspondientes
      | Campo              | Valor              |
      | destino            | Cusco              |
      | fechaInicio        | 14 February 2025   |
      | fechaFin           | 28 February 2025   |
      | edadNino           | 5 years old        |
      | nombre             | Juan               |
      | apellido           | Perez              |
      | email              | juanp@example.com  |
      | direccion          | Av. Principal 123  |
      | codigoPostal       | 08000              |
      | ciudad             | Cusco              |
      | telefono           | 987654321          |
      | numeroTarjeta      | 455578876544333    |
      | fechaExpiracion    | 02/25              |
      | cvcCode            | 152                |
    Then realizo la reserva.

  @unHappyPath
  Scenario: Crear una reserva incorrecta
    Given deseo realizar una reserva para dos adultos y un niño
    When ingreso los datos correspondientes
      | Campo              | Valor              |
      | destino            | Cusco              |
      | fechaInicio        | 14 February 2025   |
      | fechaFin           | 28 February 2025   |
      | edadNino           | 456                |
      | nombre             | Juan               |
      | apellido           | Perez              |
      | email              | juanp@example.com  |
      | direccion          | Av. Principal 123  |
      | codigoPostal       | 08000              |
      | ciudad             | Cusco              |
      | telefono           | 987654321          |
      | numeroTarjeta      | 455578876544333    |
      | fechaExpiracion    | 02/25              |
      | cvcCode            | 152                |
    Then realizo la reserva.
