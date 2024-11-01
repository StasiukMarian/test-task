package apiTests;

import base.pojos.createUser.CreateUserRequest;
import io.qameta.allure.restassured.AllureRestAssured;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static base.helpers.Constants.*;
import static io.restassured.RestAssured.given;

public class CreateExistingUserTest {

    @Test
    @Tag("api")
    public void createExistingUserTest() {
        CreateUserRequest requestBody = new CreateUserRequest();

        requestBody.setUsername("Marian");
        requestBody.setEmail("lilmarian2001@gmail.com");
        requestBody.setPassword("test");

        given()
                .filter(new AllureRestAssured())
                .auth().basic(api_username, api_password)
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .post(BASE_URL + "users/").then().statusCode(400);
    }
}
