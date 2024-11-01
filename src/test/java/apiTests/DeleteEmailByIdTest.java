package apiTests;

import base.pojos.createEmail.CreateEmailRequest;
import base.pojos.createEmail.CreateEmailResponse;
import base.pojos.currentUser.CurrentUser;
import io.qameta.allure.restassured.AllureRestAssured;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static base.helpers.Constants.*;
import static io.restassured.RestAssured.given;

public class DeleteEmailByIdTest {
    @Test
    @Tag("api")
    public void deleteEmailByIdTest() {

        CurrentUser currentUser = given()
                .filter(new AllureRestAssured())
                .auth().basic(api_username, api_password)
                .when()
                .get(BASE_URL + "users/current")
                .then()
                .statusCode(200)
                .extract().as(CurrentUser.class);

        Integer id = currentUser.getId();

        CreateEmailRequest emailRequest = new CreateEmailRequest();

        emailRequest.setSender(id);
        emailRequest.setRecipient("lilmarian2001@gmail.com");
        emailRequest.setSubject("Test mail");
        emailRequest.setMessage("hello!");

        CreateEmailResponse emailResponse = given()
                .filter(new AllureRestAssured())
                .auth().basic(api_username, api_password)
                .header("Content-Type", "application/json")
                .body(emailRequest)
                .when()
                .post(BASE_URL + "emails/").then().statusCode(201)
                .extract().as(CreateEmailResponse.class);

        Assertions.assertEquals(id, emailResponse.getSender());
        Assertions.assertEquals(emailRequest.getRecipient(), emailResponse.getRecipient());
        Assertions.assertEquals(emailRequest.getSubject(), emailResponse.getSubject());
        Assertions.assertEquals(emailRequest.getMessage(), emailResponse.getMessage());

        Integer emailId = emailResponse.getId();

        given()
                .filter(new AllureRestAssured())
                .auth().basic(api_username, api_password)
                .delete(BASE_URL + "emails/" + emailId + "/")
                .then()
                .statusCode(204);

    }
}
