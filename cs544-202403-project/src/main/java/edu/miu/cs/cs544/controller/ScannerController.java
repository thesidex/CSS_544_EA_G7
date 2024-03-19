package edu.miu.cs.cs544.controller;

import edu.miu.common.controller.BaseReadWriteController;
import edu.miu.common.exception.ResourceNotFoundException;
import edu.miu.cs.cs544.domain.Scanner;
import edu.miu.cs.cs544.service.RecordService;
import edu.miu.cs.cs544.service.contract.RecordPayload;
import edu.miu.cs.cs544.service.contract.ScannerPayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/scanners")
public class ScannerController extends BaseReadWriteController<ScannerPayload, Scanner, Long> {

    @Autowired
    private RecordService recordService;

    @GetMapping("/{scannerId}/records")
    public ResponseEntity<?> getRecordsByScannerId(@PathVariable Long scannerId) {
        List<RecordPayload> records = recordService.getRecordsByScannerId(scannerId);
        if (records.isEmpty()) {
            throw new ResourceNotFoundException("No records found for scannerId: " + scannerId);
        }
        return new ResponseEntity<>(records, HttpStatus.OK);
    }
}