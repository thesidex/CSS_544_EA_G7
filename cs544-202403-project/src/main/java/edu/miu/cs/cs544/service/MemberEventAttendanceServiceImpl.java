package edu.miu.cs.cs544.service;
import edu.miu.cs.cs544.repository.RecordRepository;
import edu.miu.cs.cs544.service.contract.MissedSessionPayload;
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
    public List<MissedSessionPayload> getMemberEventAttendance(Long memberId, Long eventId) {
        List<SessionPayload> sessions = sessionService.getSessionsByEventId(eventId);
        List<Record> records = recordRepository.getRecordFromMemberId(memberId);

        Set<Long> sessionIdsFromSessions = sessions.stream()
                .map(SessionPayload::getId)
                .collect(Collectors.toSet());

        Set<Long> sessionIdsFromRecords = records.stream()
                .map(record -> record.getSession().getId())
                .collect(Collectors.toSet());

        int totalSessions = sessionIdsFromSessions.size();
        int totalSessionsAttended = sessionIdsFromRecords.size();

        sessionIdsFromSessions.removeAll(sessionIdsFromRecords);
        List<Long> missingSessionIds = new ArrayList<>(sessionIdsFromSessions);

        System.out.println("Total sessions: " + totalSessions);
        System.out.println("Total sessions attended: " + totalSessionsAttended);
        System.out.println("Missing session IDs from records: " + missingSessionIds);

        // Generating object output
        List<MissedSessionPayload> missedSessions = new ArrayList<>();
        for (Long sessionId : missingSessionIds) {
            MissedSessionPayload missedSessionPayload = new MissedSessionPayload();
            missedSessionPayload.setTotalSessionsPresent(totalSessions);
            missedSessionPayload.setTotalSessionsAttended(totalSessionsAttended);
            List<MissedSessionPayload.SessionInfo> missedSessionInfos = new ArrayList<>();
            for (SessionPayload session : sessions) {
                if (session.getId().equals(sessionId)) {
                    MissedSessionPayload.SessionInfo sessionInfo = new MissedSessionPayload.SessionInfo();
                    sessionInfo.setSessionId(session.getId());
                    sessionInfo.setTiming(session.getDate().atStartOfDay());
                    missedSessionInfos.add(sessionInfo);
                }
            }
            missedSessionPayload.setMissedSessions(missedSessionInfos);
            missedSessions.add(missedSessionPayload);
        }

        return missedSessions;
    }
}
