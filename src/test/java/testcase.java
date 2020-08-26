import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import org.openqa.selenium.OutputType;

//import com.automation_desktop.core.driver.mobile.DriverBase;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import io.visual_regression_tracker.sdk_java.TestRunOptions;
import io.visual_regression_tracker.sdk_java.VisualRegressionTracker;
import io.visual_regression_tracker.sdk_java.VisualRegressionTrackerConfig;


import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;

public class testcase {

	private static AppiumDriverLocalService service;
	private AppiumDriver driver;

	@Test
	public void test() {
	    try {
				VisualRegressionTracker visualRegressionTracker;
			    VisualRegressionTrackerConfig config = new VisualRegressionTrackerConfig(
			            "http://localhost:4200", // replace with your data
			            "google", // replace with your data
			            "1KJEGTPQJRM603PV9ZF3J7W7PA5H", // replace with your data
			            "google" // replace with your data
			    );
  	   visualRegressionTracker = new VisualRegressionTracker(config);   
 	   visualRegressionTracker.start();
		int devicePort = 7100 + (int) (Math.random() * ((8100 - 7100) + 1));
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("platformName", "iOS");         
		caps.setCapability("deviceName", "iPhone");
		caps.setCapability("udid", "190806514fcac51c7d11b229a3610dca2220ab54");
		caps.setCapability("fullReset", false);
		caps.setCapability("noReset", true);
		caps.setCapability("bundleId", "com.bundleId");
		caps.setCapability("automationName", "XCUITest");
		caps.setCapability("useJSONSource", true);
		caps.setCapability("agentPath", "/usr/local/lib/node_modules/appium/node_modules/appium-webdriveragent/WebDriverAgent.xcodeproj");
		caps.setCapability("xcodeConfigFile", "/usr/local/lib/node_modules/appium/node_modules/appium-webdriveragent/Configurations/Config.xcconfig");
		caps.setCapability(IOSMobileCapabilityType.SHOW_XCODE_LOG, false);
		caps.setCapability("wdaLocalPort", devicePort);
		caps.setCapability("newCommandTimeout", 60000);
		caps.setCapability("simpleIsVisibleCheck", true);
		caps.setCapability("platformVersion", "11.0");
		caps.setCapability("Connect Hardware Keyboard", true);
		caps.setCapability(IOSMobileCapabilityType.SHOW_XCODE_LOG, false);
		AppiumServiceBuilder builder = new AppiumServiceBuilder();
		builder.withIPAddress("127.0.0.1");
		caps.setCapability(IOSMobileCapabilityType.SHOW_XCODE_LOG, false);
		builder.usingAnyFreePort();
		builder.withCapabilities(caps);
		builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
		builder.withArgument(GeneralServerFlag.LOG_LEVEL, "error");
		service = builder.build();
		service.start();
		testcase.service = service;
		driver = new IOSDriver(service.getUrl(), caps);
		visualRegressionTracker.track(
        "Home page",
        ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64)
);

	     visualRegressionTracker.stop();
	        
	        
}catch (Exception e) {

}
		  }
	
}
