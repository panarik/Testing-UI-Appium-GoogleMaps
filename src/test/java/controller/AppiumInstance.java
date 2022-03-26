package controller;

import controller.driver.Driver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import model.base.Configs;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppiumInstance {

    static ThreadLocal<Driver> controller = new ThreadLocal<>(); // Common driver.

    public void setup(String OS) {
        switch (OS) {
            case ("ANDROID"): {
                DesiredCapabilities cap = new DesiredCapabilities();
                cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
                cap.setCapability(MobileCapabilityType.VERSION, "10");
                cap.setCapability("deviceName", "Redmi Note 9 Pro");
                cap.setCapability(MobileCapabilityType.UDID, "83209d47");
                cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
                cap.setCapability("appPackage", "com.google.android.apps.maps");
                cap.setCapability("appActivity", "com.google.android.maps.MapsActivity");
                try {
                    URL url = new URL("http://127.0.0.1:4723/wd/hub");
                    controller.set(new Driver(new AndroidDriver<MobileElement>(url, cap)));
                } catch (
                        MalformedURLException e) {
                    e.printStackTrace();
                }
                controller.get().driver.manage().timeouts().implicitlyWait(Configs.GLOBAL_WAITING, TimeUnit.SECONDS);

            }

            case ("IOS"): {
                //ToDo: Setup iOS.
            }
        }
    }

    public void stop() {
        if (controller.get().driver != null) {
            controller.get().driver.quit();
            System.out.println("Driver has shutdown.");
        }
    }

}
