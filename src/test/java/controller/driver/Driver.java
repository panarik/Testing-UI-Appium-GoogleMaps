package controller.driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class Driver<T extends AppiumDriver<MobileElement>> {
    public T driver;

    public Driver(T typeDriver) {
        this.driver = typeDriver;
    }

}
