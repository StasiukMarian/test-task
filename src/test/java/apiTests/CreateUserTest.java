package apiTests;

import base.pojos.createUser.*;
import io.qameta.allure.restassured.AllureRestAssured;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static base.helpers.Constants.*;
import static io.restassured.RestAssured.given;

public class CreateUserTest {

    @Test
    @Tag("api")
    public void createUserTest() {
        int randomNumber = (int) (Math.random() * 100) + 1;
        String username = "Marian" + randomNumber;

        CreateUserRequest requestBody = new CreateUserRequest();

        requestBody.setUsername(username);
        requestBody.setEmail("lilmarian2001@gmail.com");
        requestBody.setPassword("test");

        CreateUserResponse createUserResponse =
                given().filter(new AllureRestAssured())
                .auth().basic(api_username, api_password)
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .post(BASE_URL + "users/").then().statusCode(201)
                .extract().as(CreateUserResponse.class);

        Assertions.assertEquals(username, createUserResponse.getUsername());
        Assertions.assertEquals(requestBody.getEmail(), createUserResponse.getEmail());
    }
}
