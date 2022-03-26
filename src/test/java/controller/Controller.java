package controller;

import io.appium.java_client.MobileElement;
import model.base.MobileItem;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;

import static controller.AppiumInstance.driver;

public class Controller {

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
            Assert.fail("Element " + item.getName() + " not found.");
        }
    }

    protected void failAfterWaiting(MobileItem mobileitem) {
        Assert.fail("Element " + mobileitem.getName() + " not found.");
    }

}
