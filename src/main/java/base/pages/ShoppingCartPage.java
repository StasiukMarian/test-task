package base.pages;

import base.helpers.PageTools;

import static com.codeborne.selenide.Condition.clickable;

public class ShoppingCartPage extends PageTools {
    private final String itemByName = "//span[text()='%s']";
    private final String deleteButton = "//input[@value='Delete']";

    public boolean isItemByNameExist(String name) {
        return isElementExist("xpath", itemByName, name);
    }
    public void clickDeleteButton(){
        shouldBe("xpath", clickable, deleteButton);
        click("xpath", deleteButton);
    }
}
