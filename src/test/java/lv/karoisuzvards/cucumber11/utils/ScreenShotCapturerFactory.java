package lv.karoisuzvards.cucumber11.utils;

import org.springframework.stereotype.Component;

@Component
public class ScreenShotCapturerFactory {

    public ScreenshotCapturer getByType(ScreenshotCapturer.Type type) {
        switch (type) {
            case ASHOT:
                return new AshotScreenshotCapturer();
            case SELENIUM:
                return new SeleniumScreenshotCapturer();
            default:
                throw new IllegalStateException("Unknown screen capture type : " + type);
        }
    }
}
