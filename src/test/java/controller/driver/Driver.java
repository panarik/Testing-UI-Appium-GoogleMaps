package controller.driver;

import io.appium.java_client.AppiumDriver;

/**
 * This is optional feature. Driver can be universal with android and iOS.
 * @param <T> {@link io.appium.java_client.android.AndroidDriver} or {@link io.appium.java_client.ios.IOSDriver}
 */
public class Driver<T extends AppiumDriver> {
    public T driver;

    public Driver(T typeDriver) {
        this.driver = typeDriver;
    }

}
