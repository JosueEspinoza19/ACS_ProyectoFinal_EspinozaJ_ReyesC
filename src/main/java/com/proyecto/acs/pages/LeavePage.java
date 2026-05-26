package com.proyecto.acs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LeavePage extends BasePage {

    private By configureTab = By.xpath("//span[text()='Configure ']");
    private By leaveOnMenu = By.xpath("//span[text()='Leave']");
    private By leaveTypesOption = By.xpath("//a[text()='Leave Types']");
    private By recordsTable = By.cssSelector(".oxd-table-body");
    public LeavePage(WebDriver driver) {
        super(driver);
    }

    public void navigateToLeaveTypes() {
        click(configureTab);
        click(leaveTypesOption);
    }

    public void navigateToLeave() {
        click(leaveOnMenu);
    }

    public boolean isLeaveTypesTableDisplayed() {
        return isDisplayed(recordsTable);
    }
}