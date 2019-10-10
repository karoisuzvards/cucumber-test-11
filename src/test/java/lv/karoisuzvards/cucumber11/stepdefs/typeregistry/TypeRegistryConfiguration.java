package lv.karoisuzvards.cucumber11.stepdefs.typeregistry;

import io.cucumber.core.api.TypeRegistry;
import io.cucumber.core.api.TypeRegistryConfigurer;
import io.cucumber.datatable.DataTableType;
import io.cucumber.datatable.TableCellTransformer;
import lv.karoisuzvards.cucumber11.pageobject.HousingPage;

import java.util.Locale;

import static java.util.Locale.ENGLISH;

public class TypeRegistryConfiguration implements TypeRegistryConfigurer {

    @Override
    public Locale locale() {
        return ENGLISH;
    }

    @Override
    public void configureTypeRegistry(TypeRegistry typeRegistry) {
        typeRegistry.defineDataTableType(sortingTypeDataTable());
    }

    private DataTableType sortingTypeDataTable() {
        return new DataTableType(
                HousingPage.SortingType.class,
                (TableCellTransformer<HousingPage.SortingType>) HousingPage.SortingType::valueOf);
    }
}
