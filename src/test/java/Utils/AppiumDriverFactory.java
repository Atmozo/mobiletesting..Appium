package Utils;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppiumDriverFactory {
    public static AppiumDriver driver;

    public static AppiumDriverFactory instanceOfAppiumFactory;

    public AppiumDriverFactory() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appium:automationName", "UiAutomator2");
        capabilities.setCapability("appium:app", System.getProperty("user.dir") + "/src/main/Apps/Calculator.apk");
//        capabilities.setCapability("UDID", "emulator-5554");

        try {
            driver = new AppiumDriver(new URL("http://127.0.0.1:4723/"), capabilities);
//            driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);


        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    public static AppiumDriverFactory getInstanceOfAppiumFactory() {
        if (instanceOfAppiumFactory == null)
            instanceOfAppiumFactory = new AppiumDriverFactory();
        return instanceOfAppiumFactory;

    }

    public AppiumDriver getDriver(){
        return driver;
    }


}
