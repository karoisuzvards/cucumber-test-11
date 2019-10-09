package lv.karoisuzvards.cucumber11.config;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverConfig {

    //during class load setup Webdriver configuration
    static {
        WebDriverManager.chromedriver()
                .setup();
    }
}
