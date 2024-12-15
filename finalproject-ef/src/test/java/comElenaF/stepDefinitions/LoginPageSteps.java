package comElenaF.stepDefinitions;

import AIBATROS.page_objects.Application;
import AIBATROS.page_objects.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utilis.Constants;

import static comElenaF.stepDefinitions.Hooks.driver;

public class LoginPageSteps {
    LoginPage loginPage;

    @Given("Login Page")
    public void openLoginPage() {
        loginPage = new Application(driver).navigateToLoginPage();
    }

    @When("Fill the user name field")
    public void fillUserNameField() {
        loginPage.fillUsername(Constants.Username);
    }

    @And("Fill the password field")
    public void fillPwdField() {
        loginPage.fillPassword(Constants.Password);
    }

    @And("Click Submit button")
    public void clickOnLoginBtn() {
        loginPage.submit();
    }

    @And("Assert that the user successfully login into its account")
    public void userAccessedItsAccunt() {
        Assert.assertEquals(Constants.dashboardPageName, driver.getTitle());
    }

    @And("Login into the app with the new account: {string}, {string}")
    public void loginWithNewAccount(String username, String pwd) {
        loginPage.fillUsername(username);
        loginPage.fillPassword(pwd);
        loginPage.submit();
    }

}
