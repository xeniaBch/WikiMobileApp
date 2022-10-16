package com.telran.tests;

import org.testng.annotations.Test;

public class ArticleTest extends TestBase {

    @Test
    public void addArticleToFavouriteAndRemoveTest() throws InterruptedException {
        app.getMs().searchArticle(0, 2000);
        app.getArticle().addToFavourites(20);
        app.getArticle().createReadingList(20, "NewReadingList", 1);
        app.getArticle().close(3000);
        app.getArticle().selectFavourites(10);
        // app.getArticle().removeArticleFromFavourites();
    }
}
