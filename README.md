# **Proyecto de Automatización Móvil BCP - Desafió Booking**

Este proyecto automatiza las pruebas móviles de la plataforma **Booking** utilizando:
- **Cucumber** para implementar pruebas BDD (Behavior-Driven Development).
- **GitHub Actions** para la integración continua (CI).
- **Sauce Labs** para la ejecución de pruebas en la nube.

Los resultados de las pruebas se publican automáticamente en **GitHub Pages**.

---

## Autor
**George Castrejon Sandoval**  
*QA Senior Engineer*

Conéctate conmigo en [LinkedIn](https://www.linkedin.com/in/gcastrejon/)

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
- **SDK ANDROID**
  Descargar del SDK los paquetes build-tools y platforms para android 14

### **2. Configuraciones**

#### **2.1 Configuración Local**
Para ejecutar pruebas en dispositivos físicos:
1. Define variables de entorno para el **identificador único del dispositivo (UDID)**.
2. **Modelos soportados**:
   - Samsung Galaxy S23 Ultra (Android 14)
3. El idioma del dispositivo debe estar en inglés

#### **2.2 Configuración en GitHub**
1. Configura un entorno llamado `SaucelabsTest`.
2. Crea las siguientes variables de entorno necesarias para conectarse a Sauce Labs:
   - **SAUCE_USERNAME**: Tu nombre de usuario en Sauce Labs.
   - **SAUCE_ACCESS_KEY**: Tu clave de acceso en Sauce Labs.
3. **Modelos soportados**:
   - Samsung Galaxy S9 (Android 10)
   - Samsung Galaxy A23 5G (Android 13)
   - Google Pixel 5 (Android 14)
#### **2.3 Configuración en SauceLabs**
1. Subir el apk `booking-com-32-9.apk` en la sección App Management

---

## **Cómo Usar el Proyecto**

### **1. Ejecución Local conectado a un dispositivo físico**

1. Modifica la variable `execute.saucelabs=false` en el archivo `src/main/resources/global.properties`.
2. Si deseas ejecutar pruebas en un nuevo dispositivo físico:
   - Crea una nueva configuración de capabilities en `src/main/java/booking/framework/capabilities/SamplePhysicalAndroid`.
   - Asegúrate de que el dispositivo tenga el paquete **build-tools** y **platforms** del SDK de Android, según su versión.
3. Actualiza el archivo de configuración para reflejar el dispositivo deseado:
   ```properties
   local.device.default=Samsung Galaxy S23 Ultra
4. Inicia el servidor Appium antes de ejecutar las pruebas locales con el siguiente comando:
   ```bash
   appium --address 127.0.0.1 --port 4723 --base-path /wd/hub
5. Ejecutar el proyecto:
   ```bash
   mvn clean verify

### **2. Ejecución Local conectando a SauceLbas**

1. Modifica la variable `execute.saucelabs=true` en el archivo `src/main/resources/global.properties`.
2. Actualiza el archivo de configuración para reflejar el dispositivo deseado:
   ```properties
   cloud.device.defaul=Samsung Galaxy S9
3. Ejecutar el proyecto:
   ```bash
   mvn clean verify
   
### 3. **Ejecución desde GitHub Actions:**

Para utilizar este repositorio y ejecutar las pruebas en tu cuenta de GitHub:

1. **Haz un Fork del Repositorio:**
   - Ve a [https://github.com/georgecastrejon/bcp-movil-booking-desafio](https://github.com/georgecastrejon/bcp-movil-booking-desafio).
   - Haz clic en el botón **Fork** en la esquina superior derecha.

2. **Acceder a GitHub Actions:**
    - Dirígete a la pestaña **Actions** de tu repositorio en GitHub.

3. **Seleccionar el Job:**
    - En el panel izquierdo, busca y haz clic en el job `mobile automation booking CI`.

4. **Iniciar el Workflow:**
    - Haz clic en el botón **Run workflow**.
    - Selecciona la rama `master` desde el selector de ramas.
    - Luego, en la opción **Enter device**, escribe el dispositivo que deseas usar para las pruebas (por defecto, está escrito `Samsung Galaxy S9`).
    - Dentro de los corchetes, podrás ver una lista de dispositivos disponibles. Solo debes copiar el nombre del dispositivo que deseas usar y pegarlo en la caja de texto.
    - Luego, haz clic en el botón verde **Run workflow** para iniciar la ejecución.

5. **Monitorear la Ejecución:**
    - Espera unos segundos hasta que el workflow comience a ejecutarse.
    - Una vez iniciado, verás el job `run-mobile-tests` en el flujo de trabajo.

6. **Acceder al Reporte:**
    - Dentro del job `run-mobile-tests`, ubica el stage **Show GitHub Pages URL**.
    - Este paso mostrará la URL de GitHub Pages en la salida de la ejecución.
    - La URL redirigirá a la página del reporte generado, que se puede visualizar directamente en el navegador.
    - Se debe esperar hasta 5 minutos como máximo para que la nueva versión del reporte sea publicada y lo pueda visualizar correctamente.

7. **Configuración del Reporte:**

   La configuración del reporte solo será necesaria por primera y única vez por cuenta de GitHub, después de ejecutar las pruebas. Sigue estos pasos:

   #### 7.1 **Paso 1: Configuración en GitHub Pages**
   1. Dirígete a **Settings** de tu repositorio.
   2. En el menú lateral izquierdo, selecciona **Pages**.
   3. En la sección **Build and deployment**, localiza la opción **Branch** y selecciona **gh-pages**.
   4. En la opción **Folder**, selecciona **/(root)**.
   5. Haz clic en **Save** para guardar la configuración.

   #### 7.2 **Paso 2: Visualizar el Flujo de Trabajo**
   1. Ve al panel de **Actions**.
   2. En la lista de trabajos (jobs) a la izquierda, busca y haz clic en el job denominado **pages-build-deployment**.
   3. Verás que se inicia un nuevo flujo de trabajo que se encargará de publicar el reporte de las pruebas.
---
