package base.pages;

import base.helpers.PageTools;
import base.pages.model.Book;

import static com.codeborne.selenide.Condition.clickable;

public class BookDetailsPage extends PageTools {
    private final String addToListButton = "wishListMainButton";
    private final String addToCartButton = "add-to-cart-button";
    private final String name = "productTitle";
    private final String price = "//span[text()='Kindle']/parent::span/following-sibling::span[@class='slot-price']/span";

    public void clickAddToListButton() {
        shouldBe("id", clickable, addToListButton);
        click("id", addToListButton);
    }

    public void clickAddToCartButton() {
        shouldBe("id", clickable, addToCartButton);
        click("id", addToCartButton);
    }

    public Book detailBook() {
        Book book = new Book();

        book.setName(getText("id", name));
        book.setPrice(getText("xpath", price));

        return book;
    }
}
