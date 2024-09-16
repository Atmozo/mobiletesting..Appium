package Pages;

import Utils.AndroidUtils;
import Utils.AppiumDriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import java.time.Duration;

public class CalculatorPage {

    AppiumDriver driver;
    AppiumDriverFactory appiumDriverFactory = AppiumDriverFactory.getInstanceOfAppiumFactory();
    AndroidUtils androidUtils;

    // Declare all necessary buttons
    private static By clearButton = By.xpath("//android.widget.ImageButton[@content-desc=\"clear\"]");
    private static By buttonOne = By.xpath("//android.widget.ImageButton[@content-desc=\"1\"]");
    private static By buttonTwo = By.xpath("//android.widget.ImageButton[@content-desc=\"2\"]");
    private static By buttonThree = By.xpath("//android.widget.ImageButton[@content-desc=\"3\"]");
    private static By buttonSix = By.xpath("//android.widget.ImageButton[@content-desc=\"6\"]");
    private static By buttonEight = By.xpath("//android.widget.ImageButton[@content-desc=\"8\"]");

    private static By additionButton = By.xpath("//android.widget.ImageButton[@content-desc='plus']");
    private static By subtractionButton = By.xpath("//android.widget.ImageButton[@content-desc='minus']");
    private static By multiplicationButton = By.xpath("//android.widget.ImageButton[@content-desc='multiply']");
    private static By divisionButton = By.xpath("//android.widget.ImageButton[@content-desc='divide']");
    private static By equalButton = By.xpath("//android.widget.ImageButton[@content-desc=\"equals\"]");

    private static By answerField = By.xpath("//android.widget.TextView[@resource-id=\"com.google.android.calculator:id/result_final\"]");
    private static By historyField = By.xpath("//android.support.v7.widget.RecyclerView[@resource-id=\"com.google.android.calculator:id/history_recycler_view\"]");
    private static By dragHandleButton = By.xpath("//android.widget.ImageView[@resource-id=\"com.google.android.calculator:id/drag_handle_view\"]");
    public CalculatorPage() {
        driver = appiumDriverFactory.getDriver();
        androidUtils = new AndroidUtils(driver);
        PageFactory.initElements(driver, this);
    }

    public void verifyAppLaunched() {
        if (androidUtils.objectExist(clearButton)) {
            Assert.assertTrue(true, "The app was launched successfully");
        } else {
            Assert.fail("The app was not launched successfully");
        }
    }

    public void clickButton(String number) {
        switch (number) {
            case "1":
                androidUtils.clickButton(buttonOne);
                break;
            case "2":
                androidUtils.clickButton(buttonTwo);
                break;
            case "3":
                androidUtils.clickButton(buttonThree);
                break;
            case "6":
                androidUtils.clickButton(buttonSix);
                break;
            case "8":
                androidUtils.clickButton(buttonEight);
                break;
        }
    }

    public void clickOperation(String operation) {
        switch (operation) {
            case "plus":
                androidUtils.clickButton(additionButton);
                break;
            case "minus":
                androidUtils.clickButton(subtractionButton);
                break;
            case "multiply":
                androidUtils.clickButton(multiplicationButton);
                break;
            case "divide":
                androidUtils.clickButton(divisionButton);
                break;
        }
    }

    public void clickEqualButton() {
        androidUtils.clickButton(equalButton);
    }

    public void verifyCorrectAnswerDisplayed(String number) {
        androidUtils.verifyAnswers(answerField, number);
    }
    public void scrollToHistory() {
        // Cast driver to AndroidDriver to use TouchAction class
        TouchAction touchAction = new TouchAction((PerformsTouchActions) driver);

        // Get the location of the element you want to drag
        WebElement dragElement = driver.findElement(dragHandleButton);
        Point location = dragElement.getLocation();

        // Perform the drag down action (adjust the move coordinates as necessary)
        touchAction.press(PointOption.point(location))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(location.getX(), location.getY() + 500)) // Adjust the Y-axis value to drag down
                .release()
                .perform();
    }

    public void verifyHistory() {
        if (androidUtils.objectExist(historyField)) {
            Assert.assertTrue(true, "History is visible after scrolling");
        } else {
            Assert.fail("History is not visible after scrolling");
        }
    }


}
