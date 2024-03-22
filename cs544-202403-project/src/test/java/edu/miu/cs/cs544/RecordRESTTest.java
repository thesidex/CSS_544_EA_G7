package edu.miu.cs.cs544;

import edu.miu.cs.cs544.domain.*;
import edu.miu.cs.cs544.domain.Record;
import edu.miu.cs.cs544.service.contract.RecordRequestPayload;
import edu.miu.cs.cs544.service.contract.ScanPayload;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.github.loki4j.client.pipeline.PipelineConfig.json;
import static io.restassured.RestAssured.*;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RecordRESTTest {
    @BeforeClass
    public static void setup() {
        RestAssured.port = Integer.valueOf(8080);
        RestAssured.baseURI = "http://localhost";
        RestAssured.basePath = "/badge-system";
    }

    @Test
    public void testRegisterAnEvent() throws Exception {
        String memberId = "2";
        String eventId = "1";

        given()
                .pathParam("memberId", memberId)
                .pathParam("eventId", eventId)
                .when()
                .post("/members/{memberId}/register/{eventId}")
                .then()
                .statusCode(200);
    }

    /*UPDATE RECORD*/
    @Test
    public void testUpdateRecordByScannerId() {
        Long scannerId = 1L;
        Long recordId = 1L;
        LocalDateTime scanTime = LocalDateTime.of(2024, 3, 21, 12, 0);
        RecordRequestPayload recordRequestPayload = new RecordRequestPayload();
        recordRequestPayload.setScanTime(scanTime);

        given()
                .contentType(ContentType.JSON)
                .pathParam("scannerId", scannerId)
                .pathParam("recordId", recordId)
                .body(recordRequestPayload)
                .when()
                .put("/scanners/{scannerId}/records/{recordId}")
                .then()
                .statusCode(200);
    }

//    /*DELETE A RECORD*/
//    @Test
//    public void testDeleteRecordByScannerId() {
//        Long scannerId = 1L;
//        Long recordId = 1L;
//
//        given()
//                .pathParam("scannerId", scannerId)
//                .pathParam("recordId", recordId)
//                .when()
//                .delete("/scanners/{scannerId}/records/{recordId}")
//                .then()
//                .statusCode(200);
//    }
//
//    @Test
//    public void testTakeAttendance() throws Exception {
//        Long scannerId = 1L;
//        ScanPayload scanPayload = new ScanPayload();
//        scanPayload.setMemberBarcode("BC71232");
//        scanPayload.setSessionId(1L);
//
//        given()
//                .contentType(ContentType.JSON)
//                .pathParam("scannerId", scannerId)
//                .body(scanPayload)
//                .when()
//                .post("scanners/{scannerId}/scan")
//                .then()
//                .statusCode(200);
//    }

    /*GET ALL RECORDS*/
    @Test
    public void testGetRecordsByScannerId() throws Exception {
        // Mock data
        List<Record> records = new ArrayList<>();
        records.add(new Record(new Member(), new Scanner(1L, new Location(), new Event()), new Session()));

        given()
                .when()
                .get("/scanners/1/records")
                .then()
                .statusCode(200);
    }


}
