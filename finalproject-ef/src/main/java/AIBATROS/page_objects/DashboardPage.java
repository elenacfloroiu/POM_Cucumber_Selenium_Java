package AIBATROS.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class DashboardPage {
    private WebDriver driver;

    private By expandMenuLocator = By.id("expanded-menu");
    private By userManagementLocator = By.cssSelector(".new-left-menu-expanded [href='/UserManagement']");
    private By administrationModule = By.cssSelector(".new-left-menu-expanded  a[href=\"/Admin\"]");
    private By appLanguage = By.tagName("html");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public void expandMenuFunc() {
        driver.findElement(expandMenuLocator).click();
    }

    public void goToDataManagementPage() {
        driver.findElement(userManagementLocator).click();
    }

    public void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector(\".new-left-menu-expanded a[href='/Admin']\").scrollIntoView();");
    }

    public void hoverOnAdministrationMenu() {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(administrationModule)).build().perform();
    }

    public String getAccountLanguage() {
        return driver.findElement(appLanguage).getAttribute("lang");
    }

}
