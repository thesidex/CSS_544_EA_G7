package edu.miu.cs.cs544.controller;


import edu.miu.common.controller.BaseReadWriteController;
import edu.miu.cs.cs544.domain.Schedule;
import edu.miu.cs.cs544.service.ScheduleService;
import edu.miu.cs.cs544.service.contract.SchedulePayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/schedules")
public class ScheduleController  extends BaseReadWriteController<SchedulePayload, Schedule, Long> {
    @Autowired
    private ScheduleService scheduleService;
    @PostMapping("/add/{eventId}")
    public ResponseEntity<?> addScheduleForEvent(@PathVariable Long eventId, @RequestBody SchedulePayload schedulePayload) {
        try {
            Schedule createdSchedule = scheduleService.createScheduleForEvent(eventId, schedulePayload);
            return new ResponseEntity<>(createdSchedule, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
