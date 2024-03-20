package edu.miu.cs.cs544;

import edu.miu.cs.cs544.domain.*;
import edu.miu.cs.cs544.service.contract.AttendancePayload;
import edu.miu.cs.cs544.service.contract.ScannerPayload;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.LocalTime;

import static io.restassured.RestAssured.given;

@SpringBootTest
public class AttendanceRESTTest {
    @BeforeClass
    public static void setup() {
        RestAssured.port = Integer.valueOf(8080);
        RestAssured.baseURI = "http://localhost";
        RestAssured.basePath = "/badge-system";
    }
    @Test
    public void testGetOneScannerRecord() {
        /*Member member = new Member();
        Location location = new Location("Dalby Hall","CS544 classroom", LocationType.CLASS);
        Event event = new Event("CS544","EA",AccountType.ATTENDANCE, LocalDateTime.now(),LocalDateTime.of(2024,03,31,12,00));
        Session session = new Session(LocalTime.of(12,30,00), LocalTime.of(12,30,00));
        event.addSchedule(session);
        event.addParticipant(member);
        ScannerPayload scannerPayload = new ScannerPayload("01",new Location("Argiro","Dalby Hall", LocationType.CLASS),AccountType.ATTENDANCE,
                new Event("CS544", "EA",AccountType.ATTENDANCE, LocalDateTime.now(),LocalDateTime.now()));
        Scanner scanner = new Scanner(location, AccountType.ATTENDANCE,event);

        AttendancePayload attendance = new AttendancePayload(member,scanner,LocalDateTime.now());
        Response response = given()
                .auth()
                .basic("user", "123")
                .contentType("application/json")
                .body(attendance)
                .when().post("attendances/register")
                .then()
                .statusCode(200)
                .extract()
                .response();*/
    }
}
