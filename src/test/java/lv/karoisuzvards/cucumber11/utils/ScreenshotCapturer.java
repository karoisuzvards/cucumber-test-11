package lv.karoisuzvards.cucumber11.utils;

import io.cucumber.core.api.Scenario;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public interface ScreenshotCapturer {

    enum Type {
        ASHOT,
        SELENIUM
    }

    byte[] capture(WebDriver webDriver) throws IOException;
}
