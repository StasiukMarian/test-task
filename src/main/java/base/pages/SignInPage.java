package base.pages;

import base.helpers.PageTools;

import static base.helpers.CustomConditions.inputCondition;
import static com.codeborne.selenide.Condition.*;

public class SignInPage extends PageTools {
    private final String emailInput = "//input[@type='email']";
    private final String passwordInput = "//input[@type='password']";
    private final String continueButton = "continue";
    private final String signInButton = "signInSubmit";

    public void typeEmail(String email) {
        shouldBe("xpath", inputCondition, emailInput);
        type("xpath", email, emailInput);
    }

    public void typePassword(String pass) {
        shouldBe("xpath", inputCondition, passwordInput);
        type("xpath", pass, passwordInput);
    }

    public void clickContinueButton() {
        shouldBe("id", clickable, continueButton);
        click("id", continueButton);
    }
    public void clickSignInButton() {
        shouldBe("id", clickable, signInButton);
        click("id", signInButton);
    }
}
