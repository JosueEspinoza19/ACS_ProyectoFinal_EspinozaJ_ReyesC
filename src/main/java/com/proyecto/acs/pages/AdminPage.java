package com.proyecto.acs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;
import java.util.stream.Collectors;

public class AdminPage extends BasePage {

    // Localizadores
    private By userRoleDropdown = By.xpath("(//div[@class='oxd-select-text-input'])[1]");
    private By adminRoleOption = By.xpath("//span[text()='Admin']");
    private By employeeRoleOption = By.xpath("//span[text()='ESS']");
    private By searchButton = By.cssSelector("button[type='submit']");
    private By resetButton = By.xpath("//button[@type='reset']");
    private By tableRecords = By.cssSelector(".oxd-table-card");

    public AdminPage(WebDriver driver) {
        super(driver);
    }

    public void selectAdminRole() {
        click(userRoleDropdown);
        click(adminRoleOption);
    }

    public void selectUserRole(String role) {
        click(userRoleDropdown);
        if ("Admin".equalsIgnoreCase(role)) {
            click(adminRoleOption);
        } else {
            click(employeeRoleOption);
        }
    }

    public void clickSearch() {
        click(searchButton);
    }

    public void clickReset() {
        click(resetButton);
    }

    public boolean areTableRecordsDisplayed() {
        return isDisplayed(tableRecords);
    }

    public int getVisibleUserRowCount() {
        return findAll(tableRecords).size();
    }

    public List<String> getVisibleUserRowTexts() {
        return findAll(tableRecords).stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public void waitForUserRowContaining(String expectedText) {
        By rowContainingText = By.xpath("//div[contains(@class, 'oxd-table-card') and contains(., '" + expectedText + "')]");
        wait.until(ExpectedConditions.presenceOfElementLocated(rowContainingText));
    }

    public boolean isUserRowContainingVisible(String expectedText) {
        By rowContainingText = By.xpath("//div[contains(@class, 'oxd-table-card') and contains(., '" + expectedText + "')]");
        return isDisplayed(rowContainingText);
    }
}