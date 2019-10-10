package lv.karoisuzvards.cucumber11.stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import lv.karoisuzvards.cucumber11.config.site.SiteConfig;
import lv.karoisuzvards.cucumber11.pageobject.LandingPage;
import org.springframework.beans.factory.annotation.Autowired;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class NavigationStepsDefs {

    private final SiteConfig siteConfig;
    private final LandingPage landingPage;

    @Autowired
    public NavigationStepsDefs(SiteConfig siteConfig,
                               LandingPage landingPage) {
        this.siteConfig = siteConfig;
        this.landingPage = landingPage;
    }

    @Given("site is open")
    public void siteIsOpen() {
        open(siteConfig.getSiteUrl());
        var window = getWebDriver().manage()
                .window();

        window.maximize();
        window.fullscreen();
    }

    @And("housing is open")
    public void housingIsOpen() {
        landingPage.openHousingSection();
    }
}
