# Framework de Automatización de Pruebas: OrangeHRM

Este repositorio contiene un framework de automatización de pruebas robusto, escalable y de fácil mantenimiento diseñado para la plataforma web empresarial **OrangeHRM**. El proyecto mitiga la ineficiencia, lentitud y el error humano asociados con la ejecución manual de pruebas de regresión en sistemas con flujos complejos.

---

## Objetivos del Proyecto

* **Objetivo General:** Desarrollar un framework de automatización escalable aplicando el patrón de diseño **Page Object Model (POM)** para validar la integridad funcional, el control de errores y la interfaz visual de OrangeHRM.
* **Objetivos Específicos:**
    * Configurar un entorno dinámico gestionado por dependencias mediante Maven y WebDriverManager.
    * Diseñar y ejecutar una suite de **16 casos de prueba** que abarquen flujos críticos, caminos alternos y comportamiento de la interfaz gráfica.
    * Estructurar el código fuente en capas aisladas para maximizar la reutilización de código.

---

## Stack Tecnológico y Ambiente

* **Lenguaje de Programación:** Java (OpenJDK 21)
* **Core de Automatización:** Selenium WebDriver (v4.9.0)
* **Framework de Testing:** TestNG (v7.12.0)
* **Gestor de Dependencias:** Maven
* **Reportes de Ejecución:** Allure Report
* **Patrón de Diseño:** Page Object Model (POM)
* **Navegador:** Google Chrome

---

## Arquitectura y Organización del Proyecto

El proyecto está estructurado en cuatro capas lógicas fundamentales dentro del directorio `src/main/java` y `src/test/java`, garantizando una clara separación de responsabilidades:

```text
src/main/java/
│
├── pages/         # Localizadores (PageFactory/By) y acciones específicas por pantalla (POM)
└── utils/         # Configuración global "DriverFactory" para la gestión del navegador
|
src/test/java/
│
├── base/          # Clase BaseTest para gestionar el ciclo de vida de TestNG (@Before/@After)
├── tests/         # Clases exclusivas de validación lógica y aserciones
