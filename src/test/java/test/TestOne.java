package test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.base.BaseTestClass;

public class TestOne extends BaseTestClass {

    @BeforeClass
    public void setGeoToLondon() {
        map.setLondon();
    }

    @Test
    public void SearchSomePlace() {
        map.goToSearch();
        search
                .search("Garden Museum")
                .pikFirstSuggestion();
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
