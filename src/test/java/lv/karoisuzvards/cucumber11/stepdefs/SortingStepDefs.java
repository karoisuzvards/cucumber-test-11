package lv.karoisuzvards.cucumber11.stepdefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lv.karoisuzvards.cucumber11.model.SortingType;
import lv.karoisuzvards.cucumber11.pageobject.HousingPage;

import static lv.karoisuzvards.cucumber11.model.SortingType.PRICE_ASC;

public class SortingStepDefs {

    private final HousingPage housingPage;

    public SortingStepDefs(HousingPage housingPage) {
        this.housingPage = housingPage;
    }

    @When("sorting is done by lowest price")
    public void sortingIsDoneByLowestPrice() {
        housingPage.sortBy(PRICE_ASC);
    }

    @Then("all items are sorted by lowest price")
    public void allItemsAreSortedByLowestPrice() {
        housingPage.allItemsSortedBy(PRICE_ASC);
    }
}
