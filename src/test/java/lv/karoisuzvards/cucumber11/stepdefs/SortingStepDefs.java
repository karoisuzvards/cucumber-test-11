package lv.karoisuzvards.cucumber11.stepdefs;

import io.cucumber.java.en.When;
import lv.karoisuzvards.cucumber11.model.SortingType;
import lv.karoisuzvards.cucumber11.pageobject.HousingPage;

public class SortingStepDefs {

    private final HousingPage housingPage;

    public SortingStepDefs(HousingPage housingPage) {
        this.housingPage = housingPage;
    }

    @When("sorting is done by lowest price")
    public void sortingIsDoneByLowestPrice() {
        housingPage.sortBy(SortingType.PRICE_ASC);
    }
}
