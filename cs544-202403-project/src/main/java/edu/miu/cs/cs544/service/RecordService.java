package edu.miu.cs.cs544.service;

import edu.miu.common.service.BaseReadWriteService;
import edu.miu.cs.cs544.domain.Scanner;
import edu.miu.cs.cs544.service.contract.RecordPayload;
import edu.miu.cs.cs544.service.contract.ScannerPayload;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RecordService extends BaseReadWriteService <ScannerPayload, Scanner, Long>{
    List<RecordPayload> getRecordsByScannerId (Long scannerId);
}
