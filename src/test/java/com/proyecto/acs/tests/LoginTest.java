package com.proyecto.acs.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.proyecto.acs.base.BaseTest;
import com.proyecto.acs.pages.MenuPage;
import com.proyecto.acs.pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test(description = "TC-01: Login exitoso con credenciales válidas")
    public void tc01_SuccessfulLogin() {
        LoginPage loginPage = new LoginPage(driver);
        MenuPage menu = loginPage.loginAs("Admin", "admin123");
        Assert.assertTrue(menu.isPimOptionVisibleOnly(), "El login falló: No se cargó el Dashboard.");
    }

    @Test(description = "TC-02: Intento de login con contraseña incorrecta")
    public void tc02_InvalidPasswordLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("Admin", "clavefalsa");
        Assert.assertEquals(loginPage.getErrorMessage(), "Invalid credentials", "El mensaje de error de credenciales no coincide.");
    }

    @Test(description = "TC-03: Intento de login con campos vacíos")
    public void tc03_EmptyFieldsLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLoginWithoutData();
        Assert.assertTrue(loginPage.isRequiredMessageDisplayed(), "No se mostró la validación de campos obligatorios 'Required'.");
    }

    @Test(description = "TC-04: Recuperación de contraseña")
    public void tc04_ForgotPasswordLink() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickForgotPassword();
        Assert.assertTrue(loginPage.isResetPasswordPageDisplayed(), "El enlace no redirigió a la página de Reset Password.");
    }
}