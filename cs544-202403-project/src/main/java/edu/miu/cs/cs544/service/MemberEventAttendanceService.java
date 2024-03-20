package edu.miu.cs.cs544.service;

import edu.miu.cs.cs544.domain.Record;

import java.util.List;

public interface MemberEventAttendanceService {
    List<Object> getMemberEventAttendance(Long memberId,Long eventId);
}
