package lv.karoisuzvards.cucumber11.pageobject;

import lv.karoisuzvards.cucumber11.model.SortingType;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Selenide.$;

@Component
public class HousingPage {

    private By sortingDropdown = By.cssSelector("#searchform > div:nth-child(3) > div.search-sort > div > ul");
    private By sortingNewestSelect = By.cssSelector("#searchform > div:nth-child(3) > div.search-sort > div > ul > li.dropdown-item.mode.sel > a");
    private By sortingByPriceAsc = By.cssSelector("#searchform > div:nth-child(3) > div.search-sort > div > ul > li:nth-child(3) > a");
    private By sortingByPriceDesc = By.cssSelector("#searchform > div:nth-child(3) > div.search-sort > div > ul > li.dropdown-item.mode.sel > a");

    public void sortBy(SortingType sortType) {
        //first open sorting dropdown and then select the wanted sorting type
        $(sortingDropdown).click();
        switch (sortType) {
            case NEWEST:
                $(sortingNewestSelect).click();
                break;
            case PRICE_ASC:
                $(sortingByPriceAsc).click();
                break;
            case PRICE_DESC:
                $(sortingByPriceDesc).click();
                break;
            default:
                throw new IllegalStateException("Unknown sort type : " + sortType);
        }
    }
}
