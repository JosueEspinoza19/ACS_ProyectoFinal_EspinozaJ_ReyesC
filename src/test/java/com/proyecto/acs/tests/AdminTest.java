package com.proyecto.acs.tests;

import com.proyecto.acs.base.BaseTest;
import com.proyecto.acs.pages.AdminPage;
import com.proyecto.acs.pages.LoginPage;
import com.proyecto.acs.pages.MenuPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminTest extends BaseTest {

    @Test(description = "TC-12: Buscar usuarios del sistema por rol administrativo")
    public void tc12_SearchUsersByAdminRole() {
        LoginPage loginPage = new LoginPage(driver);
        MenuPage menu = loginPage.loginAs("Admin", "admin123");
        AdminPage adminPage = menu.clickAdminMenu();
        adminPage.selectAdminRole();
        adminPage.clickSearch();

        Assert.assertTrue(adminPage.getVisibleUserRowCount() > 0, "La búsqueda por rol Admin no devolvió registros visibles.");
        adminPage.waitForUserRowContaining("Admin");
        Assert.assertTrue(adminPage.isUserRowContainingVisible("Admin"), "La tabla no mostró al menos un usuario con rol Admin.");
    }

    @Test(description = "TC-13: Intentar buscar usuario con combinaciones vacías")
    public void tc13_SearchUsersWithEmptyFilters() {
        LoginPage loginPage = new LoginPage(driver);
        MenuPage menu = loginPage.loginAs("Admin", "admin123");
        AdminPage adminPage = menu.clickAdminMenu();
        adminPage.clickSearch();

        Assert.assertTrue(adminPage.getVisibleUserRowCount() > 0, "La lista completa de usuarios no se recargó al buscar sin filtros.");
    }
}
