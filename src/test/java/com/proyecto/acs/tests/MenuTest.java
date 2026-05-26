package com.proyecto.acs.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.proyecto.acs.base.BaseTest;
import com.proyecto.acs.pages.MenuPage;
import com.proyecto.acs.pages.LoginPage;

public class MenuTest extends BaseTest {

    @Test(description = "TC-05: Cierre de sesión exitoso")
    public void tc05_SuccessfulLogout() {
        LoginPage loginPage = new LoginPage(driver);
        MenuPage menu = loginPage.loginAs("Admin", "admin123");
        LoginPage loginPageAfterLogout = menu.logout();
        Assert.assertTrue(loginPageAfterLogout.isLoginButtonVisible(), "El cierre de sesión falló: No se redirigió a la pantalla de Login.");
    }

    @Test(description = "TC-06: Visibilidad y colapso del menú lateral izquierdo")
    public void tc06_CollapseSidebarMenu() {
        LoginPage loginPage = new LoginPage(driver);
        MenuPage menu = loginPage.loginAs("Admin", "admin123");
        menu.collapseMenu();
        Assert.assertTrue(menu.isMenuCollapsed(), "El menú lateral no cambió a su estado colapsado (no se inyectó la clase 'toggled').");
    }

    @Test(description = "TC-16: Validación de presencia de la barra de búsqueda rápida")
    public void tc16_SearchInSidebarMenu() {
        LoginPage loginPage = new LoginPage(driver);
        MenuPage menu = loginPage.loginAs("Admin", "admin123");
        menu.searchInMenu("PIM");
        Assert.assertTrue(menu.isPimOptionVisibleOnly(), "El filtro dinámico falló: La opción PIM no es la única visible tras la búsqueda.");
    }
}
