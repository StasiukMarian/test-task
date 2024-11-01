package base.pages;

import base.helpers.PageTools;

public class CustomerPreferencesPage extends PageTools {
    private final String currencyDropDown = "//select[@id='icp-currency-dropdown']/parent::span";
    private final String currency = "//option[@value='IDR']";
    private final String saveButton = "//span[@id='icp-save-button-announce']/preceding-sibling::input";

    public void selectCurrency(){
        click("xpath", currencyDropDown);
        click("xpath", currency);
    }
    public void clickSaveButton (){
        click("xpath", saveButton);
    }
}
