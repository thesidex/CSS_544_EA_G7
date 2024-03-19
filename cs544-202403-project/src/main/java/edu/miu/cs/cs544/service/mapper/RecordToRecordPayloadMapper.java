package edu.miu.cs.cs544.service.mapper;

import edu.miu.common.service.mapper.BaseMapper;
import edu.miu.cs.cs544.domain.Record;
import edu.miu.cs.cs544.domain.Scanner;
import edu.miu.cs.cs544.domain.Session;
import edu.miu.cs.cs544.service.contract.RecordPayload;
import edu.miu.cs.cs544.service.contract.ScannerPayload;
import ma.glasnost.orika.MapperFactory;
import org.springframework.stereotype.Component;

@Component
public class RecordToRecordPayloadMapper extends BaseMapper<Scanner, ScannerPayload> {

	public RecordToRecordPayloadMapper(MapperFactory mapperFactory) {
		super(mapperFactory, Scanner.class, ScannerPayload.class);
	}

	public RecordPayload customMapping(Record source) {
		RecordPayload target = new RecordPayload();
		target.setId(source.getId());
		target.setScanTime(source.getScanTime());
		if (source.getScanner() != null) {
			target.setScannerId(source.getId());
		}
		return target;
	}

}
