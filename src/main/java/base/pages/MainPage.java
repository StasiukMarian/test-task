package base.pages;

import base.helpers.PageTools;

import java.util.List;

import static base.helpers.CustomConditions.inputCondition;
import static com.codeborne.selenide.Condition.*;

public class MainPage extends PageTools {
    private final String loginMenuNav = "//span[@class='nav-line-2 ']";
    private final String accountListNav = "nav-link-accountList-nav-line-1";
    private final String signInButton = "//span[@class='nav-action-inner' and text()='Sign in']";
    private final String signUpButton = "//a[text()='Start here.']";
    private final String inputSelector = "//select";
    private final String optionByName = "//option[text()='%s']";
    private final String searchInput = "twotabsearchtextbox";
    private final String navCartButton = "nav-cart";
    private final String navItems = "//div[@id='nav-xshop']/a[position() < 6]";
    private final String chooseLanguage = "//a[@aria-label='Choose a language for shopping.']";
    private final String language = "//*[text()='Deutsch']";

    public void hoverOnLoginMenu() {
        shouldBe("xpath", visible, loginMenuNav);
        hover("xpath", loginMenuNav);
    }
    public void hoverOnChooseLanguage() {
        shouldBe("xpath", visible, chooseLanguage);
        hover("xpath", chooseLanguage);
    }
    public void clickChooseLanguage() {
        shouldBe("xpath", visible, chooseLanguage);
        click("xpath", chooseLanguage);
    }
    public void clickSignInButton() {
        shouldBe("xpath", visible, signInButton);
        click("xpath", signInButton);
    }

    public void clickSignUpButton() {
        shouldBe("xpath", visible, signUpButton);
        click("xpath", signUpButton);
    }
    public void clickNavCart(){
        shouldBe("id", visible, navCartButton);
        click("id", navCartButton);
    }
    public void clickLanguage (){
        click("xpath", language);
    }

    public String getAccountValue() {
        shouldBe("id", visible, accountListNav);
        return getText("id", accountListNav);
    }

    public void selectOptionByName(String optionName) {
        click("xpath", inputSelector);
        click("xpath", optionByName, optionName);

    }

    public void typeSearchInput(String searchValue) {
        shouldBe("id", inputCondition, searchInput);
        type("id", searchValue, searchInput);
    }
    public List<String> getNavItemsTexts(){
       return getElementsText("xpath", navItems);
    }
}
