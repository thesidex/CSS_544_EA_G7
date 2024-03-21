package edu.miu.cs.cs544.service.mapper;

import edu.miu.cs.cs544.domain.Record;
import edu.miu.cs.cs544.service.contract.RecordPayload;
import org.springframework.stereotype.Component;

import edu.miu.common.service.mapper.BaseMapper;
import edu.miu.cs.cs544.domain.Scanner;
import edu.miu.cs.cs544.service.contract.ScannerPayload;
import ma.glasnost.orika.MapperFactory;

@Component
public class ScannerToScannerPayloadMapper extends BaseMapper<Scanner, ScannerPayload> {

	public ScannerToScannerPayloadMapper(MapperFactory mapperFactory) {
		super(mapperFactory, Scanner.class, ScannerPayload.class);
	}

	public ScannerPayload customMapping (Scanner source) {
		ScannerPayload target = new ScannerPayload();
		target.setId(source.getId());
		target.setLocationId(source.getLocation().getId());
		target.setEventId(source.getEvent().getId());
		return target;
	}

}
