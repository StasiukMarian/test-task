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

public class CompareItemInResultsPageWithDetailItemTest extends BaseTest {
    @Test
    @Tag("extended")
    public void detailItemTest() {
        mainPage().selectOptionByName("Books");
        mainPage().typeSearchInput("Java");

        Selenide.actions().sendKeys(Keys.ENTER).perform();

        List<Book> booksFromResultsPageList = resultsPage().getBooks();

        resultsPage().clickItemByName("Java: The Complete Reference, Thirteenth Edition");

        Book detailBook = bookDetailsPage().detailBook();

        Assertions.assertTrue(booksFromResultsPageList.contains(detailBook));
    }
}
