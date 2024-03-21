//package edu.miu.cs.cs544.service;
//
//import edu.miu.common.exception.ResourceNotFoundException;
//import edu.miu.cs.cs544.domain.Event;
//import edu.miu.cs.cs544.domain.Schedule;
//import edu.miu.cs.cs544.domain.Session;
//import edu.miu.cs.cs544.repository.ScheduleRepository;
//import edu.miu.cs.cs544.repository.SessionRepository;
//import edu.miu.cs.cs544.service.contract.SessionRequestPayload;
//import edu.miu.cs.cs544.service.mapper.SessionToSessionPayloadMapper;
//import static org.mockito.Mockito.verify;
//
//import java.util.Optional;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.TestConfiguration;
//import org.springframework.context.annotation.Bean;
//import org.springframework.boot.test.mock.mockito.MockBean;
//
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.time.DayOfWeek;
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.util.HashSet;
//import java.util.Set;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.*;
//
//@RunWith(SpringRunner.class)
// public class SessionServiceImplTest {
//
//    @TestConfiguration
//    static class SessionServiceTestContextConfiguration {
//        @Bean
//        public SessionServiceImpl sessionServiceImpl() {
//            return new SessionServiceImpl();
//        }
//    }
//
//    @Autowired
//    private SessionServiceImpl sessionService;
//
//    @MockBean
//    private SessionRepository sessionRepository;
//
//    @MockBean
//    private ScheduleRepository scheduleRepository;
//
//    @Mock
//    private SessionToSessionPayloadMapper sessionMapper;
//
//    @Before
//     public void setUp() {
//        MockitoAnnotations.initMocks(this);
//    }
//
//    @Test
//     public void addSessionToEvent_ValidSchedule_ReturnsSessionPayload() {
//        Long eventId = 1L;
//        Long scheduleId = 1L;
//        LocalDate date = LocalDate.now();
//        Set<DayOfWeek> weekDays = new HashSet<>();
//        weekDays.add(DayOfWeek.MONDAY);
//        Schedule schedule = new Schedule();
//        schedule.setId(scheduleId);
////        schedule.setWeekDays(weekDays);
//        Event event = new Event("Event Name", "Event Description", LocalDateTime.now(), LocalDateTime.now().plusHours(2), null, null);
//        schedule.setEvent(event);
//        Optional<Schedule> scheduleOptional=Optional.of(schedule);
//
//        // Mock repository behavior
//        Mockito.when(scheduleRepository.findById(scheduleId)).thenReturn(scheduleOptional);
//        Mockito.when(sessionRepository.save(any(Session.class))).thenAnswer(invocation -> invocation.getArgument(0));
//
//        // Perform the test
//        SessionRequestPayload sessionRequestPayload = new SessionRequestPayload();
//        sessionRequestPayload.setScheduleId(scheduleId);
//        sessionRequestPayload.setDate(date);
//
//        Session session = new Session();
//        session.setSchedule(schedule);
//        session.setDate(date);
//
//        // Verify
//        assertEquals(sessionMapper.map(session), sessionService.addSessionToEvent(eventId, sessionRequestPayload));
//        verify(sessionRepository, times(1)).save(any(Session.class));
//    }
//
//    @Test
//    public void addSessionToEvent_InvalidSchedule_ThrowsResourceNotFoundException() {
//        // Mock data
//        Long eventId = 1L;
//        Long invalidScheduleId = 99L;
//        LocalDate date = LocalDate.now();
//
//        // Mock repository behavior
//        when(scheduleRepository.findById(invalidScheduleId)).thenReturn(Optional.empty());
//
//        // Perform the test
//        SessionRequestPayload sessionRequestPayload = new SessionRequestPayload();
//        sessionRequestPayload.setScheduleId(invalidScheduleId);
//        sessionRequestPayload.setDate(date);
//
//        // Verify
//        assertThrows(ResourceNotFoundException.class, () -> sessionService.addSessionToEvent(eventId, sessionRequestPayload));
//        verify(sessionRepository, never()).save(any(Session.class));
//    }
//}
//
