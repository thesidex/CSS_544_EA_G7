package edu.miu.cs.cs544.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import edu.miu.cs.cs544.domain.*;
import edu.miu.cs.cs544.domain.Record;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import edu.miu.common.exception.ResourceNotFoundException;
import edu.miu.cs.cs544.repository.MemberRepository;
import edu.miu.cs.cs544.repository.RecordRepository;
import edu.miu.cs.cs544.repository.RegistrationRepository;
import edu.miu.cs.cs544.repository.ScannerRepository;
import edu.miu.cs.cs544.repository.SessionRepository;
import edu.miu.cs.cs544.service.contract.ScanPayload;

@RunWith(MockitoJUnitRunner.class)
public class MemberServiceImplTest {

    @Mock
    private ScannerRepository scannerRepository;

    @Mock
    private SessionRepository sessionRepository;

    @Mock
    private MemberRepository memberRepository;

    @Mock
    private RecordRepository recordRepository;

    @Mock
    private RegistrationRepository registrationRepository;

    @InjectMocks
    private MemberServiceImpl memberService;

    private Member testMember;
    private Scanner testScanner;
    private Session testSession;
    private ScanPayload testScanPayload;

    @Before
    public void setUp() {
        testMember = new Member();
        testScanner = new Scanner();
        testSession = new Session();
        testScanPayload = new ScanPayload();
        memberService = new MemberServiceImpl(scannerRepository,sessionRepository,memberRepository,recordRepository,registrationRepository);
    }

    @Test
    public void takeAttendance_SuccessfulAttendance() {
        // Arrange
        Long scannerId = 1L;
        testScanPayload.setMemberBarcode("123456789");
        testScanPayload.setSessionId(1L);
        Event event = new Event();
        testScanner.setEvent(event);
        EventRegistrationId eventRegistrationId = new EventRegistrationId(testMember.getId(), testScanner.getEvent().getId());

        when(scannerRepository.findById(scannerId)).thenReturn(Optional.of(testScanner));
        when(memberRepository.findByBarcode(testScanPayload.getMemberBarcode())).thenReturn(Optional.of(testMember));
        when(sessionRepository.findById(testScanPayload.getSessionId())).thenReturn(Optional.of(testSession));
        when(registrationRepository.existsById(eventRegistrationId)).thenReturn(true);
        when(recordRepository.existsByMemberAndSession(any(), any())).thenReturn(false);

        // Act
        memberService.takeAttendance(scannerId, testScanPayload);

        // Assert
        verify(recordRepository, times(1)).save(any(Record.class));
    }
}
