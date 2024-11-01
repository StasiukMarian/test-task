package guiTests;

import base.config.BaseTest;
import base.pages.model.Book;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.util.List;

import static base.Pages.*;


public class ChangeCurrencyTest extends BaseTest {
    @Test
    @Tag("extended")
    public void currencyTest() {
        mainPage().clickChooseLanguage();

        customerPreferencesPage().selectCurrency();
        Selenide.actions().sendKeys(Keys.ENTER).perform();

        customerPreferencesPage().clickSaveButton();

        mainPage().selectOptionByName("Books");
        mainPage().typeSearchInput("Java");

        Selenide.actions().sendKeys(Keys.ENTER).perform();

        List<Book> booksFromResultsPageList = resultsPage().getBooks();

        for (int i = 0; i < booksFromResultsPageList.size(); i++) {
            Assertions.assertTrue(booksFromResultsPageList.get(i).getPrice().contains("IDR"));
        }
    }
}
