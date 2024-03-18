//package edu.miu.cs.cs544.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/members/{memberId}/events/{eventId}/attendance")
//public class MemberEventAttendanceController {
//
//    @Autowired
//    private AttendanceService attendanceService;
//
//    @GetMapping
//    public ResponseEntity<?> getMemberEventAttendance(
//            @PathVariable Long memberId,
//            @PathVariable Long eventId) {
//
//        AttendancePayload attendance = attendanceService.getMemberEventAttendance(memberId, eventId);
//
//        if (attendance != null) {
//            return ResponseEntity.ok(attendance);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//}
//
