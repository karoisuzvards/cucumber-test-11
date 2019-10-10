package lv.karoisuzvards.cucumber11.stepdefs.hooks;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import lv.karoisuzvards.cucumber11.config.screenshot.ScreenshotConfig;
import lv.karoisuzvards.cucumber11.utils.ScreenShotCapturerFactory;
import lv.karoisuzvards.cucumber11.utils.ScreenshotCapturer;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


public class ScenarioHooks {

    private static final String IMAGE_PNG = "image/png";

    private ScreenShotCapturerFactory screenShotCapturerFactory;
    private ScreenshotConfig screenshotConfig;

    public ScenarioHooks(ScreenShotCapturerFactory screenShotCapturerFactory,
                         ScreenshotConfig screenshotConfig) {
        this.screenShotCapturerFactory = screenShotCapturerFactory;
        this.screenshotConfig = screenshotConfig;
    }

    @After
    public void afterScenario(Scenario scenario) throws Exception {
        var webDriver = getWebDriver();
        ScreenshotCapturer capturer = screenShotCapturerFactory.getByType(screenshotConfig.getScreenshotCapturer());
        var capture = capturer.capture(webDriver);
        scenario.embed(capture, IMAGE_PNG);
    }
}
