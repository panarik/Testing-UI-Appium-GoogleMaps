package test.base;

import controller.AppiumInstance;
import model.screen.Map;
import model.screen.Search;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static controller.Controller.log;

/**
 * Base test class with methods that starts and ends test.
 */
public class BaseTestClass {

    private AppiumInstance instance;

    //Setup pages
    protected Map map = new Map();
    protected Search search = new Search();

    @BeforeTest
    public void start() {
        String osName = "ANDROID";
        log.info(osName + " driver: setup.");
        instance = new AppiumInstance();
        instance.setup(osName);
        log.info(osName + " driver: ready.");
    }

    @AfterTest
    public void shutdown() {
        instance.stop();
        log.info("Driver has shutdown.");
    }

}
