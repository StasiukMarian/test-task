package base.pages;

import base.helpers.PageTools;
import base.pages.model.Book;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.clickable;

public class ResultsPage extends PageTools {
    private final String itemHeaderByName = "//span[text()='%s']";
    private final String itemHeaders = "//img[@class='s-image']/ancestor::div[@class='puisg-col-inner']/parent::div/following-sibling::div//h2/a/span";
    private final String itemPrices = "//img[@class='s-image']/ancestor::div[@class='puisg-col-inner']/parent::div/following-sibling::div//span[@class='a-price']/span[@class='a-offscreen']";

    public void clickItemByName(String name) {
        shouldBe("xpath", clickable, itemHeaderByName, name);
        click("xpath", itemHeaderByName, name);
    }

    public List<Book> getBooks() {
        List<Book> bookList = new ArrayList<>();

        List<String> headersList = getElementsText("xpath", itemHeaders);
        List<String> pricesList = getElementsText("xpath", itemPrices);

        for (int i = 0; i < headersList.size(); i++) {
            Book book = new Book();

            book.setName(headersList.get(i));
            book.setPrice(pricesList.get(i));

            bookList.add(book);
        }
        return bookList;
    }
}
