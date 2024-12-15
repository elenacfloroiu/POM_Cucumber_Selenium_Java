package comElenaF.stepDefinitions;

import AIBATROS.page_objects.UserManagementPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utilis.Constants;

import static comElenaF.stepDefinitions.Hooks.driver;

public class UserManagementSteps {
    UserManagementPage userManagementPage = new UserManagementPage(driver);

    @And("Click on \"New\" button")
    public void clickNewUserBtn() {
        userManagementPage.clickNewBtn();
    }

    @And("Fill the new username {string}")
    public void fillTheNewUserNameField(String newUsername) {
        userManagementPage.setNewUsernameField(newUsername);
    }

    @And("Press on Save button")
    public void saveUserName() {
        userManagementPage.saveNewUser();
    }

    @And("Search new user {string}")
    public void searchUser(String newUsername) {
        userManagementPage.searchUser(newUsername);
    }

    @And("Generate \"Activation Link\"")
    public void generateActivationLink() {
        userManagementPage.generateActivationLink();
    }

    @And("Set default language to {string}")
    public void setDefaultLanguage(String defaultLanguage) {
        userManagementPage.selectDefaultLanguage(defaultLanguage);
    }

    @And("Open the Activation link in new tab")
    public void openActivationLinkInNewTab() {
        userManagementPage.accessTheActivationLink();
    }

    @Then("Assert that the selected language is {string}")
    public void userHasTheSelectedLanguage(String defaultLanguage) {
        Assert.assertEquals(defaultLanguage, driver.findElement(userManagementPage.getUserLanguage()).getText());
    }

    @Then("Assert that the activation link has been successfully generated")
    public void linkSuccessfullyGenerated() {
        Assert.assertTrue(driver.findElement(userManagementPage.getActivationLinkLocator()).isDisplayed());
    }

    @Then("Assert error validation snack bar for the already created user {string}")
    public void errorValidationUserAlreadyExist(String newUsername) {
        Assert.assertEquals("Server error:\n" +
                "There is already a user with login name '" + newUsername + "' defined.", userManagementPage.getSuccessMessage());
    }

    @Then("Assert that the user has been redirected to the login page")
    public void userRedirectedToLoginPage() {
        Assert.assertEquals(Constants.loginURL, driver.getCurrentUrl());
    }

    @And("Assign the new account to a Role in order to have access to the app")
    public void assignRoleToNewUser() {
        userManagementPage.assignRoleToUser();
    }

    @And("Navigate back to the Details tab")
    public void navigateToDetailsTab() {
        userManagementPage.clickOnDetailsTab();
    }
}
