package edu.miu.cs.cs544.service.contract;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

@RestController
@RequestMapping("events/{eventId}/sessions")
public class SchedulePayload implements Serializable {
    private static final long serialVersionUID = 1L;
}
