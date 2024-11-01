package base.config;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {
    @BeforeEach
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1280x920";
        Configuration.timeout = 10000;
        Configuration.pageLoadTimeout = 10000;
        Configuration.headless = true;
        Configuration.screenshots = true;
        Configuration.savePageSource = false;

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(false));

        Selenide.open("https://www.amazon.com/");
    }

    @AfterEach
    public void tearDown() {
        Selenide.clearBrowserCookies();
        Selenide.refresh();
        Selenide.open("about:blank");
        Selenide.closeWebDriver();
    }

}
