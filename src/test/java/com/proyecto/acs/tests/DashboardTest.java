package com.proyecto.acs.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.proyecto.acs.base.BaseTest;
import com.proyecto.acs.pages.DashboardPage;
import com.proyecto.acs.pages.LoginPage;

public class DashboardTest extends BaseTest {

    @Test(description = "TC-17: Validar visibilidad del widget 'Time at Work'")
    public void tc17_VerifyTimeAtWorkWidget() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("Admin", "admin123");
        DashboardPage dashboardPage = new DashboardPage(driver);
        Assert.assertTrue(dashboardPage.isTimeAtWorkWidgetVisible(), "El widget 'Time at Work' no se encuentra visible en el Dashboard.");
    }

    @Test(description = "TC-18: Validar visibilidad del widget 'Quick Launch'")
    public void tc18_VerifyQuickLaunchWidget() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("Admin", "admin123");
        DashboardPage dashboardPage = new DashboardPage(driver);
        Assert.assertTrue(dashboardPage.isQuickLaunchWidgetVisible(), "El widget 'Quick Launch' no cargó en la interfaz.");
    }

    @Test(description = "TC-19: Navegación exitosa usando el atajo 'Assign Leave'")
    public void tc19_QuickLaunchAssignLeaveNavigation() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("Admin", "admin123");
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.clickAssignLeaveQuickLaunch();
        boolean isCorrectUrl = driver.getCurrentUrl().contains("leave/assignLeave");
        Assert.assertTrue(isCorrectUrl, "El botón de Quick Launch no redirigió a la página de 'Assign Leave'.");
    }

    @Test(description = "TC-20: Validar visibilidad del widget 'My Actions'")
    public void tc20_VerifyMyActionsWidget() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("Admin", "admin123");
        DashboardPage dashboardPage = new DashboardPage(driver);
        Assert.assertTrue(dashboardPage.isMyActionsWidgetVisible(), "El widget 'My Actions' no está visible.");
    }
}