package edu.miu.cs.cs544.service.mapper;

import edu.miu.common.service.mapper.BaseMapper;
import edu.miu.cs.cs544.domain.Scanner;
import edu.miu.cs.cs544.service.contract.ScannerPayload;
import ma.glasnost.orika.MapperFactory;
import org.springframework.stereotype.Component;

@Component
public class RecordPayloadToRecordMapper extends BaseMapper<ScannerPayload, Scanner>{

	public RecordPayloadToRecordMapper(MapperFactory mapperFactory) {
		super(mapperFactory, ScannerPayload.class, Scanner.class);
	}
}
