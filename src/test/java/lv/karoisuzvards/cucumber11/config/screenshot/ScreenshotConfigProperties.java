package lv.karoisuzvards.cucumber11.config.screenshot;

import lv.karoisuzvards.cucumber11.utils.ScreenshotCapturer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ScreenshotConfigProperties implements ScreenshotConfig {

    @Value("${screenshot.capturer:SELENIUM}")
    private ScreenshotCapturer.Type type;

    @Override
    public ScreenshotCapturer.Type getScreenshotCapturer() {
        return type;
    }
}
