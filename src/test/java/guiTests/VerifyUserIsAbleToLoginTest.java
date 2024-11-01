package guiTests;

import base.config.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static base.Pages.*;
import static base.helpers.Constants.*;

public class VerifyUserIsAbleToLoginTest extends BaseTest {
    @Test
    @Tag("critical")
    public void loginTest() {
        mainPage().hoverOnLoginMenu();
        mainPage().clickSignInButton();

        signInPage().typeEmail(email);
        signInPage().clickContinueButton();

        signInPage().typePassword(password);
        signInPage().clickSignInButton();

        Assertions.assertEquals("Hello, Marian", mainPage().getAccountValue(), "Values are different");
    }
}
