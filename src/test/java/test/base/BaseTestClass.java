package test.base;

import controller.AppiumInstance;
import model.screen.Map;
import model.screen.Search;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class BaseTestClass {

    private AppiumInstance instance;

    //Setup pages
    // Add only common pages. If page is a part of scenario do not create it.
    protected Map map = new Map();
    protected Search search = new Search();

    @BeforeTest
    public void start() {
        String osName = "ANDROID";
        System.out.println(osName + " driver: setup");
        instance = new AppiumInstance();
        instance.setup(osName);
        System.out.println(osName + " driver: ready");
    }

    @AfterTest
    public void shutdown() {
        instance.stop();
    }

}
