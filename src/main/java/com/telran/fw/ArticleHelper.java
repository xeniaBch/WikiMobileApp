package com.telran.fw;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ArticleHelper extends HelperBase{
    public ArticleHelper(AppiumDriver driver) {
        super(driver);
    }

    public void addToFavourites(int time) {
        waitForElementAndTap(By.xpath("//android.widget.ImageView[@content-desc='Add this article to a reading list']"), time);
    }

    public void createReadingList(int time, String text, int index) {
        tap(By.id("onboarding_button"));
        waitForElementAndType(By.id("text_input"), time, text);
        List<WebElement> buttons = driver.findElements(By.className("android.widget.Button"));
        buttons.get(index).click();

    }

    public void close(int millis) throws InterruptedException {
        tap(By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"));
        pause(millis);
    }

    public void selectFavourites(int time) {
        tap(By.xpath("//android.widget.FrameLayout[@content-desc='My lists']/android.widget.ImageView"));
        waitForElementAndTap(By.id("item_title"), time);
    }

    public void removeArticleFromFavourites() {
        swipeRigthToLeft(By.id("page_list_item-container"));
    }
}
