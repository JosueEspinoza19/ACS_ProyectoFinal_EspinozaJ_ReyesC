package com.proyecto.acs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PIMPage extends BasePage {

    private By addEmployeeTab = By.xpath("//a[text()='Add Employee']");
    private By employeeListTab = By.xpath("//a[text()='Employee List']");
    private By firstNameInput = By.name("firstName");
    private By lastNameInput = By.name("lastName");
    private By employeeIdInput = By.xpath("//label[text()='Employee Id']/../following-sibling::div/input");
    private By saveButton = By.cssSelector("button[type='submit']");
    private By requiredErrorMessage = By.xpath("//span[contains(@class, 'oxd-input-field-error-message')]");

    private By searchEmpNameInput = By.xpath("(//input[@placeholder='Type for hints...'])[1]");
    private By searchButton = By.cssSelector("button[type='submit']");
    private By noRecordsFoundText = By.xpath("//span[text()='No Records Found']");
    private By trashIcon = By.cssSelector(".bi-trash");
    private By confirmDeleteButton = By.xpath("//button[contains(@class, 'oxd-button--label-danger')]");
    private By successToast = By.id("oxd-toaster_1");

    public PIMPage(WebDriver driver) {
        super(driver);
    }

    public void goToAddEmployee() {
        click(addEmployeeTab);
    }

    public void goToEmployeeList() {
        click(employeeListTab);
    }

    public void fillEmployeeData(String firstName, String lastName) {
        type(firstNameInput, firstName);
        type(lastNameInput, lastName);
    }

    public void clickSave() {
        click(saveButton);
    }

    public String getEmployeeId() {
        return find(employeeIdInput).getAttribute("value"); // Obtiene el valor autogenerado
    }

    public void searchEmployeeByName(String name) {
        type(searchEmpNameInput, name);
        click(searchButton);
    }

    public void deleteFirstEmployeeInList() {
        click(trashIcon);
        click(confirmDeleteButton);
    }

    public boolean isRequiredMessageDisplayed() {
        return isDisplayed(requiredErrorMessage);
    }

    public boolean isNoRecordsFoundDisplayed() {
        return isDisplayed(noRecordsFoundText);
    }

    public boolean isSuccessToastDisplayed() {
        return isDisplayed(successToast);
    }
}