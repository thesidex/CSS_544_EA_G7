package edu.miu.cs.cs544.service.mapper;

import edu.miu.common.service.mapper.BaseMapper;
import edu.miu.cs.cs544.domain.Record;
import edu.miu.cs.cs544.service.contract.RecordPayload;
import ma.glasnost.orika.MapperFactory;

public class RecordToRecordPayloadMapper  extends BaseMapper<Record, RecordPayload>{
    public RecordToRecordPayloadMapper(MapperFactory mapperFactory) {
        super(mapperFactory, Record.class, RecordPayload.class);
    }
}
