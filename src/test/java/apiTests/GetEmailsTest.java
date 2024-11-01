package apiTests;


import base.pojos.email.EmailData;
import io.qameta.allure.restassured.AllureRestAssured;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;

import static base.helpers.Constants.*;
import static io.restassured.RestAssured.given;

public class GetEmailsTest {
    @Test
    @Tag("api")
    public void getEmailsTest(){
        List<EmailData> emails = given()
                .filter(new AllureRestAssured())
                .auth().basic(api_username, api_password)
                .when()
                .get(BASE_URL + "emails")
                .then()
                .statusCode(200)
                .extract().body().jsonPath().getList("results", EmailData.class);

        for (EmailData emailData : emails) {
            Assertions.assertEquals(535, (int) emailData.getSender());
        }
    }
}
