package edu.miu.cs.cs544.service;

import edu.miu.common.exception.ResourceNotFoundException;
import edu.miu.cs.cs544.domain.Record;
import edu.miu.cs.cs544.domain.Scanner;
import edu.miu.cs.cs544.domain.Session;
import edu.miu.cs.cs544.repository.*;
import edu.miu.cs.cs544.service.contract.ScanPayload;
import edu.miu.cs.cs544.service.mapper.RecordToRecordPayloadMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.miu.common.service.BaseReadWriteServiceImpl;
import edu.miu.cs.cs544.domain.Member;
import edu.miu.cs.cs544.service.contract.MemberPayload;

@Service
@Transactional
public class MemberServiceImpl extends BaseReadWriteServiceImpl<MemberPayload, Member, Long> implements MemberService {

    @Autowired
    private ScannerRepository scannerRepository;
    @Autowired
    private SessionRepository sessionRepository;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private RecordRepository recordRepository;
    @Autowired
    private RegistrationRepository registrationRepository;

    @Autowired
    private RecordToRecordPayloadMapper recordMapper;

    @Override
    public void takeAttendance(Long scannerId, ScanPayload scanPayload) {
        Scanner scanner = scannerRepository.findById(scannerId)
                .orElseThrow(() -> new ResourceNotFoundException("Scanner not found with id: " + scannerId));
        Member member = memberRepository.findByBarcode(scanPayload.getMemberBarcode())
                .orElseThrow(() -> new ResourceNotFoundException("Member not found with id: " + scanPayload.getMemberBarcode()));
        Session session = sessionRepository.findById(scanPayload.getSessionId())
                .orElseThrow(() -> new ResourceNotFoundException("Session not found with id: " + scanPayload.getSessionId()));
        Record record = new Record(member, scanner, session);
        recordMapper.map(recordRepository.save(record));

    }
}
