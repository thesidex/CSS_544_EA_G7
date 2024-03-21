package edu.miu.cs.cs544.controller;
import edu.miu.cs.cs544.service.contract.SessionRequestPayload;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDate;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.nullValue;

public class EventSpecificSessionControllerTest {

    @BeforeClass
    public static void setup() {
        RestAssured.port = Integer.valueOf(8000);
        RestAssured.baseURI = "http://localhost/badge-system";
        RestAssured.basePath = "";
    }

    @Test
    public void testGetSessionsByEventId() {
        given()
                .when()
                .get("/events/1/sessions")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON);
    }
    @Test
    public void testWrongGetSessionsByEventId() {
        given()
                .when()
                .get("/events/22/sessions")
                .then()
                .statusCode(404)
                .body(equalTo("No event found for eventId: 22"));
    }


    @Test
    public void testAddSessionToEvent() {
        SessionRequestPayload sessionRequestPayload = new SessionRequestPayload();
        sessionRequestPayload.setDate(LocalDate.now());
        sessionRequestPayload.setScheduleId(15L);

        given()
                .contentType(ContentType.JSON)
                .body(sessionRequestPayload)
                .when()
                .post("/events/3/sessions")
                .then()
                .statusCode(201)
                .header("Content-Type", nullValue());
    }
    @Test
    public void testUpdateSession() {
        SessionRequestPayload sessionRequestPayload = new SessionRequestPayload();
        LocalDate currentDate = LocalDate.now();
        LocalDate fourDaysAgo = currentDate.minusDays(4);
        sessionRequestPayload.setDate(fourDaysAgo);
        sessionRequestPayload.setScheduleId(15L);

        given()
                .contentType(ContentType.JSON)
                .body(sessionRequestPayload)
                .when()
                .put("/events/3/sessions/19")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON);
    }

    @Test
    public void testDeleteSession() {
        given()
                .when()
                .delete("/events/3/sessions/19")
                .then()
                .statusCode(204);
    }
}
