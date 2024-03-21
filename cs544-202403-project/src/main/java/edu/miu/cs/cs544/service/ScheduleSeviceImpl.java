package edu.miu.cs.cs544.service;

import edu.miu.common.service.BaseReadWriteServiceImpl;
import edu.miu.cs.cs544.domain.Event;
import edu.miu.cs.cs544.domain.Schedule;
import edu.miu.cs.cs544.domain.ScheduleDayOfWeek;
import edu.miu.cs.cs544.domain.Session;
import edu.miu.cs.cs544.repository.EventRepository;
import edu.miu.cs.cs544.repository.ScheduleRepository;
import edu.miu.cs.cs544.service.contract.SchedulePayload;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class ScheduleSeviceImpl extends BaseReadWriteServiceImpl<SchedulePayload, Schedule, Long> implements ScheduleService{
    @Autowired
    EventRepository eventRepository;
    @Autowired
    ScheduleRepository scheduleRepository;
    public Schedule createScheduleForEvent(Long eventId, SchedulePayload schedulePayload) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new EntityNotFoundException("Event not found with ID: " + eventId));
        Set<ScheduleDayOfWeek> scheduleDayOfWeeks = new HashSet<>();
        scheduleDayOfWeeks.addAll(schedulePayload.getScheduleDayOfWeeks());
        Schedule schedule = new Schedule();
        schedule.setStartTime(schedulePayload.getStartTime());
        schedule.setEndTime(schedulePayload.getEndTime());
        schedule.setScheduleName(schedulePayload.getScheduleName());
        schedule.setEvent(event);
        schedule.setScheduleDayOfWeeks(scheduleDayOfWeeks);
        Set<Session> sessions = new HashSet<>();
        for (Session sessionPayload : schedulePayload.getSessions()) {
            Session session = new Session();
            session.setDate(sessionPayload.getDate());
            session.setSchedule(schedule);
            sessions.add(session);
        }
        schedule.setSessions(sessions);
        return scheduleRepository.save(schedule);
    }
}
