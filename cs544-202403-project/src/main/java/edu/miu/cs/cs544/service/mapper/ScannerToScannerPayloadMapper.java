package edu.miu.cs.cs544.service.mapper;

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

}
