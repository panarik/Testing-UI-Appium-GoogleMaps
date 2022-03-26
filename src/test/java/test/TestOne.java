package test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.base.BaseTestClass;

public class TestOne extends BaseTestClass {

    @BeforeClass
    public void setGeoToLondon() {

        //Pre Step: set location.
        map.setLondon();
    }

    @Test
    public void SearchSomePlace() {
        // Step 1: Go to search page.
        map.goToSearch();

        // Step 2: Search "Garden Museum".
        search
                .search("Garden Museum")
                .pickFirstSuggestion();

        //Step 3: Check "Garden Museum" from the list of suggestions on the map.
        map.verifySuggestion("Garden Museum");
    }

}
