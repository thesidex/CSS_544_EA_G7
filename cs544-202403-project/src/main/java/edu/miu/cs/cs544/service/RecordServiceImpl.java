package edu.miu.cs.cs544.service;

import edu.miu.common.service.BaseReadWriteServiceImpl;
import edu.miu.cs.cs544.domain.Record;
import edu.miu.cs.cs544.domain.Scanner;
import edu.miu.cs.cs544.repository.RecordRepository;
import edu.miu.cs.cs544.repository.ScannerRepository;
import edu.miu.cs.cs544.service.contract.RecordPayload;
import edu.miu.cs.cs544.service.contract.ScannerPayload;
import edu.miu.cs.cs544.service.mapper.RecordToRecordPayloadMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecordServiceImpl extends BaseReadWriteServiceImpl<ScannerPayload, Scanner, Long> implements ScannerService {

    @Autowired
    private RecordRepository recordRepository;

    @Autowired
    private ScannerRepository scannerRepository;

    @Autowired
    private RecordToRecordPayloadMapper recordMapper;

    public List<RecordPayload> getRecordsByScannerId(Long scannerId){
        List<Record> records = recordRepository.findByScannerId(scannerId);
        return records.stream()
                .map(record -> recordMapper.customMapping(record))
                .collect(Collectors.toList());
    }


}
