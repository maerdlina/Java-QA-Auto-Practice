package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;

public class OnePunchManPage {
    private final SelenideElement moreTitlesButton = $x("//button[@class='btn btn-secondary btn-lg w-100 mb-4']");
    private final SelenideElement firstTitle = $$(".card.d-flex.justify-content-between.flex-row").last();
    private final SelenideElement imageFirst = $x("//img[@class='img-fluid']");

    public void clickButtonMoreTitle() throws InterruptedException {
        moreTitlesButton.shouldBe(visible).click();
        firstTitle.shouldBe(visible).scrollTo();
        int attempts = 0;
        while (attempts < 5) { // Максимум 5 попыток прокрутки
            firstTitle.scrollTo();
            Thread.sleep(500); // Ждем немного после прокрутки

            // Проверяем, виден ли элемент после прокрутки
            if (firstTitle.is(visible)) {
                break; // Если элемент виден, выходим из цикла
            }
            attempts++;
        }

        // Убедимся, что элемент видим перед кликом
        firstTitle.shouldBe(visible).click();
        Thread.sleep(5000);
    }


    public void parseMangaImages() {
        // Извлекаем все изображения с классом img-fluid
        ElementsCollection images = $$(".img-fluid");
        for (SelenideElement image : images) {
            String imageUrl = image.getAttribute("src"); // Получаем URL изображения
            System.out.println("Image URL: " + imageUrl); // Выводим URL в консоль
        }
    }
}
