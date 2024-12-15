package AIBATROS.page_objects;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class UserManagementPage {
    private WebDriver driver;

    private By newBtn = By.cssSelector("[title='Create new user']");
    private By fillUsernameField = By.cssSelector("[name='login_email']");
    private By saveBtn = By.cssSelector("[title='Save']");
    private By searchInput = By.cssSelector(".search-box [type='search']");
    private By activationLinkBtnLocator = By.cssSelector("[title='Activation Link']");
    private By activationLinkLocator = By.cssSelector(".link-to-be-copied");
    private By errorSnackBarUserExist = By.cssSelector(".st-notify.error");
    private By languageDropdown = By.cssSelector(".eq-language-select .new-select");
    private By dropdownValues = By.cssSelector(".eq-language-select a.link");
    private By userLanguage = By.cssSelector(".eq-language-text");
    private By logOutLocator = By.cssSelector(".left-container-bottom.show-for-large [href='/Account/LogOff']");
    private By warningDeleteUser = By.cssSelector(".confirmation-popup-container");
    private By removeUserBtnPopup = By.cssSelector("button.eq-confirm-btn");
    private By infoTextSelectUser = By.cssSelector(".panel div.info-text");
    private By roleTab = By.id("eq-roles-panel-label");
    private By detailsTab = By.cssSelector(".eq-details-tab");
    private By editBtn = By.cssSelector("#eq-roles-panel .eq-edit-btn");
    private By adminRole = By.cssSelector("[title=\"Admin\"]");
    private By saveRoleBtn = By.cssSelector("#eq-roles-panel .eq-save-btn");
    private By deleteUserBtn = By.cssSelector(".float-right.dots-butns-wrapper");

    public UserManagementPage(WebDriver driver) {
        this.driver = driver;
    }

    public By getActivationLinkLocator() {
        return activationLinkLocator;
    }

    public By getUserLanguage() {
        return userLanguage;
    }

    public void clickNewBtn() {
        driver.findElement(newBtn).click();
    }

    public void setNewUsernameField(String username) {
        driver.findElement(fillUsernameField).sendKeys(username);
    }

    public void saveNewUser() {
        driver.findElement(saveBtn).click();
    }

    public void searchUser(String username) {
        driver.findElement(searchInput).sendKeys(username + Keys.ENTER);
        driver.findElement(By.cssSelector("[title='" + username + "']")).click();
    }

    public void generateActivationLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(activationLinkBtnLocator)));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(activationLinkBtnLocator));
    }

    public void accessTheActivationLink() {
        String activationLinkUrl = driver.findElement(activationLinkLocator).getText();
        driver.findElement(logOutLocator).click();
        driver.get(activationLinkUrl);
    }

    public String getSuccessMessage() {
        return driver.findElement(errorSnackBarUserExist).getText();
    }

    //the dropdown doesn t use select tab
    public void selectDefaultLanguage(String defaultLanguage) {
        driver.findElement(languageDropdown).click();

        List<WebElement> allOptions = driver.findElements(dropdownValues);
        System.out.println(allOptions.size());

        for (int i = 0; i <= allOptions.size() - 1; i++) {
            if (allOptions.get(i).getText().contains(defaultLanguage)) {
                allOptions.get(i).click();
            }
        }
    }

    public void removeUser(String username) {
        searchUser(username);

        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(deleteUserBtn)).build().perform();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.findElement(deleteUserBtn).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(warningDeleteUser)));

        driver.findElement(removeUserBtnPopup).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(infoTextSelectUser)));
    }

    public void assignRoleToUser() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.findElement(roleTab).click();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(editBtn))).click();

        driver.findElement(adminRole).click();
        driver.findElement(saveRoleBtn).click();
    }

    public void clickOnDetailsTab() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(detailsTab)));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(detailsTab));
    }

}
