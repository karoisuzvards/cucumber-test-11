package lv.karoisuzvards.cucumber11.utils;


import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Use Ashot library to capture screenshot - https://github.com/pazone/ashot
 * Provides a way but still poor one how to capture a complete web page
 * (scrolling and taking screenshots
 */
public class AshotScreenshotCapturer implements ScreenshotCapturer {
    @Override
    public byte[] capture(WebDriver webDriver) throws IOException {
        BufferedImage image = new AShot()
                .shootingStrategy(ShootingStrategies.viewportPasting(1000))
                .takeScreenshot(webDriver)
                .getImage();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        ImageIO.write(image, "png", baos);
        baos.flush();
        return baos.toByteArray();
    }
}
