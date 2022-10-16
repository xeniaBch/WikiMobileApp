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

    public void hideKeyboard(){
        driver.hideKeyboard();
    }

    public void swipeUp() {
        TouchAction action = new TouchAction(driver);
        Dimension size = driver.manage().window().getSize();
        int x = size.width / 2;
        int startY = (int) (size.height*0.8);
        int stopY = (int) (size.height*0.3);
        action.longPress(PointOption.point(x,startY))
                .moveTo(PointOption.point(x, stopY))
                .release()
                .perform();
    }

    public void swipeDown() {
        TouchAction action = new TouchAction(driver);
        Dimension size = driver.manage().window().getSize();
        int x = size.width / 2;
        int startY = (int) (size.height*0.7);
        int stopY = (int) (size.height*0.4);
        action.longPress(PointOption.point(x,startY))
                .moveTo(PointOption.point(x, stopY))
                .release()
                .perform();
    }

    public void moveFrom(By by, double from, double to){
        TouchAction action = new TouchAction(driver);
        Dimension size = driver.manage().window().getSize();
        int upPoint = (int) (size.height*from);
        int downPoint = (int) (size.height*to);
        WebElement element = driver.findElement(by);
        int leftX = element.getLocation().getX();
        int rightX = leftX + element.getSize().getWidth();
        int middleX = (leftX + rightX)/2;
        action.longPress(PointOption.point(middleX,upPoint))
                .moveTo(PointOption.point(middleX, downPoint))
                .release()
                .perform();
    }

    public void pressOnTimer(int x, int y) {
        TouchAction action = new TouchAction(driver);
        Dimension size = driver.manage().window().getSize();
        action.tap(PointOption.point(x, y)).release().perform();
    }


}
