package lv.karoisuzvards.cucumber11.pageobject;


import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Selenide.$;

@Component
public class LandingPage {

    private By housingLink = By.id("hhh");

    public void openHousingSection(){
        $(housingLink).click();
    }
}
