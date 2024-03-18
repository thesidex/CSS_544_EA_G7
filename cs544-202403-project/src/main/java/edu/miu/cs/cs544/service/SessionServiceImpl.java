package edu.miu.cs.cs544.service;

import edu.miu.common.exception.ResourceNotFoundException;
import edu.miu.common.service.BaseReadWriteServiceImpl;
import edu.miu.cs.cs544.domain.Schedule;
import edu.miu.cs.cs544.domain.Session;
//import edu.miu.cs.cs544.repository.EventRepository;
import edu.miu.cs.cs544.repository.ScheduleRepository;
import edu.miu.cs.cs544.repository.SessionRepository;
import edu.miu.cs.cs544.service.contract.SessionPayload;
import edu.miu.cs.cs544.service.contract.SessionRequestPayload;
import edu.miu.cs.cs544.service.mapper.SessionToSessionPayloadMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SessionServiceImpl extends BaseReadWriteServiceImpl<SessionPayload, Session, Long> implements SessionService {

    @Autowired
    private SessionRepository sessionRepository;

    @Autowired
    private SessionToSessionPayloadMapper sessionMapper;

//    @Autowired
//    private EventRepository eventRepository;

    @Autowired
    private ScheduleRepository scheduleRepository;

    public List<SessionPayload> getSessionsByEventId(Long eventId) {
        List<Session> sessions = sessionRepository.findByEventId(eventId);
        return sessions.stream()
                .map(session -> sessionMapper.customMapping(session))
                .collect(Collectors.toList());
    }

    public SessionPayload addSessionToEvent(Long eventId, SessionRequestPayload sessionRequestPayload) {
//        Event event = eventRepository.findById(eventId)
//                .orElseThrow(() -> new ResourceNotFoundException("Event not found with id: " + eventId));
        Schedule schedule = scheduleRepository.findById(sessionRequestPayload.getScheduleId())
                .orElseThrow(() -> new ResourceNotFoundException("Schedule not found with id: " + sessionRequestPayload.getScheduleId()));
        Session session = new Session();

        session.setSchedule(schedule);
        session.setDate(sessionRequestPayload.getDate());
        Set<DayOfWeek> weekDays = schedule.getWeekDays();
        DayOfWeek sessionDayOfWeek = sessionRequestPayload.getDate().getDayOfWeek();
        try {
            if (weekDays.contains(sessionDayOfWeek)) {
                session = sessionRepository.save(session);
                return sessionMapper.map(session);
            }
        } catch (Exception ex) {
            throw new RuntimeException("An error occurred while processing the session request.", ex);
        }
        return null;
    }
    public SessionPayload updateSession(Long eventId, Long sessionId, SessionRequestPayload sessionRequestPayload) {
        Session session = sessionRepository.findById(sessionId)
                .orElseThrow(() -> new ResourceNotFoundException("Session not found with id: " + sessionId));

        if (!session.getSchedule().getEvent().getId().equals(eventId)) {
            throw new ResourceNotFoundException("Session with id " + sessionId + " does not belong to event with id " + eventId);
        }

        session.setDate(sessionRequestPayload.getDate());
        session = sessionRepository.save(session);

        return sessionMapper.map(session);
    }

    public void deleteSession(Long eventId, Long sessionId) {
        Session session = sessionRepository.findById(sessionId)
                .orElseThrow(() -> new ResourceNotFoundException("Session not found with id: " + sessionId));

        if (!session.getSchedule().getEvent().getId().equals(eventId)) {
            throw new ResourceNotFoundException("Session with id " + sessionId + " does not belong to event with id " + eventId);
        }

        sessionRepository.delete(session);
    }
}