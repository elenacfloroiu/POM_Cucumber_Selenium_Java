package comElenaF.stepDefinitions;

import AIBATROS.page_objects.ActivationAccountPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utilis.Constants;

import static comElenaF.stepDefinitions.Hooks.driver;

public class ActivationAccountSteps {
    ActivationAccountPage activationAccountPage = new ActivationAccountPage(driver);

    @And("Enter the new username {string}")
    public void fillNewUserNameField(String username) {
        activationAccountPage.fillUsername(username);
    }

    @And("Enter the new password field {string}")
    public void fillNewPwdField(String pwd) {
        activationAccountPage.fillPassword(pwd);
    }

    @And("Enter the new repeat password field {string}")
    public void fillNewRepeatPwdField(String repeatPwd) {
        activationAccountPage.fillRepeatPassword(repeatPwd);
    }

    @And("Select a secure question with index {int} from the dropdown")
    public void selectSecureQuestion(int i) {
        activationAccountPage.selectSecureAnswer(i);
    }

    @And("Fill the secure answer {string}")
    public void fillSecureAnswer(String secureQuestion) {
        activationAccountPage.secureAnswerField(secureQuestion);
    }

    @And("Press on Submit button")
    public void pressSubmitBtn() {
        activationAccountPage.pressSubmitButton();
    }

    @Then("Redirect to the expired link.")
    public void checkRedirectExpiredLink() {
        Assert.assertEquals(Constants.expiredLink, driver.getCurrentUrl());
    }

    @Then("Display error validation message when repeat password is not equal")
    public void displayValidationWrongRepeatPwd() {
        Assert.assertTrue(activationAccountPage.wrongRepeatPwdValidation().contains(Constants.errorPwdValidationMessageNotTheSame));
    }

    @Then("Display error validation message when password have less than 10 characters")
    public void displayValidationPwdOutOfBounderies() {
        Assert.assertTrue(activationAccountPage.wrongRepeatPwdValidation().contains(Constants.errorPwdValidationMessageOutOfBoundaries));
    }

    /*@When("Fill data with {string} {string} {string} {int} {string}")
    public void fillAllFields(String username, String password, String repeatPassword, int secureQuestionIndex, String secureAnswer) {
        activationAccountPage.fillUsername(username);
        activationAccountPage.fillPassword(password);
        activationAccountPage.fillRepeatPassword(repeatPassword);
        activationAccountPage.selectSecureAnswer(secureQuestionIndex);
        activationAccountPage.secureAnswerField(secureAnswer);
    }*/

    @Then("Assert that the account successfully has been created, redirect to the Login Page")
    public void userWasRedirectedToLoginPage() {
        Assert.assertEquals(Constants.loginURL, driver.getCurrentUrl());
    }
}
