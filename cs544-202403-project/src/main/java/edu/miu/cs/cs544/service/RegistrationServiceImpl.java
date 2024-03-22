package edu.miu.cs.cs544.service;

import edu.miu.common.exception.ResourceNotFoundException;
import edu.miu.common.service.BaseReadWriteServiceImpl;
import edu.miu.cs.cs544.domain.*;
import edu.miu.cs.cs544.domain.Record;
import edu.miu.cs.cs544.repository.*;
import edu.miu.cs.cs544.service.contract.RecordPayload;
import edu.miu.cs.cs544.service.contract.RecordRequestPayload;
import edu.miu.cs.cs544.service.contract.RegistrationPayload;
import edu.miu.cs.cs544.service.mapper.RecordToRecordPayloadMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class RegistrationServiceImpl extends BaseReadWriteServiceImpl<RegistrationPayload, Registration, EventRegistrationId> implements RegistrationService {

    @Autowired
    RegistrationRepository registrationRepository;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    EventRepository eventRepository;

    public RegistrationServiceImpl(RegistrationRepository registrationRepository, MemberRepository memberRepository, EventRepository eventRepository) {
        this.registrationRepository = registrationRepository;
        this.memberRepository = memberRepository;
        this.eventRepository = eventRepository;
    }

    public RegistrationServiceImpl(){};



    @Override
    public void registerEvent(Long memberId, Long eventId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new ResourceNotFoundException("Member is not found with id: " + memberId));
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new ResourceNotFoundException("Event is not found with id: " + eventId));
        EventRegistrationId registrationId = new EventRegistrationId(memberId, eventId);
        Registration registration = new Registration(member, event);
        registration.setId(registrationId);
        registrationRepository.save(registration);
    }
}
