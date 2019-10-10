package lv.karoisuzvards.cucumber11.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/**
 * Use Selenium itself to capture screenshots of browser
 * Problem is with full page screenshot -
 */
public class SeleniumScreenshotCapturer implements ScreenshotCapturer {
    @Override
    public byte[] capture(WebDriver webDriver) {
        if(webDriver instanceof TakesScreenshot){
            TakesScreenshot d = (TakesScreenshot) webDriver;
            return d.getScreenshotAs(OutputType.BYTES);
        }

        throw new IllegalStateException("Unable to take screenshot using Selenium!");
    }
}
