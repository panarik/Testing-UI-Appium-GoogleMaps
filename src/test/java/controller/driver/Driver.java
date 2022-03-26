package controller.driver;

import io.appium.java_client.AppiumDriver;

public class Driver<T extends AppiumDriver> {
    public T driver;

    public Driver(T typeDriver) {
        this.driver = typeDriver;
    }

}
