package edu.miu.cs.cs544.service.mapper;

import edu.miu.common.service.mapper.BaseMapper;
import edu.miu.cs.cs544.domain.Record;
import edu.miu.cs.cs544.service.contract.RecordPayload;
import ma.glasnost.orika.MapperFactory;
import org.springframework.stereotype.Component;

@Component
public class RecordToRecordPayloadMapper extends BaseMapper<Record, RecordPayload> {

	public RecordToRecordPayloadMapper(MapperFactory mapperFactory) {
		super(mapperFactory, Record.class, RecordPayload.class);
	}

	public RecordPayload customMapping(Record source) {
		RecordPayload target = new RecordPayload();
		target.setId(source.getId());
		target.setScanTime(source.getScanTime());
		target.setMemberId(source.getMember().getId());
		target.setScannerId(source.getScanner().getId());
		return target;
	}

}
