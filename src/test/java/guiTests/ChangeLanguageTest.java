package guiTests;

import base.config.BaseTest;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;

import static base.Pages.*;

public class ChangeLanguageTest extends BaseTest {
    @Test
    @Tag("extended")
    public void languageTest() {
        List<String> navItemsTextsUS = mainPage().getNavItemsTexts();

        mainPage().hoverOnChooseLanguage();
        mainPage().clickLanguage();

        Selenide.sleep(3000);

        List<String> navItemsTextsDE = mainPage().getNavItemsTexts();
        Assertions.assertNotEquals(navItemsTextsUS, navItemsTextsDE);
    }
}
