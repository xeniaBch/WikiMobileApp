package com.telran.fw;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MainScreenHelper extends HelperBase{
    public MainScreenHelper(AppiumDriver driver) {
        super(driver);
    }

    public void searchArticle(int index, int millis) throws InterruptedException {
       tap(By.id("fragment_feed_header"));
       type(By.id("search_src_text"), "TCP/IP");
        List<WebElement> articles = driver.findElements(By.id("view_list_card_header"));
        articles.get(index).click();
        pause(millis);
    }
}
