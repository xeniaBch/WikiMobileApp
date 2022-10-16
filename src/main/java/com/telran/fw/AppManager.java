package com.telran.fw;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import static java.lang.Thread.sleep;

public class AppManager {
    DesiredCapabilities capabilities;
    AppiumDriver driver;

    MainScreenHelper ms;

    ArticleHelper article;

    public void init() throws MalformedURLException {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "8.0");
        capabilities.setCapability("deviceName", "qa_mob");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", "org.wikipedia.main.MainActivity");
        capabilities.setCapability("app", "C:/tools/org.wikipedia.apk");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        ms = new MainScreenHelper(driver);
        article = new ArticleHelper(driver);
    }

    public MainScreenHelper getMs() {
        return ms;
    }

    public ArticleHelper getArticle() {
        return article;
    }

    public void stop() {
        driver.quit();
    }
}
