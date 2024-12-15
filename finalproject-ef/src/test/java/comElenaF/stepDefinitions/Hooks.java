package comElenaF.stepDefinitions;

import AIBATROS.page_objects.UserManagementPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilis.Constants;

import java.time.Duration;

public class Hooks {
    public static WebDriver driver;

    @Before
    public void beforeScenario() {
        System.out.println("This will run before the scenario");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @After("not @Cleanup")
    public void afterTearDown() {
        System.out.println("This will run after scenario!!");
        driver.quit();
    }

    @After("@Cleanup")
    public void afterTagScenarios() {
        UserManagementPage userManagementPage = new UserManagementPage(driver);
        System.out.println("This will run after tagged scenarios!!");
        driver.navigate().refresh();

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.alertIsPresent());
            Alert simpleAlert = driver.switchTo().alert();
            simpleAlert.accept();
            System.out.println("Unexpected alert accepted");
        } catch (Exception e) {
            System.out.println("unexpected alert not present");
        }

        userManagementPage.removeUser(Constants.NewUsername);
        driver.quit();
    }
}
