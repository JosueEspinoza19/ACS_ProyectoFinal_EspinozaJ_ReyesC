package com.proyecto.acs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private By usernameInput = By.name("username");
    private By passwordInput = By.name("password");
    private By loginButton = By.cssSelector("button[type='submit']");
    private By forgotPasswordLink = By.xpath("//p[contains(@class, 'orangehrm-login-forgot-header')]");
    private By errorMessage = By.cssSelector(".oxd-alert-content-text");
    private By requiredMessage = By.xpath("//span[contains(@class, 'oxd-input-field-error-message')]");
    private By resetPasswordHeader = By.xpath("//h6[text()='Reset Password']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public MenuPage loginAs(String username, String password) {
        type(usernameInput, username);
        type(passwordInput, password);
        click(loginButton);
        return new MenuPage(driver);
    }

    public void clickLoginWithoutData() {
        click(loginButton);
    }

    public void clickForgotPassword() {
        click(forgotPasswordLink);
    }

    public String getErrorMessage() {
        return getText(errorMessage);
    }

    public boolean isRequiredMessageDisplayed() {
        return isDisplayed(requiredMessage);
    }

    public boolean isResetPasswordPageDisplayed() {
        return isDisplayed(resetPasswordHeader);
    }

    public boolean isLoginButtonVisible() {
        return isDisplayed(loginButton);
    }
}