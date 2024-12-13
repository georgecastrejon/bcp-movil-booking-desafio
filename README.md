# Proyecto de Automatización con cucumber,Saucelabs y GitHub Actions

Este proyecto automatiza las pruebas móviles de la la plataforma  **Booking** utilizando **cucumber** para pruebas BDD **GitHub Actions** para la integración continua. 

Las pruebas se ejecutan automáticamente a través de GitHub Actions con Saucelabs, y los resultados se publican en **GitHub Pages**.

## Requisitos Previos

- **Java 8**
- **Maven** para gestionar dependencias y ejecutar las pruebas.

## Cómo Usar el Proyecto

### 1. **Fork del Repositorio:**

Para utilizar este repositorio y ejecutar las pruebas en tu propia cuenta de GitHub, sigue estos pasos:

- Ve a [https://github.com/georgecastrejon/bcp-movil-booking-desafio](https://github.com/georgecastrejon/bcp-movil-booking-desafio).
- Haz clic en el botón **Fork** en la esquina superior derecha de la página.

### 2. **Configuración Manual de GitHub Pages:**

Para la publicación correcta del reporte, sigue estos pasos para configurar **GitHub Pages**:

1. Ve a la pestaña **Settings** de tu repositorio en GitHub.
2. En el menú lateral, busca la sección **Pages**.
3. En el campo **Source**, selecciona la rama `gh-pages`, selecciona la opción `/(root)` y haz clic en **Save**.

### 2. **Ejecución desde GitHub Actions:**

Para ejecutar el flujo de trabajo desde GitHub Actions y generar el reporte, sigue estos pasos:

1. **Acceder a GitHub Actions:**
    - Dirígete a la pestaña **Actions** de tu repositorio en GitHub.

2. **Seleccionar el Job:**
    - En el panel izquierdo, busca y haz clic en el job `mobile automation booking CI`.

3. **Iniciar el Workflow:**
    - Haz clic en el botón **Run workflow**.
    - Selecciona la rama `main` o la rama correspondiente desde el selector de ramas.
    - Luego, haz clic en el botón verde **Run workflow** para iniciar la ejecución.

4. **Monitorear la Ejecución:**
    - Espera unos segundos hasta que el workflow comience a ejecutarse.
    - Una vez iniciado, verás el job `run-mobile-tests` en el flujo de trabajo.

5. **Acceder al Reporte:**
    - Dentro del job `run-mobile-tests`, ubica el stage **Show GitHub Pages URL**.
    - Este paso mostrará la URL de GitHub Pages en la salida de la ejecución.
    - La URL redirigirá a la página del reporte generado, que se puede visualizar directamente en el navegador.

---
