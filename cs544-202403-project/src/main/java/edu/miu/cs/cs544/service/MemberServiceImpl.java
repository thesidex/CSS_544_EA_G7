    package edu.miu.cs.cs544.service;

    import edu.miu.cs.cs544.domain.Record;
    import edu.miu.cs.cs544.domain.Scanner;
    import edu.miu.cs.cs544.domain.Session;
    import edu.miu.cs.cs544.repository.MemberRepository;
    import edu.miu.cs.cs544.repository.RecordRepository;
    import edu.miu.cs.cs544.repository.ScannerRepository;
    import edu.miu.cs.cs544.repository.SessionRepository;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;

    import edu.miu.common.service.BaseReadWriteServiceImpl;
    import edu.miu.cs.cs544.domain.Member;
    import edu.miu.cs.cs544.service.contract.MemberPayload;

    @Service
    public class MemberServiceImpl extends BaseReadWriteServiceImpl<MemberPayload, Member, Long> implements MemberService {

        @Autowired
        private ScannerRepository scannerRepository;
        @Autowired
        private SessionRepository sessionRepository;
        @Autowired
        private MemberRepository memberRepository;
        @Autowired
        private RecordRepository recordRepository;

        @Override
        public void takeAttendance(Long scannerId, String memberBarcode, Long sessionId) {
            Scanner scanner = scannerRepository.getReferenceById(scannerId);
            Member member = memberRepository.findByBarcode(memberBarcode).orElseThrow();
            Session session = sessionRepository.getReferenceById(sessionId);
            Record record = new Record(member, scanner, session);
            recordRepository.save(record);
        }
    }
