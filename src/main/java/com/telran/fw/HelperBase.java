package com.telran.fw;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.lang.Thread.sleep;

public class HelperBase {
    AppiumDriver driver;

    public HelperBase(AppiumDriver driver) {
        this.driver = driver;
    }

    public WebElement findElement(By by) {
        return driver.findElement(by);
    }

    public void tap(By by) {
        findElement(by).click();
    }

    public void waitForElementAndTap(By by, int time) {
        new WebDriverWait(driver, time).until(ExpectedConditions.presenceOfElementLocated(by)).click();
    }

    public void waitForElementAndType(By by, int time, String text) {
        if(text != null) {
            waitForElementAndTap(by, time);
            findElement(by).clear();
            findElement(by).sendKeys(text);

        }
    }

    public String getText(By by) {
        return findElement(by).getText();
    }

    public void pause(int millis) throws InterruptedException {
        sleep(millis);
    }

    public void type(By by, String text) {
        if(text != null) {
            if(!text.equals(getText(by))){
                tap(by);
                findElement(by).clear();
                findElement(by).sendKeys(text);
            }
        }
    }

    public boolean isElementPresent(By by){
        return driver.findElements(by).size() > 0;
    }

    public void swipeRigthToLeft(By by) {
        TouchAction action = new TouchAction(driver);
        Dimension size = driver.manage().window().getSize();
        WebElement element = findElement(by);
        int leftX = (int) (element.getLocation().getX()*0.3);
        int rightX = (int) (leftX + element.getLocation().getX()*0.8);
        int upperY = element.getLocation().getY();
        int lowerY = upperY + element.getSize().getHeight();
        int middleY = (upperY + lowerY)/2;
        action.longPress(PointOption.point(rightX,middleY))
                .moveTo(PointOption.point(leftX, middleY))
                .release()
                .perform();
    }
}
