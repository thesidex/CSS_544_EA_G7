package edu.miu.cs.cs544.service;

import edu.miu.cs.cs544.domain.Record;
import edu.miu.cs.cs544.service.contract.MissedSessionPayload;

import java.util.List;

public interface MemberEventAttendanceService {
    List<MissedSessionPayload> getMemberEventAttendance(Long memberId, Long eventId);
}
