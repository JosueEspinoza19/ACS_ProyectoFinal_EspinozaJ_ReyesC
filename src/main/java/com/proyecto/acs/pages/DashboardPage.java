package com.proyecto.acs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends BasePage {

    private By timeAtWorkWidgetTitle = By.xpath("//p[text()='Time at Work']");
    private By quickLaunchWidgetTitle = By.xpath("//p[text()='Quick Launch']");
    private By myActionsWidgetTitle = By.xpath("//p[text()='My Actions']");
    private By assignLeaveQuickButton = By.xpath("//button[@title='Assign Leave'] | //p[text()='Assign Leave']/parent::div/button | //button[*[local-name()='svg'] and following-sibling::p[text()='Assign Leave']]");

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public boolean isTimeAtWorkWidgetVisible() {
        return isDisplayed(timeAtWorkWidgetTitle);
    }

    public boolean isQuickLaunchWidgetVisible() {
        return isDisplayed(quickLaunchWidgetTitle);
    }

    public boolean isMyActionsWidgetVisible() {
        return isDisplayed(myActionsWidgetTitle);
    }

    public LeavePage clickAssignLeaveQuickLaunch() {
        click(assignLeaveQuickButton);
        return new LeavePage(driver); // Devuelve la página de Leave para encadenar comprobaciones
    }
}