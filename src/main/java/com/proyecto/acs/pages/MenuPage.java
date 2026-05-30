package com.proyecto.acs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MenuPage extends BasePage {

    private By profileMenu = By.cssSelector(".oxd-userdropdown-name");
    private By logoutOption = By.xpath("//a[text()='Logout']");
    private By collapseMenuButton = By.cssSelector(".oxd-main-menu-search button i");
    private By searchMenuInput = By.cssSelector("input[placeholder='Search']");
    private By adminMenuOption = By.xpath("//span[text()='Admin']");
    private By pimMenuOption = By.xpath("//span[text()='PIM']");
    private By leaveMenuOption = By.xpath("//span[text()='Leave']");
    private By sidePanelContainer = By.cssSelector(".oxd-sidepanel");

    public MenuPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage logout() {
        click(profileMenu);
        click(logoutOption);
        return new LoginPage(driver);
    }

    public void collapseMenu() {
        click(collapseMenuButton);
    }

    public void searchInMenu(String keyword) {
        type(searchMenuInput, keyword);
    }

    public boolean isPimOptionVisibleOnly() {
        return isDisplayed(pimMenuOption);
    }

    public AdminPage clickAdminMenu() {
        click(adminMenuOption);
        return new AdminPage(driver);
    }

    public PIMPage clickPimMenu() {
        click(pimMenuOption);
        return new PIMPage(driver);
    }

    public LeavePage clickLeaveMenu() {
        click(leaveMenuOption);
        return new LeavePage(driver); // Devuelve la página de Leave automáticamente
    }

    public boolean isMenuCollapsed() {
        // Obtenemos todas las clases CSS que tiene el menú en este momento
        String panelClasses = find(sidePanelContainer).getAttribute("class");

        // Si la palabra "toggled" está en el atributo class, significa que está colapsado
        return panelClasses.contains("toggled");
    }
}