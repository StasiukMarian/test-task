package guiTests;

import base.config.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static base.Pages.*;
import static base.helpers.Constants.*;

public class VerifyUserIsAbleToSignUpTest extends BaseTest {
    @Test
    @Tag("critical")
    public void signUpTest() {
        mainPage().hoverOnLoginMenu();
        mainPage().clickSignUpButton();

        createAccountPage().fillAccountDetails(name, email, password);
        signInPage().clickContinueButton();

        Assertions.assertTrue(createAccountPage().isEmailExistErrorAppears());
    }
}
