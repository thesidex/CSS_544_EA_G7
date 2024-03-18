package edu.miu.cs.cs544.service.contract;

import edu.miu.cs.cs544.domain.Session;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Set;

@Data
public class SchedulePayload implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private LocalTime startTime;
    private LocalTime endTime;
    private String weekDays;
    private String scheduleName;
    private Set<Session> sessions;

}
