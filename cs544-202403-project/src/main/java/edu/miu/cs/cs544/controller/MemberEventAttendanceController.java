package edu.miu.cs.cs544.controller;

import edu.miu.cs.cs544.domain.Record;
import edu.miu.cs.cs544.repository.RecordRepository;
import edu.miu.cs.cs544.service.MemberEventAttendanceService;
import edu.miu.cs.cs544.service.contract.MissedSessionPayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/members/{memberId}/events/{eventId}/attendance")
public class MemberEventAttendanceController {
    @Autowired
    MemberEventAttendanceService memberEventAttendanceService;

    @GetMapping
    public ResponseEntity<?> getMemberEventAttendance(
            @PathVariable Long memberId,
            @PathVariable Long eventId) {

        List<MissedSessionPayload> attendance = memberEventAttendanceService.getMemberEventAttendance(memberId, eventId);

        if (attendance != null) {
            return ResponseEntity.ok(attendance);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

