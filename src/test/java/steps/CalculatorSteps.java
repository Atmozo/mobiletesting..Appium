package steps;

import Pages.CalculatorPage;
import io.cucumber.java.en.*;

public class CalculatorSteps {

    CalculatorPage calculatorPage = new CalculatorPage();

    @Given("app is launched")
    public void calculatorAppIsOpen() {
        calculatorPage.verifyAppLaunched();
    }

    @And("the user clicks {string}")
    public void userClicksNumber(String number) {
        calculatorPage.clickButton(number);
    }

    @And("the user clicks the {string} button")
    public void userClicksOperationButton(String operation) {
        calculatorPage.clickOperation(operation);
    }

    @When("the user clicks the equal button")
    public void userClicksEqualButton() {
        calculatorPage.clickEqualButton();
    }

    @Then("the correct Answer is displayed {string}")
    public void verifyCorrectAnswerIsDisplayed(String expectedAnswer) {
        calculatorPage.verifyCorrectAnswerDisplayed(expectedAnswer);
    }

    @Given("the user performs a few operations")
    public void userPerformsOperations() {
        calculatorPage.clickButton("8");
        calculatorPage.clickOperation("plus");
        calculatorPage.clickButton("2");
        calculatorPage.clickEqualButton();
    }

    @And("the user scrolls down to view history")
    public void theUserScrollsToViewHistory() {
        calculatorPage.scrollToHistory();
    }

    @Then("the history is visible")
    public void theHistoryIsVisible() {
        calculatorPage.verifyHistory();
    }
}
