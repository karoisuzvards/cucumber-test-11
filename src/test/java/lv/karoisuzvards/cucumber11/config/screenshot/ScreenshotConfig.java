package lv.karoisuzvards.cucumber11.config.screenshot;

import lv.karoisuzvards.cucumber11.utils.ScreenshotCapturer;

public interface ScreenshotConfig {

    ScreenshotCapturer.Type getScreenshotCapturer();
}
