package edu.miu.cs.cs544.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import edu.miu.common.domain.SyncEvent;
import edu.miu.cs.cs544.repository.ScannerRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import edu.miu.cs.cs544.domain.Record;
import edu.miu.cs.cs544.domain.Scanner;
import edu.miu.cs.cs544.repository.RecordRepository;
import edu.miu.cs.cs544.service.contract.RecordPayload;
import edu.miu.cs.cs544.service.contract.RecordRequestPayload;
import edu.miu.cs.cs544.service.mapper.RecordToRecordPayloadMapper;

@RunWith(MockitoJUnitRunner.class)
public class RecordServiceImplTest {

    @Mock
    private RecordRepository recordRepository;

    @Mock
    private ScannerRepository scannerRepository;

    @Mock
    private RecordToRecordPayloadMapper recordMapper;

    @InjectMocks
    private RecordServiceImpl recordService;

    private Record testRecord;

    private Scanner testScanner;

    @Before
    public void setUp() {
        testScanner = new Scanner();
        testRecord = new Record();
        testRecord.setId(1L);
        recordService = new RecordServiceImpl(recordRepository, recordMapper);
    }

    @Test
    public void getRecordsByScannerId_ReturnsRecords() {
        // Arrange
        Long scannerId = 2L;
        List<Record> records = new ArrayList<>();
        testScanner.setId(scannerId);
        testRecord.setScanner(testScanner);
        records.add(testRecord);

        when(recordRepository.findByScannerId(scannerId)).thenReturn(records);
        //System.out.println("records:"+records.get(0));
        // Act
        List<RecordPayload> result = recordService.getRecordsByScannerId(scannerId);


        // Assert
        assertEquals(1, result.size());
        System.out.println("resultGet(0):::"+result.get(0));
        assertEquals(testRecord.getScanner().getId(), result.getFirst().getScannerId());
    }

    @Test
    public void deleteRecordByScannerId_RecordFoundAndDeleted() {
        // Arrange
        Long scannerId = 1L;
        Long recordId = 1L;

        when(recordRepository.findById(recordId)).thenReturn(Optional.of(testRecord));

        // Act
        recordService.deleteRecordByScannerId(scannerId, recordId);

        // Assert
        verify(recordRepository, times(1)).delete(testRecord);
    }

    @Test
    public void updateRecordByScannerId_RecordUpdated() {
        // Arrange
        Long scannerId = 1L;
        Long recordId = 1L;
        testScanner.setId(scannerId);
        testRecord.setScanner(testScanner);
        LocalDateTime newScanTime = LocalDateTime.now();
        RecordRequestPayload recordRequestPayload = new RecordRequestPayload();
        recordRequestPayload.setScanTime(newScanTime);
        testRecord.setScanTime(newScanTime);

        when(recordRepository.findById(recordId)).thenReturn(Optional.of(testRecord));
        when((recordRepository.save(testRecord))).thenReturn(testRecord);

        // Act
        RecordPayload updatedRecord = recordService.updateRecordByScannerId(scannerId, recordId, recordRequestPayload);

        // Assert
        assertEquals(newScanTime, updatedRecord.getScanTime());
    }
}
