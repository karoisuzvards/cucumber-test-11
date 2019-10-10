package lv.karoisuzvards.cucumber11.config.screenshot;

import lv.karoisuzvards.cucumber11.utils.ScreenshotCapturer;

/**
 * Configuration class to allow configuration of screenshot taking mechanism
 */
public interface ScreenshotConfig {

    ScreenshotCapturer.Type getScreenshotCapturer();
}
