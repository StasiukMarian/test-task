package base.pages;

import base.helpers.PageTools;

import static com.codeborne.selenide.Condition.*;

public class CreateAccountPage extends PageTools {
    private final String nameInput = "ap_customer_name";
    private final String emailInput = "ap_email";
    private final String passwordInput = "ap_password";
    private final String passwordConfirmInput = "ap_password_check";
    private final String existingEmailError = "register-mase-inlineerror";

    public void fillAccountDetails(String name, String email, String password) {
        shouldBe("id", visible, nameInput);
        type("id", name, nameInput);
        type("id", email, emailInput);
        type("id", password, passwordInput);
        type("id", password, passwordConfirmInput);
    }
    public boolean isEmailExistErrorAppears(){
        return isElementExist("id", existingEmailError);
    }
}
