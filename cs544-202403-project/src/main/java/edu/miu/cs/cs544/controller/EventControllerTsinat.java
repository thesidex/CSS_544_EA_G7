package edu.miu.cs.cs544.controller;

import edu.miu.common.controller.BaseReadWriteController;
import edu.miu.cs.cs544.domain.Event;
import edu.miu.cs.cs544.domain.Record;  // Import your Record entity here
import edu.miu.cs.cs544.service.EventService;
import edu.miu.cs.cs544.service.contract.EventPayload;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/eventsTsinat")
public class EventControllerTsinat extends BaseReadWriteController<EventPayload, Event, Long> {

    private final EventService eventService;

    public EventControllerTsinat(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/{eventId}/Record")
    public ResponseEntity<List<Record>> calculateRecord(@PathVariable Long eventId) {
        List<Record> recordList = eventService.calculateRecord(eventId);
        if (recordList.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(recordList);
        }
    }
}
