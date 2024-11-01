package guiTests;

import base.config.BaseTest;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static base.Pages.*;
import static base.helpers.Constants.*;

public class VerifyUserIsAbleToAddItemToCartTest extends BaseTest {

    @Test
    @Tag("critical")
    public void addToCartTest() {
        mainPage().typeSearchInput("Java");

        Selenide.actions().sendKeys(Keys.ENTER).perform();

        resultsPage().clickItemByName("Java: The Complete Reference, Thirteenth Edition");

        bookDetailsPage().clickAddToListButton();

        signInPage().typeEmail(email);
        signInPage().clickContinueButton();

        signInPage().typePassword(password);
        signInPage().clickSignInButton();

        bookDetailsPage().clickAddToCartButton();

        mainPage().clickNavCart();

        Assertions.assertTrue(shoppingCartPage().isItemByNameExist("Java: The Complete Reference, Thirteenth Edition"));

        shoppingCartPage().clickDeleteButton();
    }
}
