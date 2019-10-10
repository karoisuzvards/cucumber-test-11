package lv.karoisuzvards.cucumber11.pageobject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static lv.karoisuzvards.cucumber11.pageobject.HousingPage.SortingType.*;
import static org.assertj.core.api.Assertions.assertThat;

@Component
public class HousingPage {

    private final WebElement sortingDropdown = $("#searchform > div:nth-child(3) > div.search-sort > div > ul");

    private final Map<SortingType, String> sortings = Map.of(
            NEWEST, "newest",
            PRICE_ASC,  "price ↑",
            PRICE_DESC, "price ↓",
            UPCOMING, "upcoming",
            RELEVANT, "relevant"
    );

    private final WebElement queryInput = $("#query");
    private final WebElement searchButton = $("#searchform > div.querybox > button");

    private WebElement getSortingElementBasedOnType(SortingType sortingType){
         var optionName = Optional.ofNullable(sortings.get(sortingType))
                .orElseThrow();
         return sortingDropdown.findElement(withText(optionName));
    }

    public void sortBy(SortingType sortType) {
        //first open sorting dropdown and then select the wanted sorting type
        sortingDropdown.click();
        getSortingElementBasedOnType(sortType).click();
    }

    public void allItemsSortedBy(SortingType type) {
        List<Integer> actualPrices = $$("#sortable-results > ul > li").stream()
                .filter(HousingPage::ignoreNonEuroCurrency)
                .map(HousingPage::extractPriceWithoutCurrency)
                .collect(Collectors.toList());

        List<Integer> expected = new ArrayList<>(actualPrices);
        sortExpectedByType(expected, type);

        assertThat(actualPrices).containsExactly(expected.toArray(new Integer[0]));
    }

    private void sortExpectedByType(List<Integer> expected, SortingType type) {
        switch (type) {
            case PRICE_ASC:
                expected.sort(Comparator.naturalOrder());
                break;
            case PRICE_DESC:
                expected.sort(Comparator.reverseOrder());
                break;
            default:
                throw new IllegalStateException("Don't know how to sort for type : " + type);
        }
    }


    private static boolean ignoreNonEuroCurrency(SelenideElement selenideElement) {
        return selenideElement.getText().contains("€"); //lets handle euro only for now
    }

    private static Integer extractPriceWithoutCurrency(SelenideElement l) {
        return Integer.valueOf(
                l.find(".result-price").getText()
                        .replace("€", ""));
    }

    public void sortingPossibilitiesAreAvailable(List<SortingType> expectedTypes) {
        for (SortingType t : expectedTypes) {
            $(getSortingElementBasedOnType(t)).shouldBe(exist);
        }
    }

    public void search(String keyword) {
        $(queryInput).setValue(keyword);
        $(searchButton).click();
    }

    public enum SortingType {
        NEWEST,
        PRICE_ASC,
        PRICE_DESC,
        UPCOMING,
        RELEVANT
    }
}
