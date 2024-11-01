package base;

import base.pages.*;

public class Pages {
    private static MainPage mainPage;
    private static SignInPage signInPage;
    private static ResultsPage resultsPage;
    private static BookDetailsPage bookDetailsPage;
    private static ShoppingCartPage shoppingCartPage;
    private static CreateAccountPage createAccountPage;
    private static CustomerPreferencesPage customerPreferencesPage;

    public static MainPage mainPage() {
        if (mainPage == null) {
            mainPage = new MainPage();
        }
        return mainPage;
    }

    public static SignInPage signInPage() {
        if (signInPage == null) {
            signInPage = new SignInPage();
        }
        return signInPage;
    }

    public static ResultsPage resultsPage() {
        if (resultsPage == null) {
            resultsPage = new ResultsPage();
        }
        return resultsPage;
    }

    public static BookDetailsPage bookDetailsPage() {
        if (bookDetailsPage == null) {
            bookDetailsPage = new BookDetailsPage();
        }
        return bookDetailsPage;
    }
    public static ShoppingCartPage shoppingCartPage() {
        if (shoppingCartPage == null) {
            shoppingCartPage = new ShoppingCartPage();
        }
        return shoppingCartPage;
    }
    public static CreateAccountPage createAccountPage() {
        if (createAccountPage == null) {
            createAccountPage = new CreateAccountPage();
        }
        return createAccountPage;
    }
    public static CustomerPreferencesPage customerPreferencesPage() {
        if (customerPreferencesPage == null) {
            customerPreferencesPage = new CustomerPreferencesPage();
        }
        return customerPreferencesPage;
    }
}
