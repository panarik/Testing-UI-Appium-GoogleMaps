package controller;

import model.base.MobileItem;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.html5.Location;
import org.testng.Assert;

import static controller.AppiumInstance.driver;

/**
 * Controller class contains all methods with Android driver. Screens use Controller methods.
 */
public class Controller {

    public static final Logger log = LogManager.getLogger(); // logger

    /**
     * Set GEO.
     *
     * @param latitude
     * @param longitude
     */
    protected void setGeo(double latitude, double longitude) {
        driver.setLocation(new Location(latitude, longitude, 10));
    }

    /**
     * Click on {@link MobileItem}
     *
     * @param mobileItem
     */
    protected void click(MobileItem mobileItem) {
        try {
            driver.findElement(mobileItem.getLocatorType(), mobileItem.getLocatorBody()).click();
        } catch (NoSuchElementException e) {
            Assert.fail("Can't click on item '" + mobileItem.getName() + "' with locator '" + mobileItem.getLocatorBody() + "'.");
        }
    }

    /**
     * Enter text into {@link MobileItem}
     *
     * @param mobileItem
     * @param text
     */
    protected void enterText(MobileItem mobileItem, String text) {
        try {
            driver.findElement(mobileItem.getLocatorType(), mobileItem.getLocatorBody()).sendKeys(text);
        } catch (NoSuchElementException e) {
            Assert.fail("Can't enter text on view '" + mobileItem.getName() + "'.");
        }
    }

    /**
     * Allow permission on system window tish GEO permissions.
     */
    protected void getPermissionsGEO() {
        try {
            driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button")).click();
            //ToDo: for different devices needs different locators.
        } catch (NoSuchElementException e) {
            Assert.fail("'permissioncontroller allow' button not found.");
        }
    }

    /**
     * Verify {@link MobileItem} present on screen.
     *
     * @param item
     */
    protected void verifyItem(MobileItem item) {
        try {
            driver.findElement(item.getLocatorType(), item.getLocatorBody());
        } catch (NoSuchElementException e) {
            Assert.fail("Can't find item '" + item.getName() + "' with locator '" + item.getLocatorBody() + "'.");
        }
    }

}
