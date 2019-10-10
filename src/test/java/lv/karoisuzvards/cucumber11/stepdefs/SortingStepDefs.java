package lv.karoisuzvards.cucumber11.stepdefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lv.karoisuzvards.cucumber11.pageobject.HousingPage;

import java.util.List;

import static lv.karoisuzvards.cucumber11.pageobject.HousingPage.SortingType.PRICE_ASC;
import static lv.karoisuzvards.cucumber11.pageobject.HousingPage.SortingType.PRICE_DESC;


public class SortingStepDefs {

    private final HousingPage housingPage;

    public SortingStepDefs(HousingPage housingPage) {
        this.housingPage = housingPage;
    }

    @Then("all items are sorted by lowest price first")
    public void allItemsAreSortedByLowestPrice() {
        housingPage.allItemsSortedBy(PRICE_ASC);
    }

    @When("sorting is done by price ascending")
    public void sortingIsDoneByPriceAscending() {
        housingPage.sortBy(PRICE_ASC);
    }

    @When("sorting is done by price descending")
    public void sortingIsDoneByPriceDescending() {
        housingPage.sortBy(PRICE_DESC);
    }

    @Then("all items are sorted by highest price first")
    public void allItemsAreSortedByHighestPriceFirst() {
        housingPage.allItemsSortedBy(PRICE_DESC);
    }

    @Then("following sorting possibilities are available")
    public void followingSortingPossibilitiesAreAvailable(List<HousingPage.SortingType> types) {
        housingPage.sortingPossibilitiesAreAvailable(types);
    }

    @When("search is used with valid keyword")
    public void searchIsUsedWithValidKeyword() {
        housingPage.search("luxury");
    }
}
