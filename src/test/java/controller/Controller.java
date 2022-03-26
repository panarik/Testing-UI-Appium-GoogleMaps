package controller;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import model.base.MobileItem;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.html5.Location;
import org.testng.Assert;

import static controller.AppiumInstance.driver;

public class Controller {

    public void setGeo(double lat, double longitude) {
        driver.setLocation(new Location(lat, longitude, 10));
    }

    public MobileElement getElement(MobileItem mobileItem) {
        return driver.findElement(By.xpath(mobileItem.getLocatorBody()));
    }

    protected void click(MobileItem mobileItem) {
        try {
            driver.findElement(mobileItem.getLocatorType(), mobileItem.getLocatorBody()).click();
        } catch (NoSuchElementException e) {
            failAfterWaiting(mobileItem);
        }
    }

    protected void enterText(MobileItem mobileItem, String text) {
        try {
            driver.findElement(mobileItem.getLocatorType(), mobileItem.getLocatorBody()).sendKeys(text);
        } catch (NoSuchElementException e) {
            failAfterWaiting(mobileItem);
        }
    }

    protected void waitElement(MobileItem item) {
        try {
            driver.findElement(item.getLocatorType(), item.getLocatorBody());
        } catch (NoSuchElementException e) {
            failAfterWaiting(item);
        }
    }

    protected void failAfterWaiting(MobileItem mobileitem) {
        Assert.fail("Element " + mobileitem.getName() + " not found.");
    }

    protected void getPermissionsGEO() {
        try {
            driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button")).click();
        } catch (NoSuchElementException e) {
            Assert.fail("'PermissionAllow' button not found.");
            e.printStackTrace();
        }
    }

}
