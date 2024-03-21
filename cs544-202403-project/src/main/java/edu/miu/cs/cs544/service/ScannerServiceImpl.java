package edu.miu.cs.cs544.service;

import edu.miu.cs.cs544.repository.ScannerRepository;
import edu.miu.cs.cs544.service.mapper.ScannerPayloadToScannerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import edu.miu.common.service.BaseReadWriteServiceImpl;
import edu.miu.cs.cs544.domain.Scanner;
import edu.miu.cs.cs544.service.contract.ScannerPayload;

@Service
public class ScannerServiceImpl extends BaseReadWriteServiceImpl<ScannerPayload, Scanner, Long> implements ScannerService {
}
