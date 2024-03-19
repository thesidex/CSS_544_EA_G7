package edu.miu.cs.cs544.service;

import edu.miu.common.service.BaseReadWriteService;
import edu.miu.cs.cs544.domain.Record;
import edu.miu.cs.cs544.service.contract.RecordPayload;

import java.util.List;

public interface RecordService extends BaseReadWriteService <RecordPayload, Record, Long>{
    List<RecordPayload> getRecordsByScannerId (Long scannerId);
}
