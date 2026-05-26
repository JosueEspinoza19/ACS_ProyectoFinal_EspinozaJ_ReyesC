package com.proyecto.acs.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DriverFactory {

    // Variable estática que mantiene la sesión del navegador viva (Patrón Singleton)
    private static WebDriver driver;

    // Método para inicializar o recuperar la instancia actual del navegador.
    public static WebDriver getDriver() {
        // Solo creamos un navegador nuevo si no existe uno actualmente
        if (driver == null) {

            // WebDriverManager descarga y enlaza la versión correcta de ChromeDriver
            WebDriverManager.chromedriver().setup();

            // Configuramos las opciones del navegador
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            options.addArguments("--disable-notifications");

            // Inicializamos el WebDriver de Chrome con las opciones definidas
            driver = new ChromeDriver(options);

            // Establecemos un tiempo máximo de espera para que carguen las páginas completas
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit(); // Cierra todas las ventanas y termina el proceso de Chrome
            driver = null; // Reiniciamos a null para que el siguiente test abra un navegador limpio
        }
    }
}