package edu.miu.cs.cs544.service.mapper;

import edu.miu.common.service.mapper.BaseMapper;
import edu.miu.cs.cs544.service.contract.RecordPayload;
import ma.glasnost.orika.MapperFactory;
import org.springframework.stereotype.Component;
import edu.miu.cs.cs544.domain.Record;

@Component
public class RecordPayloadToRecordMapper extends BaseMapper<RecordPayload,Record> {
    public RecordPayloadToRecordMapper(MapperFactory mapperFactory) {
        super(mapperFactory, RecordPayload.class, Record.class);
    }
}
