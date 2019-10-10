package lv.karoisuzvards.cucumber11.utils;

import org.openqa.selenium.WebDriver;

import java.io.IOException;

/**
 * Allows to capture screenshot of browser
 */
public interface ScreenshotCapturer {

    enum Type {
        ASHOT,
        SELENIUM
    }

    byte[] capture(WebDriver webDriver) throws IOException;
}
