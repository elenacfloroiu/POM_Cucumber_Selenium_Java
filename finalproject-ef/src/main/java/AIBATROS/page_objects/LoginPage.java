package AIBATROS.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    private By usernameLocator = By.id("UserName");
    private By passwordLocator = By.id("Password");
    private By loginBtn = By.cssSelector("[name='login']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillUsername(String username) {
        driver.findElement(usernameLocator).sendKeys(username);
    }

    public void fillPassword(String password) {
        driver.findElement(passwordLocator).sendKeys(password);
    }

    public void submit() {
        driver.findElement(loginBtn).click();
    }
}
