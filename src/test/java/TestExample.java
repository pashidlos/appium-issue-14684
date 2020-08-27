import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.hamcrest.core.StringContains;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestExample {

    private static AppiumDriverLocalService service;
    private IOSDriver<WebElement> driver;

    @BeforeSuite
    public void setUp() throws IOException {
        service = AppiumDriverLocalService.buildDefaultService();
        service.start();

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "iOS");
        caps.setCapability("deviceName", "iPhone 8");
        caps.setCapability("platformVersion", "13.6");
        caps.setCapability("browserName", "Safari");
        caps.setCapability("automationName", "XCUITest");
        driver = new IOSDriver<WebElement>(service.getUrl(), caps);
    }

    @AfterSuite
    public void globalTearDown() throws IOException {
        driver.quit();
        service.stop();
    }

    @Test
    public void test() throws IOException {
        // Navigate to google.com
        driver.get("https://www.google.com");

        String image = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);

        MatcherAssert.assertThat(image, CoreMatchers.not(StringContains.containsString("\n")));
    }
}
