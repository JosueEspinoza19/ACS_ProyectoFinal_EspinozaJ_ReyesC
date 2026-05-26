package com.proyecto.acs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminPage extends BasePage {

    // Localizadores
    private By userRoleDropdown = By.xpath("(//div[@class='oxd-select-text-input'])[1]");
    private By adminRoleOption = By.xpath("//span[text()='Admin']");
    private By searchButton = By.cssSelector("button[type='submit']");
    private By tableRecords = By.cssSelector(".oxd-table-body");

    public AdminPage(WebDriver driver) {
        super(driver);
    }

    public void selectAdminRole() {
        click(userRoleDropdown);
        click(adminRoleOption);
    }

    public void clickSearch() {
        click(searchButton);
    }

    public boolean areTableRecordsDisplayed() {
        return isDisplayed(tableRecords);
    }
}