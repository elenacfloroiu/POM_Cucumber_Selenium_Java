package comElenaF.stepDefinitions;

import AIBATROS.page_objects.DashboardPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utilis.Constants;

import static comElenaF.stepDefinitions.Hooks.driver;

public class DashboardMenuSteps {
    DashboardPage dashboardPage = new DashboardPage(driver);

    @And("Expand menu")
    public void expandMenu() {
        dashboardPage.expandMenuFunc();
    }

    @And("Scroll down the menu")
    public void scrollDownMenu() {
        dashboardPage.scrollDown();
    }

    @And("Hover on \"Administration\" module")
    public void hoverOnModule() {
        dashboardPage.hoverOnAdministrationMenu();
    }

    @And("Click on \"Users, Groups and Roles\" page")
    public void navigateToUsersGroupsAndRolesPage() {
        dashboardPage.goToDataManagementPage();
    }

    @Then("Assert the language is the same as the one set at the moment off user creation")
    public void validateAccountLanguage() {
        Assert.assertEquals(Constants.englishAbbreviation, dashboardPage.getAccountLanguage());
    }

}
