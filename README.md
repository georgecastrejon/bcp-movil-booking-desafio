# **Proyecto de Automatización Móvil BCP - Desafió Booking**

Este proyecto automatiza las pruebas móviles de la plataforma **Booking** utilizando:
- **Cucumber** para implementar pruebas BDD (Behavior-Driven Development).
- **GitHub Actions** para la integración continua (CI).
- **Sauce Labs** para la ejecución de pruebas en la nube.

Los resultados de las pruebas se publican automáticamente en **GitHub Pages**.

---

## **Requisitos Previos**

Asegúrate de cumplir con los siguientes requisitos para garantizar la correcta ejecución del proyecto:

### **1. Entorno de Desarrollo**
- **Java 11**  
  Necesario para la compatibilidad con Appium.

- **Appium 2.x (Servidor)**  
  Requerido para realizar pruebas en dispositivos con Android 14 o superior.

- **Node.js (última versión estable)**  
  Necesario para ejecutar el servidor de Appium.

- **Maven (última versión estable)**  
  Utilizado para la gestión de dependencias y la ejecución de las pruebas.

### **2. Configuración de Variables de Entorno**

#### **2.1 Configuración Local**
Para ejecutar pruebas en dispositivos físicos:
1. Define variables de entorno para el **identificador único del dispositivo (UDID)**.
2. **Modelos soportados**:
   - Samsung Galaxy S23 Ultra
   - Samsung Galaxy S9 Plus
   - Poco X5 5G

#### **2.2 Configuración en GitHub Actions**
1. Configura un entorno llamado `SaucelabsTest`.
2. Crea las siguientes variables de entorno necesarias para conectarse a Sauce Labs:
   - **SAUCE_USERNAME**: Tu nombre de usuario en Sauce Labs.
   - **SAUCE_ACCESS_KEY**: Tu clave de acceso en Sauce Labs.

---

## **Cómo Usar el Proyecto**

### **1. Hacer un Fork del Repositorio**
Para utilizar este repositorio y ejecutar las pruebas en tu cuenta de GitHub:
- Ve a [https://github.com/georgecastrejon/bcp-movil-booking-desafio](https://github.com/georgecastrejon/bcp-movil-booking-desafio).
- Haz clic en el botón **Fork** en la esquina superior derecha.

### **2. Ejecución Local**
Para ejecutar el proyecto de forma local:
1. Modifica la variable `execute.saucelabs=false` en el archivo `src/main/resources/global.properties`.
2. Si deseas ejecutar pruebas en un nuevo dispositivo físico:
   - Crea una nueva configuración de capabilities en `src/main/java/booking/framework/capabilities/SamplePhysicalAndroid`.
   - Asegúrate de que el dispositivo tenga el paquete **build-tools** y **platforms** del SDK de Android, según su versión.
3. Actualiza el archivo de configuración local para reflejar el dispositivo deseado:
   ```properties
   local.device.default=Samsung Galaxy S23 Ultra
4. Inicia el servidor Appium antes de ejecutar las pruebas locales con el siguiente comando:
   ```bash
   appium --address 127.0.0.1 --port 4723 --base-path /wd/hub


### 3. **Ejecución desde GitHub Actions:**

Para ejecutar el flujo de trabajo desde GitHub Actions y generar el reporte, sigue estos pasos:

1. **Acceder a GitHub Actions:**
    - Dirígete a la pestaña **Actions** de tu repositorio en GitHub.

2. **Seleccionar el Job:**
    - En el panel izquierdo, busca y haz clic en el job `mobile automation booking CI`.

3. **Iniciar el Workflow:**
    - Haz clic en el botón **Run workflow**.
    - Selecciona la rama `master` desde el selector de ramas.
    - Luego, haz clic en el botón verde **Run workflow** para iniciar la ejecución.

4. **Monitorear la Ejecución:**
    - Espera unos segundos hasta que el workflow comience a ejecutarse.
    - Una vez iniciado, verás el job `run-mobile-tests` en el flujo de trabajo.

5. **Acceder al Reporte:**
    - Dentro del job `run-mobile-tests`, ubica el stage **Show GitHub Pages URL**.
    - Este paso mostrará la URL de GitHub Pages en la salida de la ejecución.
    - La URL redirigirá a la página del reporte generado, que se puede visualizar directamente en el navegador.

---
