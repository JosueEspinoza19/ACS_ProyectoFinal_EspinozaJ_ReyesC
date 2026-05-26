package com.proyecto.acs.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.proyecto.acs.base.BaseTest;
import com.proyecto.acs.pages.LeavePage;
import com.proyecto.acs.pages.LoginPage;

public class LeaveTest extends BaseTest {

    @Test(description = "TC-15: Visualización de la lista de tipos de permisos")
    public void tc15_VerifyLeaveTypesList() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("Admin", "admin123");
        LeavePage leavePage = new LeavePage(driver);
        leavePage.navigateToLeave();
        leavePage.navigateToLeaveTypes();
        Assert.assertTrue(leavePage.isLeaveTypesTableDisplayed(), "La tabla de 'Leave Types' no se cargó correctamente en la interfaz de usuario.");
    }
}