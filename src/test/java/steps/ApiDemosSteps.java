package steps;

import Pages.ApiDemoPage;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static Utils.AppiumDriverFactory.driver;

public class ApiDemosSteps extends Base {

    private Pages.ApiDemoPage ApiDemoPage;

    @Given("App is launched")
    public void app_is_launched() {
        ApiDemoPage.verifyAppLaunched();

    }

    @And("I verify that APi demos heading is displayed")
    public void i_verify_that_a_pi_demos_heading_is_displayed() {
        ApiDemoPage.verifyAppLaunched();
    }
    @AfterStep
    public void takesScreenshotOnFailure(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "failure Screenshot");
        }
    }

}
