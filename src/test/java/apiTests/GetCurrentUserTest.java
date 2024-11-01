package apiTests;

import base.pojos.currentUser.CurrentUser;
import io.qameta.allure.restassured.AllureRestAssured;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static base.helpers.Constants.*;
import static io.restassured.RestAssured.given;

public class GetCurrentUserTest {
    @Test
    @Tag("api")
    public void getCurrentUserTest() {

        CurrentUser currentUser = given()
                .filter(new AllureRestAssured())
                .auth().basic(api_username, api_password)
                .when()
                .get(BASE_URL + "users/current")
                .then()
                .statusCode(200)
                .extract().as(CurrentUser.class);

        Assertions.assertNotNull(currentUser);

        Assertions.assertEquals(api_username, currentUser.getUsername());
    }
}
