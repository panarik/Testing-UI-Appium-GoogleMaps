package test;

import org.testng.annotations.Test;
import test.base.BaseTestClass;

public class TestOne extends BaseTestClass {

    @Test
    public void SearchSomePlace() {
        map.goToSearch();
        search.search("Text");
    }

}
