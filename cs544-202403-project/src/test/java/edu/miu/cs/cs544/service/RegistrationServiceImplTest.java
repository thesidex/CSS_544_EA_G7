package edu.miu.cs.cs544.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import edu.miu.common.exception.ResourceNotFoundException;
import edu.miu.cs.cs544.domain.Event;
import edu.miu.cs.cs544.domain.Member;
import edu.miu.cs.cs544.domain.Registration;
import edu.miu.cs.cs544.repository.EventRepository;
import edu.miu.cs.cs544.repository.MemberRepository;
import edu.miu.cs.cs544.repository.RegistrationRepository;

@RunWith(MockitoJUnitRunner.class)
public class RegistrationServiceImplTest {

    @Mock
    private RegistrationRepository registrationRepository;

    @Mock
    private MemberRepository memberRepository;

    @Mock
    private EventRepository eventRepository;

    @InjectMocks
    private RegistrationServiceImpl registrationService;

    private Member testMember;
    private Event testEvent;

    @Before
    public void setUp() {
        testMember = new Member();
        testEvent = new Event();
        registrationService = new RegistrationServiceImpl(registrationRepository,memberRepository,eventRepository);
    }

    @Test
    public void registerEvent_SuccessfulRegistration() {
        Long memberId = 1L;
        Long eventId = 1L;

        when(memberRepository.findById(memberId)).thenReturn(Optional.of(testMember));
        when(eventRepository.findById(eventId)).thenReturn(Optional.of(testEvent));

        registrationService.registerEvent(memberId, eventId);

        verify(registrationRepository, times(1)).save(any(Registration.class));
    }
}
