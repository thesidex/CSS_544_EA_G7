package edu.miu.cs.cs544.service;

import edu.miu.common.exception.ResourceNotFoundException;
import edu.miu.common.service.BaseReadWriteServiceImpl;
import edu.miu.cs.cs544.domain.Member;
import edu.miu.cs.cs544.domain.Record;
import edu.miu.cs.cs544.domain.Scanner;
import edu.miu.cs.cs544.repository.RecordRepository;
import edu.miu.cs.cs544.repository.ScannerRepository;
import edu.miu.cs.cs544.service.contract.RecordPayload;
import edu.miu.cs.cs544.service.contract.RecordRequestPayload;
import edu.miu.cs.cs544.service.mapper.RecordToRecordPayloadMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class RecordServiceImpl extends BaseReadWriteServiceImpl<RecordPayload, Record, Long> implements RecordService {

    @Autowired
    private RecordRepository recordRepository;

    @Autowired
    private RecordToRecordPayloadMapper recordMapper;

    public List<RecordPayload> getRecordsByScannerId(Long scannerId){
        List<Record> records = recordRepository.findByScannerId(scannerId);
        return records.stream()
                .map(record -> recordMapper.customMapping(record))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteRecordByScannerId(Long scannerId, Long recordId) {
        Record record = recordRepository.findById(recordId)
                .orElseThrow(() -> new ResourceNotFoundException("Record not found with id: " + recordId));
        if (!record.getScanner().getId().equals(scannerId)) {
            throw new ResourceNotFoundException("Record with id: " + recordId + " does not belong to Scanner with id: " + scannerId);
        }
        recordRepository.delete(record);
    }

    public RecordPayload updateRecordByScannerId(Long scannerId, Long recordId, RecordRequestPayload recordRequestPayload) {
        Record record = recordRepository.findById(recordId)
                .orElseThrow(() -> new ResourceNotFoundException("Record not found with id: " + recordId));

        if (!record.getScanner().getId().equals(scannerId)) {
            throw new ResourceNotFoundException("Record with id: " + recordId + " does not belong to Scanner with id: " + scannerId);
        }
        record.setScanTime(recordRequestPayload.getScanTime());
        record = recordRepository.save(record);
        return recordMapper.map(record);
    }


}
