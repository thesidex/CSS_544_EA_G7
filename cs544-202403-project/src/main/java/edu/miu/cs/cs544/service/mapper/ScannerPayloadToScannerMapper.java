package edu.miu.cs.cs544.service.mapper;

import org.springframework.stereotype.Component;
import edu.miu.common.service.mapper.BaseMapper;
import edu.miu.cs.cs544.domain.Scanner;
import edu.miu.cs.cs544.service.contract.ScannerPayload;
import ma.glasnost.orika.MapperFactory;

@Component
public class ScannerPayloadToScannerMapper extends BaseMapper<ScannerPayload, Scanner>{

	public ScannerPayloadToScannerMapper(MapperFactory mapperFactory) {
		super(mapperFactory, ScannerPayload.class, Scanner.class);
	}
}
