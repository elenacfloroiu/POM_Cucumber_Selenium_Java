package AIBATROS.page_objects;

import org.openqa.selenium.WebDriver;

public class Application {
    public WebDriver driver;

    public Application(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage navigateToLoginPage() {
        driver.get("https://training-aibatros.calcon.de/Account/Login");
        return new LoginPage(driver);
    }

}
