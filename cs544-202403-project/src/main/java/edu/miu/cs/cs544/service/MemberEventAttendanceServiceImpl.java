package edu.miu.cs.cs544.service;
import edu.miu.cs.cs544.repository.RecordRepository;
import edu.miu.cs.cs544.service.contract.SessionPayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.miu.cs.cs544.domain.Record;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MemberEventAttendanceServiceImpl implements MemberEventAttendanceService {
    @Autowired
    SessionService sessionService;
    @Autowired
    RecordRepository recordRepository;
    @Override
    public List<Object> getMemberEventAttendance(Long memberId, Long eventId) {
        List<SessionPayload> sessions=sessionService.getSessionsByEventId(eventId);
        List<Record> records =recordRepository.getRecordFromMemberId(memberId);
        Set<Long> sessionIdsFromSessions = sessions.stream()
                .map(SessionPayload::getId)
                .collect(Collectors.toSet());

//        Set<Long> sessionIdsFromRecords = records.stream()
//                .map((Record::getSession_id))
//                .collect(Collectors.toSet());
//
//        int totalSessions = sessionIdsFromSessions.size();
//
//         sessionIdsFromSessions.removeAll(sessionIdsFromRecords);
//         List<Long> missingSessionIds = new ArrayList<>(sessionIdsFromSessions);
//         System.out.println("Total sessions: " + totalSessions);
//         System.out.println("Missing session IDs from records: " + missingSessionIds);

        return null;

    }
}
