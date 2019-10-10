package lv.karoisuzvards.cucumber11.config;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverConfig {

    //during class load setup Webdriver configuration
    static {
        //TODO: support multiple browsers here
        WebDriverManager.chromedriver()
                .setup();
    }
}
