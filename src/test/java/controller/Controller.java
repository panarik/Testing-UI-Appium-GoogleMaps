package controller;

import model.base.MobileItem;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.html5.Location;
import org.testng.Assert;

import static controller.AppiumInstance.driver;

public class Controller {

    protected void setGeo(double latitude, double longitude) {
        driver.setLocation(new Location(latitude, longitude, 10));
    }

    protected void click(MobileItem mobileItem) {
        try {
            driver.findElement(mobileItem.getLocatorType(), mobileItem.getLocatorBody()).click();
        } catch (NoSuchElementException e) {
            Assert.fail("Can't click on item '" + mobileItem.getName() + "' with locator '" + mobileItem.getLocatorBody() + "'.");

        }
    }

    protected void enterText(MobileItem mobileItem, String text) {
        try {
            driver.findElement(mobileItem.getLocatorType(), mobileItem.getLocatorBody()).sendKeys(text);
        } catch (NoSuchElementException e) {
            Assert.fail("Can't enter text on view '" + mobileItem.getName() + "'.");
        }
    }

    protected void getPermissionsGEO() {
        try {
            driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button")).click();
        } catch (NoSuchElementException e) {
            Assert.fail("'PermissionAllow' button not found.");
        }
    }

    protected void verifyItem(MobileItem item) {
        try {
            driver.findElement(item.getLocatorType(), item.getLocatorBody());
        } catch (NoSuchElementException e) {
            Assert.fail("Can't find item '" + item.getName() + "' with locator '" + item.getLocatorBody() + "'.");
        }
    }

}
