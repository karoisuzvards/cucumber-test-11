package lv.karoisuzvards.cucumber11.pageobject;

import com.codeborne.selenide.SelenideElement;
import com.google.common.collect.Comparators;
import lv.karoisuzvards.cucumber11.model.SortingType;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.assertj.core.api.Assertions.assertThat;

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

    public void allItemsSortedBy(SortingType type) {
        List<Integer> actualPrices = $$("#sortable-results > ul > li").stream()
                .filter(HousingPage::ignoreNonEuroCurrency)
                .map(HousingPage::extractPriceWithoutCurrency)
                .collect(Collectors.toList());

        List<Integer> expected = new ArrayList<>(actualPrices);
        Collections.sort(expected);

        assertThat(actualPrices).containsExactly(expected.toArray(new Integer[0]));
    }

    private static boolean ignoreNonEuroCurrency(SelenideElement selenideElement) {
        return selenideElement.getText().contains("€");
    }

    private static Integer extractPriceWithoutCurrency(SelenideElement l) {
        return Integer.valueOf(
                l.find(".result-price").getText()
                .replace("€", ""));
    }
}
