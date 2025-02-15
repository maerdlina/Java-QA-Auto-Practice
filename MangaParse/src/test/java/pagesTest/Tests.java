package pagesTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.OnePunchManPage;
import webHooks.WebHooks;

public class Tests extends WebHooks {
    private final String searchText = "One Punch-Man";

    private final MainPage mainPage = new MainPage();
    private final OnePunchManPage onePage = new OnePunchManPage();

    @DisplayName("Search in main page")
    @Test
    public void searchTest() throws InterruptedException {
        mainPage.searchText(searchText);
    }

    @DisplayName("Open all titles in manga")
    @Test
    public void mangaOpen() throws InterruptedException {
        mainPage.searchText(searchText);
        onePage.clickButtonMoreTitle();
        onePage.parseMangaImages();
    }
}
