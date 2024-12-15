package AIBATROS.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ActivationAccountPage {
    private WebDriver driver;

    private By usernameField = By.id("User");
    private By passwordField = By.id("NewPassword");
    private By repeatPasswordField = By.id("ConfirmPassword");
    private By secureQuestionDropdown = By.id("SecureQuestion");
    private By secureAnswerField = By.id("SecureAnswer");
    private By submitBtn = By.cssSelector("[type=submit]");
    private By errorValidationWrongRepeatPwd = By.cssSelector(".validation-summary-errors");

    public ActivationAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void fillPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void fillRepeatPassword(String repeatPassword) {
        driver.findElement(repeatPasswordField).sendKeys(repeatPassword);
    }

    public void secureAnswerField(String secureText) {
        driver.findElement(secureAnswerField).sendKeys(secureText);
    }

    public void selectSecureAnswer(int i) {
        Select secureQuestions = new Select(driver.findElement(secureQuestionDropdown));
        secureQuestions.selectByIndex(i);
    }

    public void pressSubmitButton() {
        driver.findElement(submitBtn).click();
    }

    public String wrongRepeatPwdValidation() {
        return driver.findElement(errorValidationWrongRepeatPwd).getText();
    }
}
