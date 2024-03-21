package edu.miu.cs.cs544.controller;

import edu.miu.common.controller.BaseReadWriteController;
import edu.miu.cs.cs544.domain.Event;
import edu.miu.cs.cs544.service.AccountService;
import edu.miu.cs.cs544.service.contract.AccountPayload;
import edu.miu.cs.cs544.service.contract.AttendancePayload;
import edu.miu.cs.cs544.service.contract.EventPayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/events")
public class EventController extends BaseReadWriteController<EventPayload, Event, Long> {
}
