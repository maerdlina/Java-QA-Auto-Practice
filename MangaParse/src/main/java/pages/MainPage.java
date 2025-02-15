package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    private final SelenideElement searchButton = $x("//button[@class='btn btn-secondary d-flex align-items-center']");
    private final SelenideElement searchInput = $x("//input[@id='search-modal']");
    private final SelenideElement onepunchmanCard = $x("//img[@class='img-fluid lozad lozad-fade']");



    public void searchText(String text) throws InterruptedException {
        searchButton.shouldBe(visible).click(); // Ожидание видимости кнопки
        searchInput.shouldBe(visible).shouldBe(enabled).click(); // Ожидание ввода
        searchInput.setValue(text).pressEnter(); // Используйте setValue для ввода текста
        onepunchmanCard.shouldBe(visible).shouldBe(enabled).click();
//        Thread.sleep(10000);
    }
}
