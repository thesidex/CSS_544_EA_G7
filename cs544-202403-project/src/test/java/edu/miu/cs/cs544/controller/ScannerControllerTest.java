package edu.miu.cs.cs544.controller;

import edu.miu.common.exception.ResourceNotFoundException;
import edu.miu.cs.cs544.domain.Scanner;
import edu.miu.cs.cs544.service.MemberService;
import edu.miu.cs.cs544.service.RecordService;
import edu.miu.cs.cs544.service.contract.RecordPayload;
import edu.miu.cs.cs544.service.contract.RecordRequestPayload;
import edu.miu.cs.cs544.service.contract.ScanPayload;
import edu.miu.cs.cs544.service.contract.ScannerPayload;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class ScannerControllerTest {

    @Mock
    private RecordService recordService;

    @Mock
    private MemberService memberService;

    @InjectMocks
    private ScannerController scannerController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        scannerController = new ScannerController(recordService, memberService);
    }

    @Test
    void testGetRecordsByScannerId_Success() {
        long scannerId = 1L;
        List<RecordPayload> records = new ArrayList<>();
        records.add(new RecordPayload());
        when(recordService.getRecordsByScannerId(scannerId)).thenReturn(records);

        ResponseEntity<?> responseEntity = scannerController.getRecordsByScannerId(scannerId);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(records, responseEntity.getBody());
    }

    @Test
    void testGetRecordsByScannerId_NoRecordsFound() {
        long scannerId = 1L;
        when(recordService.getRecordsByScannerId(scannerId)).thenReturn(new ArrayList<>());

        assertThrows(ResourceNotFoundException.class,
                () -> scannerController.getRecordsByScannerId(scannerId));
    }

    @Test
    void testDeleteRecordById_Success() {
        long scannerId = 1L;
        long recordId = 1L;
        RecordRequestPayload recordRequestPayload = new RecordRequestPayload();
        when(recordService.updateRecordByScannerId(scannerId, recordId, recordRequestPayload)).thenReturn(new RecordPayload());

        ResponseEntity<?> responseEntity = scannerController.deleteRecordById(scannerId, recordId, recordRequestPayload);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    void testDeleteRecordById_Success_NoContent() {
        long scannerId = 1L;
        long recordId = 1L;

        ResponseEntity<?> responseEntity = scannerController.deleteRecordById(scannerId, recordId);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    void testScanBarcode_Success() {
        long scannerId = 1L;
        ScanPayload scanPayload = new ScanPayload();

        ResponseEntity<?> responseEntity = scannerController.scanBarcode(scannerId, scanPayload);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        verify(memberService, times(1)).takeAttendance(scannerId, scanPayload);
    }
}
